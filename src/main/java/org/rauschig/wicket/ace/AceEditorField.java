/**
 *    Copyright 2014 Thomas Rausch
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.rauschig.wicket.ace;

import static org.rauschig.wicketjs.jquery.JQuery.$;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.rauschig.wicket.ace.js.JsAceEditor;
import org.rauschig.wicket.ace.resource.AceResourceLocator;
import org.rauschig.wicket.ace.resource.IAceResourceLocator;
import org.rauschig.wicketjs.IJavaScript;
import org.rauschig.wicketjs.JsCall;
import org.rauschig.wicketjs.JsCallChain;
import org.rauschig.wicketjs.JsFunction;
import org.rauschig.wicketjs.JsIdentifier;
import org.rauschig.wicketjs.JsStatements;
import org.rauschig.wicketjs.JsVariableDefinition;
import org.rauschig.wicketjs.behavior.JsBehavior;
import org.rauschig.wicketjs.util.options.Options;

/**
 * AceEditorField
 */
public class AceEditorField<T> extends TextArea<T> {

    private static final long serialVersionUID = 1L;

    /**
     * JS interface
     */
    protected JsAceEditor editor;

    /**
     * Options
     */
    private AceConfig options;

    /**
     * Resource locator for locating ace resources (themes, modes, workers)
     */
    private IAceResourceLocator aceResourceLocator;

    public AceEditorField(String id) {
        this(id, new AceConfig());
    }

    public AceEditorField(String id, String mode, String theme) {
        this(id, new AceConfig(mode, theme));
    }

    public AceEditorField(String id, AceConfig options) {
        this(id, null, options);
    }

    public AceEditorField(String id, IModel<T> model) {
        this(id, model, new AceResourceLocator());
    }

    public AceEditorField(String id, IModel<T> model, IAceResourceLocator aceResourceLocator) {
        this(id, model, new AceConfig(), aceResourceLocator);
    }

    public AceEditorField(String id, IModel<T> model, AceConfig options) {
        this(id, model, options, new AceResourceLocator());
    }

    public AceEditorField(String id, IModel<T> model, AceConfig options, IAceResourceLocator aceResourceLocator) {
        super(id, model);
        this.options = options;
        this.aceResourceLocator = aceResourceLocator;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        setOutputMarkupId(true);

        editor = new JsAceEditor(getMarkupId() + "_editor");

        add(new JsBehavior() {
            private static final long serialVersionUID = 1L;

            @Override
            protected IJavaScript domReadyJs() {
                String editDiv = "div_" + editor.getIdentifier();
                JsIdentifier textarea = new JsIdentifier("textarea_" + editor.getIdentifier());

                return new JsStatements(
                    new JsVariableDefinition(textarea, $(this)),
                    $(textarea).hide(),
                    new JsVariableDefinition(editDiv, new JsCall("$", "<div>", new Options()
                            .set("id", editor.getIdentifier())
                            .set("width", new JsCallChain(textarea).call("width"))
                            .set("height", new JsCallChain(textarea).call("height"))
                            .set("class", new JsCallChain(textarea).call("attr", "class"))
                            .asObject()
                    )),
                    new JsCallChain(editDiv).call("insertBefore", textarea),
                    new JsCallChain(textarea).call("closest", "form").call("submit", new JsFunction(
                            $(textarea).val(editor.getSession().getValue())
                    ))
                );
            }
        });

        if (useWorker()) {
            add(new WorkerConfigurationBehavior());
        }

        add(new AceEditorBehavior());
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        response.render(JavaScriptHeaderItem.forReference(getAceReference()));

        if (getAceResourceLocator().modeExists(options.getMode())) {
            response.render(JavaScriptHeaderItem.forReference(getModeReference()));
        }

        if (getAceResourceLocator().themeExists(options.getTheme())) {
            response.render(JavaScriptHeaderItem.forReference(getThemeReference()));
        }

        if (useWorker()) {
            response.render(JavaScriptHeaderItem.forReference(getWorkerReference()));
        }
    }

    public AceEditorField setOption(String option, Object value) {
        getOptions().set(option, value);
        return this;
    }

    /**
     * Returns the JsAceEditor instance that uses this components id as identifier. This can be used to define frontend
     * js behavior.
     *
     * @return the JsAceEditor instance
     */
    public JsAceEditor getFrontend() {
        return editor;
    }

    public AceConfig getOptions() {
        return options;
    }

    public IAceResourceLocator getAceResourceLocator() {
        return aceResourceLocator;
    }

    public void setAceResourceLocator(IAceResourceLocator aceResourceLocator) {
        this.aceResourceLocator = aceResourceLocator;
    }

    /**
     * Determines whether or not this editor should use a worker (ace's basic syntax checking).
     *
     * @return true if a worker is used and available
     */
    protected boolean useWorker() {
        return ((options.getUseWorker() == null || options.getUseWorker()) && getAceResourceLocator().workerExists(
                options.getMode()));
    }

    protected JavaScriptResourceReference getAceReference() {
        return getAceResourceLocator().getAce();
    }

    protected JavaScriptResourceReference getModeReference() {
        return getAceResourceLocator().getMode(options.getMode());
    }

    protected JavaScriptResourceReference getThemeReference() {
        return getAceResourceLocator().getTheme(options.getTheme());
    }

    protected JavaScriptResourceReference getWorkerReference() {
        return getAceResourceLocator().getWorker(options.getMode());
    }

    protected class WorkerConfigurationBehavior extends JsBehavior {
        private static final long serialVersionUID = 1L;

        @Override
        protected IJavaScript domReadyJs() {
            JsIdentifier config = new JsIdentifier("config_" + id());

            String url = urlFor(getWorkerReference(), getPage().getPageParameters()).toString();

            return new JsStatements(new JsVariableDefinition(config, new JsCall("ace.require", "ace/config")),
                    new JsCallChain(config).call("setModuleUrl", "ace/mode/" + options.getMode() + "_worker", url));
        }
    }

    protected class AceEditorBehavior extends JsBehavior {
        private static final long serialVersionUID = 1L;

        @Override
        protected IJavaScript domReadyJs() {
            return new JsStatements(
                    editor.register(),
                    editor.setOptions(options),
                    editor.setValue($(this).val())
            );
        }

    }
}

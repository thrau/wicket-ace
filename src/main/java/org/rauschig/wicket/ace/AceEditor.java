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

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.rauschig.wicket.ace.js.JsAceEditor;
import org.rauschig.wicket.ace.resource.AceResourceLocator;
import org.rauschig.wicket.ace.resource.IAceResourceLocator;
import org.rauschig.wicketjs.IJavaScript;
import org.rauschig.wicketjs.JsCall;
import org.rauschig.wicketjs.JsCallChain;
import org.rauschig.wicketjs.JsIdentifier;
import org.rauschig.wicketjs.JsStatements;
import org.rauschig.wicketjs.JsVariableDefinition;
import org.rauschig.wicketjs.behavior.JsBehavior;

/**
 * AceEditor.
 */
public class AceEditor extends WebMarkupContainer {

    private static final long serialVersionUID = 1L;

    /**
     * JS interface
     */
    protected JsAceEditor editor = new JsAceEditor(this);

    /**
     * Options
     */
    private AceConfig options;

    /**
     * Resource locator for locating ace resources (themes, modes, workers)
     */
    private IAceResourceLocator aceResourceLocator;

    public AceEditor(String id) {
        this(id, new AceConfig());
    }

    public AceEditor(String id, String mode, String theme) {
        this(id, new AceConfig(mode, theme));
    }

    public AceEditor(String id, AceConfig options) {
        this(id, null, options);
    }

    public AceEditor(String id, IModel<?> model) {
        this(id, model, new AceResourceLocator());
    }

    public AceEditor(String id, IModel<?> model, IAceResourceLocator aceResourceLocator) {
        this(id, model, new AceConfig(), aceResourceLocator);
    }

    public AceEditor(String id, IModel<?> model, AceConfig options) {
        this(id, model, options, new AceResourceLocator());
    }

    public AceEditor(String id, IModel<?> model, AceConfig options, IAceResourceLocator aceResourceLocator) {
        super(id, model);
        this.options = options;
        this.aceResourceLocator = aceResourceLocator;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        setOutputMarkupId(true);

        if (useWorker()) {
            add(new WorkerConfigurationBehavior());
        }

        add(new AceEditorBehavior());
    }

    public AceEditor setOption(String option, Object value) {
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
                editor.setOptions(options)
            );
        }

        @Override
        protected void onRenderHead(IHeaderResponse response) {
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
    }
}

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
package org.rauschig.wicket.ace.js;

import org.apache.wicket.Component;
import org.rauschig.wicket.ace.AceConfig;
import org.rauschig.wicketjs.IJavaScript;
import org.rauschig.wicketjs.IJsExpression;
import org.rauschig.wicketjs.IJsStatement;
import org.rauschig.wicketjs.JsCall;
import org.rauschig.wicketjs.JsCallChain;
import org.rauschig.wicketjs.JsIdentifier;
import org.rauschig.wicketjs.JsLiteral;
import org.rauschig.wicketjs.JsVariableDefinition;
import org.rauschig.wicketjs.util.options.IOptions;

/**
 * wicket-js fluent-interface for creating java-script statements for the ace editor.
 */
public class JsAceEditor extends JsIdentifier {
    private static final long serialVersionUID = 1L;

    public JsAceEditor(Component component) {
        this(component.getMarkupId());
    }

    public JsAceEditor(CharSequence identifier) {
        super(identifier);
    }

    public IJsExpression insert(Object object) {
        return call("insert", object);
    }

    public IJsExpression getCursorPosition() {
        return call("getCursorPosition");
    }

    public IJsExpression getValue() {
        return call("getValue");
    }

    public IJavaScript setValue(Object value) {
        return call("setValue", value);
    }

    public EditSession getSession() {
        return new EditSession(this);
    }

    public IJavaScript setTheme(String theme) {
        return call("setTheme", theme);
    }

    public IJavaScript setOption(String option, Object arg) {
        return call("setOption", option, arg);
    }

    public IJavaScript setOptions(IOptions options) {
        return setOptions(options.asObject());
    }

    public IJavaScript setOptions(AceConfig options) {
        return setOptions(new OptionsConverter().makeOptions(options));
    }

    public IJavaScript setOptions(JsLiteral.JsObject object) {
        return call("setOptions", object);
    }

    public IJsExpression getOption(CharSequence option) {
        return call("getOption", option);
    }

    public JsCallChain call(CharSequence function, Object... args) {
        return new JsCallChain(this).call(function, args);
    }

    /**
     * Returns a JsVariableDefinition that creates a new variable named as this identifier and binds the result of
     * <code>ace.edit('...')</code> to it.
     * 
     * @return a JsVariableDefinition
     */
    public IJsStatement register() {
        return new JsVariableDefinition(this, new JsCall("ace.edit", getIdentifier()));
    }

}

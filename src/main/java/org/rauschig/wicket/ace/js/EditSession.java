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

import org.rauschig.wicketjs.IJavaScript;
import org.rauschig.wicketjs.IJsExpression;
import org.rauschig.wicketjs.JsCallChain;
import org.rauschig.wicketjs.JsFunction;
import org.rauschig.wicketjs.JsIdentifier;

/**
 * JsEditSession.
 */
public class EditSession extends JsCallChain {
    private static final long serialVersionUID = 1L;

    public EditSession(JsAceEditor editor) {
        super(editor);
        call("getSession");
    }

    public JsCallChain insert(Object position, Object text) {
        return call("insert", position, text);
    }

    public JsCallChain setMode(String mode) {
        return call("setMode", mode);
    }

    public JsCallChain setTheme(String theme) {
        return call("setTheme", theme);
    }

    public JsCallChain setValue(Object value) {
        return call("setValue", value);
    }

    public JsCallChain setNewLineMode(String newLineMode) {
        return call("setNewLineMode", newLineMode);
    }

    public JsCallChain setOverwrite(boolean flag) {
        return call("setOverwrite", flag);
    }

    public JsCallChain setTabSize(int tabSize) {
        return call("setTabSize", tabSize);
    }

    public JsCallChain setUseSoftTabs(boolean flag) {
        return call("setUseSoftTabs", flag);
    }

    public JsCallChain setUseWorker(boolean flag) {
        return call("setUseWorker", flag);
    }

    public IJsExpression getUseWorker() {
        return call("getUseWorker");
    }

    public IJsExpression getValue() {
        return call("getValue");
    }

    public IJavaScript on(String event, IJavaScript handlerBody) {
        return on(event, new JsFunction(handlerBody));
    }

    public IJavaScript on(String event, JsFunction handler) {
        if (handler.getParameters().isEmpty()) {
            handler.getParameters().add(new JsIdentifier("e"));
        }

        return call("on", event, handler);
    }

}

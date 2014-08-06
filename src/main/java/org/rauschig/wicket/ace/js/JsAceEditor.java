package org.rauschig.wicket.ace.js;

import org.apache.wicket.Component;
import org.rauschig.wicket.ace.AceConfig;
import org.rauschig.wicketjs.IJavaScript;
import org.rauschig.wicketjs.IJsExpression;
import org.rauschig.wicketjs.JsCallChain;
import org.rauschig.wicketjs.JsIdentifier;
import org.rauschig.wicketjs.JsLiteral;
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

}

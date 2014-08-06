package org.rauschig.wicket.ace.js;

import java.util.Map;

import org.apache.wicket.util.io.IClusterable;
import org.rauschig.wicket.ace.AceConfig;
import org.rauschig.wicketjs.JsLiteral;
import org.rauschig.wicketjs.JsLiteral.JsObject;

/**
 * Used to convert an AceConfig instance into an actual ace-understandable config. Holds all the peculiarities of
 * the java bean/js object binding.
 */
public class OptionsConverter implements IClusterable {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a JsObject from the given AceOptions. Converts parameters if necessary.
     * 
     * @param config the config to convert
     * @return a JsObject literal
     */
    public JsObject makeOptions(AceConfig config) {
        Map<String, Object> map = config.getMap();

        if (config.getTheme() != null) {
            map.put("theme", "ace/theme/" + config.getTheme());
        }
        if (config.getMode() != null) {
            map.put("mode", "ace/mode/" + config.getMode());
        }

        return JsLiteral.of(map);
    }
}

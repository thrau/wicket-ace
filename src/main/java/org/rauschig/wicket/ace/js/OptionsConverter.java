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

import org.apache.wicket.util.io.IClusterable;
import org.apache.wicket.util.value.IValueMap;
import org.apache.wicket.util.value.ValueMap;
import org.rauschig.wicket.ace.AceConfig;
import org.rauschig.wicketjs.JsLiteral;
import org.rauschig.wicketjs.JsLiteral.JsObject;

/**
 * Used to convert an AceConfig instance into an actual ace-understandable config. Holds all the peculiarities of the
 * java bean/js object binding.
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
        IValueMap map = new ValueMap(config.getMap());

        if (config.getTheme() != null) {
            map.put("theme", "ace/theme/" + config.getTheme());
        }
        if (config.getMode() != null) {
            map.put("mode", "ace/mode/" + config.getMode());
        }

        return JsLiteral.of(map);
    }
}

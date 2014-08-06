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
package org.rauschig.wicket.ace.resource;

import java.util.Arrays;

import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.resource.JQueryResourceReference;

/**
 * AceJsResourceReference.
 */
public class AceJsResourceReference extends JavaScriptResourceReference {

    public static final AceJsResourceReference INSTANCE = new AceJsResourceReference();

    private static final long serialVersionUID = 1L;

    public AceJsResourceReference() {
        super(AceJsResourceReference.class, "js/ace.js");
    }

    @Override
    public Iterable<? extends HeaderItem> getDependencies() {
        return Arrays.asList(JavaScriptHeaderItem.forReference(JQueryResourceReference.get()));
    }

    public static AceJsResourceReference get() {
        return INSTANCE;
    }
}

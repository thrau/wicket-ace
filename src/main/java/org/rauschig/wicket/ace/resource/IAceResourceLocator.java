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

import java.io.Serializable;

import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * Interface for locating ace-editor resources.
 */
public interface IAceResourceLocator extends Serializable {

    /**
     * Returns the resource reference for the main ace dependency.
     *
     * @return resource reference
     */
    JavaScriptResourceReference getAce();

    /**
     * Resolves the resource reference for the given ace language mode.
     *
     * @param mode the mode to resolve
     * @return resource reference
     */
    JavaScriptResourceReference getMode(String mode);

    /**
     * Resolves the resource reference for the given ace editor theme.
     *
     * @param theme the theme to resolve
     * @return resource reference
     */
    JavaScriptResourceReference getTheme(String theme);

    /**
     * Resolves the resource reference for the worker of the given ace language mode.
     *
     * @param worker the mode to resolve
     * @return resource reference
     */
    JavaScriptResourceReference getWorker(String worker);

    /**
     * Determines whether the given ace language mode exists.
     * 
     * @param mode the mode
     * @return true if it exists
     */
    boolean modeExists(String mode);

    /**
     * Determines whether the given ace editor theme exists.
     *
     * @param theme the theme
     * @return true if it exists
     */
    boolean themeExists(String theme);

    /**
     * Determines whether the given ace language mode has a corresponding worker.
     *
     * @param mode the mode
     * @return true if a worker exists
     */
    boolean workerExists(String mode);
}

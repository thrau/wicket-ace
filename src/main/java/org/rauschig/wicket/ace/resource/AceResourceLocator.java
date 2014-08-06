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

import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * AceResourceLocator
 */
public class AceResourceLocator {

    protected static final String ROOT_PATH = "js";

    public JavaScriptResourceReference getMode(String mode) {
        return new JavaScriptResourceReference(AceResourceLocator.class, getModePath(mode));
    }

    public JavaScriptResourceReference getTheme(String theme) {
        return new JavaScriptResourceReference(AceResourceLocator.class, getThemePath(theme));
    }

    public JavaScriptResourceReference getWorker(String worker) {
        return new JavaScriptResourceReference(AceResourceLocator.class, getWorkerPath(worker));
    }

    protected String getModePath(String mode) {
        return getRootPath() + "/mode-" + mode + ".js";
    }

    protected String getThemePath(String theme) {
        return getRootPath() + "/theme-" + theme + ".js";
    }

    protected String getWorkerPath(String theme) {
        return getRootPath() + "/worker-" + theme + ".js";
    }

    protected String getRootPath() {
        return ROOT_PATH;
    }
}

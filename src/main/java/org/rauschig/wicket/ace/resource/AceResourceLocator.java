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

import org.apache.wicket.request.resource.JavaScriptPackageResource;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * Default AceResourceLocator.
 */
public class AceResourceLocator implements IAceResourceLocator {

    private static final long serialVersionUID = 1L;

    protected static final String ROOT_PATH = "js";

    private Class<?> scope;

    public AceResourceLocator() {
        this(AceResourceLocator.class);
    }

    public AceResourceLocator(Class<?> scope) {
        this.scope = scope;
    }

    @Override
    public JavaScriptResourceReference getAce() {
        return AceJsResourceReference.get();
    }

    @Override
    public JavaScriptResourceReference getMode(String mode) {
        return new JavaScriptResourceReference(getScope(), getModePath(mode));
    }

    @Override
    public JavaScriptResourceReference getTheme(String theme) {
        return new JavaScriptResourceReference(getScope(), getThemePath(theme));
    }

    @Override
    public JavaScriptResourceReference getWorker(String worker) {
        return new JavaScriptResourceReference(getScope(), getWorkerPath(worker));
    }

    @Override
    public boolean modeExists(String mode) {
        return exists(getModePath(mode));
    }

    @Override
    public boolean themeExists(String theme) {
        return exists(getThemePath(theme));
    }

    @Override
    public boolean workerExists(String mode) {
        return exists(getWorkerPath(mode));
    }

    public Class<?> getScope() {
        return scope;
    }

    protected boolean exists(String path) {
        return JavaScriptPackageResource.exists(getScope(), path, null, null, null);
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

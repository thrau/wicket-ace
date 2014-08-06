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

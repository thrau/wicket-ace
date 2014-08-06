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

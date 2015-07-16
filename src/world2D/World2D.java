/*
 * Copyright 2015 Chris.
 *
 * All rights reserved. For licensing information contact us at cnbrooks36@gmail.com.
 */
package world2D;

import java.util.HashMap;

/**
 * The World2D class contains the information for the world the Bots will
 * simulate in.
 *
 * @author Chris
 */
public class World2D {

    // a map of convenient or interesting properties that devices can scan for or that the world can use internally
    protected HashMap<String, Object> properties;

    // an instance of the World2D for this singleton pattern
    protected static World2D instance;

    /**
     * Creates a default World2D with no obstacle.
     */
    protected World2D() {
        this.properties = new HashMap<>();
        loadDefaultProperties();
    }

    // loads the default properties (if any) into the world. Not sure how/where we'll use this...
    private void loadDefaultProperties() {
        // load an example property for now...
        this.properties.put("WORLD_NAME", "DEFAULT");
    }

    /**
     * Sets the passed String property for this World.
     *
     * @discussion this is not a method that's intended for the implementor to
     * use, it's mostly here for actuators or things that are built into the Bot
     * class to manipulate. If you find yourself calling this method, you might
     * want to step back and see if you're using the paradigm correctly.
     *
     * @param property the property to set
     * @param obj the object to set the property to
     */
    protected void setProperty(String property, Object obj) {
        properties.put(property, obj);
    }

    /**
     * @return an instance of the World2D. If one doesn't exist, creates a
     * default one.
     */
    public static World2D instance() {
        if (instance == null) {
            instance = WorldFactory.getDefaultWorld2D();
        }
        return instance;
    }
}

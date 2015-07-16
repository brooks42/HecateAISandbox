/*
 * Copyright 2015 Chris.
 *
 * All rights reserved. For licensing information contact us at cnbrooks36@gmail.com.
 */
package device;

import java.util.HashMap;

/**
 * The Propertied interface provides a simple way to get a HashMap of
 * <String, Object> pairs.
 *
 * Lots of stuff in this API is Propertied, from Devices to SensorData to Bots.
 *
 * @author Chris
 */
public interface Propertied {

    /**
     * @return this object's properties dictionary
     */
    public abstract HashMap<String, Object> getProperties();
}

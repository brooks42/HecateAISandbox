/*
 * Copyright 2015 Chris.
 *
 * All rights reserved. For licensing information contact us at cnbrooks36@gmail.com.
 */
package device.sensors;

import java.util.HashMap;

/**
 * The SensorData class represents a single set of information from a sensor.
 *
 * As an example, an accelerometer might respond to polls with a SensorData
 * including a Vector3f of its 3D motion, or a Quaternion or its position and
 * rotation.
 *
 * This class is intended to be immutable. For a mutable version, use the
 * MutableSensorData object.
 *
 * @author Chris
 */
public class SensorData {

    // the sensor this data came from
    protected final Sensor parent;
    // this SensorData's actual data objects
    protected final HashMap<String, Object> data;

    /**
     * Creates a new SensorData object
     *
     * @param parent
     * @param data
     */
    public SensorData(Sensor parent, HashMap<String, Object> data) {
        this.parent = parent;
        this.data = data;
    }

    /**
     * @param key the piece of data to get. Cannot be null.
     * @return a piece of data with the passed key, if any. Can return null if
     * the key is unavailable.
     */
    public Object getProperty(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Data key cannot be null");
        }
        return this.data.get(key);
    }

    /**
     * @return the sensor that retrieved this SensorData
     */
    public Sensor getParent() {
        return parent;
    }
}

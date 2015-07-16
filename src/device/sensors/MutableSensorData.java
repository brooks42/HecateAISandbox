/*
 * Copyright 2015 Chris.
 *
 * All rights reserved. For licensing information contact us at cnbrooks36@gmail.com.
 */
package device.sensors;

import device.Propertied;
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
public class MutableSensorData extends SensorData implements Propertied {

    /**
     * Creates a new SensorData object
     *
     * @param parent
     * @param data
     */
    public MutableSensorData(Sensor parent, HashMap<String, Object> data) {
        super(parent, data);
    }

    /**
     * @return all of the properties for this MutableSensorData object.
     */
    @Override
    public HashMap<String, Object> getProperties() {
        return data;
    }
}

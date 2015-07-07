/*
 * Copyright 2015 Chris.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
 * @author Chris
 */
public class SensorData {

    // the sensor this data came from
    private final Sensor parent;
    // this SensorData's actual data objects
    private final HashMap<String, Object> data;

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
}

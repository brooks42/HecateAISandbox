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

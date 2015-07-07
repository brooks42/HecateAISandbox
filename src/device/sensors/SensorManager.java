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

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The SensorManager class maintains a collection of Sensor objects, which you
 * can access via methods and by their various capabilities. You can also
 * register custom devices to the SensorManager and make your bots even more
 * extensible.
 *
 * @author Chris
 */
public class SensorManager {

    protected static HashMap<String, Sensor> sensorNames = new HashMap<>();
    protected static HashMap<HashMap<String, Object>, Sensor> sensorPropertySnapshots = new HashMap<>();

    /**
     * Adds a new sensor to the list of existing ones. With this you can pass
     * your own sensors around and use them in your bots conveniently.
     *
     * @param name the name of the sensor for getting an instance later
     * @param s the sensor itself
     */
    public static void registerSensorType(String name, Sensor s) {
        sensorNames.put(name, s);
        sensorPropertySnapshots.put(s.getProperties(), s);
    }
    

    public static ArrayList<Sensor> queryByCapablities(HashMap<String, Object> capabilities) {
        return null;
    }
}

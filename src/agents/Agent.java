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
package agents;

import device.actuators.Actuator;
import java.util.HashMap;
import device.sensors.SensorData;

/**
 * The Agent base class represents a single, autonomous "unit". In game terms,
 * the Agent would be a player in control of a single vehicle.
 *
 * Agents are intended to be given information from their parent "physical"
 * classes and to use that information to make informed decisions and perform
 * tasks in the Simulation World.
 *
 * @author Chris
 */
public abstract class Agent {

    // for convenient subclassing...
    public Agent() {
    }

    /**
     * Provides a callback method for the agent to perform actuator methods,
     * such as moving the actuator or setting a property in response to data.
     *
     * @param actuatorMap
     */
    public abstract void actuatorPerformance(HashMap<String, Actuator> actuatorMap);

    /**
     * Feeds the passed SensorData object to this Agent.
     *
     * TODO: maybe give this a better name
     *
     * @param data the sensor data object
     */
    public abstract void considerSensorData(SensorData data);
}

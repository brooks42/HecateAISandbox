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
package robots;

import device.Device;
import device.actuators.Actuator;
import device.sensors.Sensor;
import gamish.Updateable;
import java.util.HashMap;
import world2D.WorldEntity;

/**
 * Base class for robots. Think an RTS unit that you can control and train for
 * the sandbox.
 *
 * @author Chris
 */
public class Bot extends WorldEntity implements Updateable {

    // a map of sensors by name
    protected HashMap<String, Sensor> sensors;
    
    // a list of actuators by name
    protected HashMap<String, Actuator> actuators;
    
    // a list of other, miscellaneous devices by name
    protected HashMap<String, Device> devices;

    /**
     * Default constructor, creates a bot with no information.
     */
    public Bot() {
        sensors = new HashMap<>();
        actuators = new HashMap<>();
        devices = new HashMap<>();
    }

    // later we might want to remove this division between actuators, 
    // sensors and "miscellaneous" devices?
    /**
     * Adds the passed Sensor to this Robot.
     *
     * If you add 2 sensors with the same name, the last one will replace the
     * first.
     *
     * @param sensor
     */
    public void addSensor(Sensor sensor) {
        sensors.put(sensor.getName(), sensor);
    }

    /**
     * Adds the passed Actuator to this Robot.
     *
     * If you add 2 actuators with the same name, the last one will replace the
     * first.
     *
     * @param actuator
     */
    public void addActuator(Actuator actuator) {
        actuators.put(actuator.getName(), actuator);
    }

    /**
     * Adds the passed miscellaneous Device to this Robot.
     *
     *
     *
     * @param device
     */
    public void addMiscDevice(Device device) {
        devices.put(device.getName(), device);
    }

    /**
     * Updates this Bot to take actions.
     *
     * @param dt
     */
    @Override
    public void update(long dt) {

    }
}

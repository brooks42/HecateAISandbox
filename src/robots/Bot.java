/*
 * Copyright 2015 Chris.
 *
 * All rights reserved. For licensing information contact us at cnbrooks36@gmail.com.
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
public abstract class Bot extends WorldEntity implements Updateable {

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
     * For most usecases, you'll simply override the Bot's other methods called
     * during the update, such as pollSensors().
     *
     * It's highly recommended that if you override this method, you then call
     * this method as the first line of your override.
     *
     * @param dt
     */
    @Override
    public void update(long dt) {
        pollSensors();
    }

    /**
     * Polls the sensors for this Bot. This occurs once per update by default.
     */
    public abstract void pollSensors();
    
}

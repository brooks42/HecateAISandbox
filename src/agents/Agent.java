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

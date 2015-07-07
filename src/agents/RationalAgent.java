package agents;

import device.actuators.Actuator;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import device.sensors.SensorData;

/**
 * The RationalAgent class represents a base class for agents that adhere to the
 * PEAS model - Performance, Environment, Actuators, Sensors. The class provides
 * a basic structure for performance measurement and rational "thought" in a
 * world where it has only its sensor data.
 *
 * @author Chris
 */
public class RationalAgent extends Agent {

    public final static String PROP_AGENT_NAME = "NAME";

    // this Agent's properties
    private final HashMap<String, Object> properties;

    /**
     * Creates a new RationalAgent with the default properties.
     */
    public RationalAgent() {
        this.properties = new HashMap<>();
        properties.put(PROP_AGENT_NAME, "CLARA");
    }

    /**
     * Creates a new RationalAgent with the passed properties.
     *
     * @param properties a map of string+object pairs to start the agent off
     * with
     */
    public RationalAgent(HashMap<String, Object> properties) {
        if (!properties.containsKey(PROP_AGENT_NAME)) {
            properties.put(PROP_AGENT_NAME, "CLARA");
        }
        this.properties = properties;
    }

    /**
     * Seta the passed property for this RationalAgent to the passed value.
     *
     * @param key the String key for the property. Cannot be null.
     * @param object the object
     */
    public void setProperty(String key, Object object) {
        if (key == null) {
            throw new IllegalArgumentException("Property key cannot be null");
        }
        this.properties.put(key, object);
    }

    /**
     * @param key
     * @return a property with the passed key. Key cannot be null.
     */
    public Object getProperty(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Property key cannot be null");
        }
        return this.properties.get(key);
    }

    /**
     * Calculates this RationalAgent's performance function. This is called once
     * per update and is how the machine makes decisions.
     */
    public void performanceFunction() {
        // by default we'll simply have this agent take no action. By default it's always happy.
    }

    //
    @Override
    public void actuatorPerformance(HashMap<String, Actuator> actuatorMap) {
        Logger.getLogger(this.properties.get(PROP_AGENT_NAME).toString()).log(Level.INFO, "performing actuator method");
    }

    //
    @Override
    public void considerSensorData(SensorData data) {
        Logger.getLogger(this.properties.get(PROP_AGENT_NAME).toString()).log(Level.INFO, "read from sensor: {0}", data.toString());
    }
}

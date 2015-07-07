package actuators;

import java.util.HashMap;

/**
 *
 * @author Chris
 */
public class Actuator {

    // the properties for this Actuator, such as its size, weight, movement 
    // styles, name, etc
    protected HashMap<String, Object> properties;

    /**
     * Creates a default, useless Actuator with no properties
     */
    public Actuator() {
        this.properties = new HashMap<>();
    }

    /**
     * Creates a new Actuator with the passed property map.
     *
     * @param properties the new Actuator's properties
     */
    public Actuator(HashMap<String, Object> properties) {
        this.properties = properties;
    }

    /**
     * @return the Sensor's properties dictionary
     */
    public HashMap<String, Object> getProperties() {
        return this.properties;
    }
}

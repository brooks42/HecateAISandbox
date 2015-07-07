package sensors;

import java.util.HashMap;

/**
 * The Sensor object represents a physical sensor device, such as an
 * accelerometer or a GPS.
 *
 * @author Chris
 */
public class Sensor {

    // the properties for this Sensor, such as its size, weight, arbitrary 
    // sensitivity values or descriptions.
    protected HashMap<String, Object> properties;

    /**
     * Creates a default, useless sensor.
     */
    public Sensor() {
        this.properties = new HashMap<>();
    }

    /**
     * @return the Sensor's properties dictionary
     */
    public HashMap<String, Object> getProperties() {
        return this.properties;
    }
}

package device.sensors;

/**
 * The Pollable interface gives PollableSensors (like accelerometers) a method
 * to pass their data back to a caller.
 *
 * @author Chris
 */
public interface PollableSensor extends Sensor {

    /**
     * @return an Object that represents a piece of data coming from the sensor,
     * such as the value of an axis, or the distance to the nearest object, or
     * an image matrix or a map of the world or a dictionary of stuff that was
     * said to the robot a week ago. Literally anything you want your class to
     * return.
     */
    public abstract Object poll();
}

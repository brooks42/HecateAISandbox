/*
 * Copyright 2015 Chris.
 *
 * All rights reserved. For licensing information contact us at cnbrooks36@gmail.com.
 */
package gamish;

/**
 * The Updateable interface is designed for objects like Sensors and Bots and
 * WorldObjects, that can be updated in step with the "game" clock.
 *
 * @author Chris
 */
public interface Updateable {

    /**
     * Updates this Updateable object.
     *
     * @param dt system time passed since the last discrete "tick" in the world
     */
    public void update(long dt);
}

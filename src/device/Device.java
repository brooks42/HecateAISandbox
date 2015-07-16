/*
 * Copyright 2015 Chris.
 *
 * All rights reserved. For licensing information contact us at cnbrooks36@gmail.com.
 */
package device;

import robots.Bot;

/**
 *
 * @author Chris
 */
public interface Device extends Identifiable, Propertied {

    /**
     * Devices have to have parent bots, which is the robot the device is
     * attached to.
     *
     * @param bot the parent bot. If the device is something like an actuator,
     * this is the bot the actuator will affect/interact with.
     */
    public abstract void setParentBot(Bot bot);
}

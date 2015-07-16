/*
 * Copyright 2015 Chris.
 *
 * All rights reserved. For licensing information contact us at cnbrooks36@gmail.com.
 */
package examples.simplebot;

import device.sensors.PollableSensor;
import java.util.HashMap;
import robots.Bot;

/**
 *
 * @author Chris
 */
public class SimpleBatterySensor implements PollableSensor {

    public static final String NAME_PROP = "Battery Reader";

    protected SimpleBot parent;

    /**
     * Create a new SimpleBatterySensor with the passed parent bot.
     *
     * @param bot
     */
    public SimpleBatterySensor(SimpleBot bot) {
        setParentBot(bot);
    }

    @Override
    public Object poll() {
        return calculateBatteryValue();
    }

    // "calculate" our battery value, we'll basically just ask for the SimpleBot's 
    // battery property. In a more complicated sensor a method like this would get
    // a value from a WorldState or something, but this one is a simple example.
    private int calculateBatteryValue() {
        return (int) parent.battery.getProperties().get(SimpleBattery.CHARGE_PROP);
    }

    @Override
    public final void setParentBot(Bot bot) {
        this.parent = (SimpleBot) bot;
    }

    @Override
    public String getName() {
        return NAME_PROP;
    }

    @Override
    public HashMap<String, Object> getProperties() {
        return new HashMap<>();
    }
}

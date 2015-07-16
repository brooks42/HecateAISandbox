/*
 * Copyright 2015 Chris.
 *
 * All rights reserved. For licensing information contact us at cnbrooks36@gmail.com.
 */
package examples.simplebot;

import robots.Bot;

/**
 * A quick example robot that has a battery sensor (that reads from a battery
 * property) and an actuator that "recharges" the battery.
 *
 * In this example the battery's value is decremented every update - for a real
 * use case, you'd probably either obfuscate away the battery entirely, or for a
 * Softbot you'd have some other algorithm that determines drain rate.
 *
 * @author Chris
 */
public class SimpleBot extends Bot {

    protected SimpleBattery battery;
    private int charge = 0;

    /**
     * Creates a new SampleBot instance with the proper devices built in.
     */
    public SimpleBot() {
        super();

        this.battery = new SimpleBattery(this);
        this.addSensor(new SimpleBatterySensor(this));
        this.addActuator(new SimpleBatteryCharger(this));
    }

    @Override
    public void update(long dt) {
        // here's where we poll our sensors, etc
        super.update(dt);
        
        battery.decrementCharge();

        // now we'll do the robot's logic
        // if the battery is <25% charged, we'll start charging it:
        if (charge < 25) {
            ((SimpleBatteryCharger) actuators.get(SimpleBatteryCharger.NAME_PROP)).startCharging();
        } else if (charge >= 99) {
            ((SimpleBatteryCharger) actuators.get(SimpleBatteryCharger.NAME_PROP)).stopCharging();
        }

        ((SimpleBatteryCharger) actuators.get(SimpleBatteryCharger.NAME_PROP)).update(dt);
    }

    @Override
    public void pollSensors() {
        charge = (int) ((SimpleBatterySensor) sensors.get(SimpleBatterySensor.NAME_PROP)).poll();
    }

    /**
     * @return the String version of this SimpleBot
     */
    @Override
    public String toString() {
        return "Charge: " + charge;
    }
}

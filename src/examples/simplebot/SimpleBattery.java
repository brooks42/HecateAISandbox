/*
 * Copyright 2015 Chris.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package examples.simplebot;

import device.Device;
import java.util.HashMap;
import robots.Bot;

/**
 *
 * @author Chris
 */
public class SimpleBattery implements Device {

    public static final String NAME_PROP = "Battery";
    public static final String CHARGE_PROP = "charge";

    private SimpleBot parent;
    private int charge = 100;

    /**
     * Create a new SimpleBattery with the passed bot as its parent.
     *
     * @param bot
     */
    public SimpleBattery(SimpleBot bot) {
        setParentBot(bot);
    }

    @Override
    public final void setParentBot(Bot bot) {
        this.parent = (SimpleBot) bot;
    }

    /**
     * Called by the SimpleBot when it "uses" "electricity" every update.
     */
    public void decrementCharge() {
        charge--;
    }

    /**
     * Called by the SimpleBatteryCharger to "charge" the "battery". It charges
     * a lot faster than it drains.
     */
    public void incrementCharge() {
        charge += 5;

        // we'll limit charge to a range 0-100, since it's supposed to be 
        // a percentage anyway
        if (charge > 100) {
            charge = 100;
        }
    }

    @Override
    public String getName() {
        return NAME_PROP;
    }

    /**
     * @return the SimpleBattery's charge level.
     */
    @Override
    public HashMap<String, Object> getProperties() {
        HashMap<String, Object> prop = new HashMap<>();
        prop.put(CHARGE_PROP, charge);
        return prop;
    }

}

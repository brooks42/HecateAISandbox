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

import device.actuators.Actuator;
import gamish.Updateable;
import java.util.HashMap;
import robots.Bot;

/**
 *
 * @author Chris
 */
public class SimpleBatteryCharger implements Actuator, Updateable {

    public static final String NAME_PROP = "Battery Charger";

    private SimpleBot parent;
    private boolean charging = false;

    /**
     * Create a new SimpleBatteryCharger tied to the passed robot.
     *
     * @param bot
     */
    public SimpleBatteryCharger(SimpleBot bot) {
        setParentBot(bot);
    }

    /**
     * Tells this Actuator that during its update it should charge the battery.
     */
    public void startCharging() {
        charging = true;
    }
    
    /**
     * Tells this Actuator to stop charging the battery.
     */
    public void stopCharging() {
        charging = false;
    }
    
    /**
     * Charges the battery a little.
     *
     * TODO: in the future this will actually be caused by an ActuatorEvent, at
     * lease that's the intent...
     */
    private void chargeBattery() {
        parent.battery.incrementCharge();
    }

    @Override
    public final void setParentBot(Bot bot) {
        this.parent = (SimpleBot) bot;
    }

    @Override
    public String getName() {
        return NAME_PROP;
    }

    // this is a quick example actuator, so it has no properties
    // TODO: we should probably have some properties here...
    @Override
    public HashMap<String, Object> getProperties() {
        return new HashMap<>();
    }

    @Override
    public void update(long dt) {
        if (charging) {
            chargeBattery();
        }
    }
}

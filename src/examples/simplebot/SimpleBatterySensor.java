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

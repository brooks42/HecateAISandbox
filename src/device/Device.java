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
package device;

import java.util.HashMap;
import robots.Bot;

/**
 *
 * @author Chris
 */
public interface Device extends Identifiable {

    /**
     * @return this Sensor's properties dictionary
     */
    public abstract HashMap<String, Object> getProperties();

    /**
     * Devices have to have parent bots, which is the robot the device is
     * attached to.
     *
     * @param bot the parent bot. If the device is something like an actuator,
     * this is the bot the actuator will affect/interact with.
     */
    public abstract void setParentBot(Bot bot);
}

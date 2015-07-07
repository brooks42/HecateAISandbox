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

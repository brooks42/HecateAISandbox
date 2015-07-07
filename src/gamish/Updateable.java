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

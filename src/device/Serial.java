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

/**
 * The Serial interface provides methods for an implementing device that is
 * "Serial", or rather can talk back and forth with its attached Robot. An
 * example would be any I2C device.
 *
 * @author Chris
 */
public interface Serial {

    /**
     * Writes the passed object to this Serial object. For simplicity in the
     * simulation, this interface obfuscates the actual sending of data.
     *
     * @param obj
     */
    public void write(Object obj);

    /**
     * Gets the next piece of data for this device, if available. It's
     * encouraged that implementing classes have a queue or stack (view the
     * <code>SerialSensor</code> class for an example) that is polled when this
     * method is called, and if the queue is empty that this method returns
     * <code>null</code>.
     *
     * @return the next object in this object's info queue, or null
     */
    public Object read();
}

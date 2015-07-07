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
package hecate;

import fakenetworking.FakePacket;
import fakenetworking.FakeTCP;
import fakenetworking.FakeUDP;
import fakenetworking.PacketTarget;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chris
 */
public class HecateSandboxMk1 {

    private static final int UDP_TEST_NUM = 300;
    private static final int TCP_TEST_NUM = 100;

    volatile boolean canDie = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // test the networking stuff here

        HecateSandboxMk1 mk1 = new HecateSandboxMk1();
        mk1.runPacketTest();
        while (!mk1.canDie) {
            // wait
        }
        Logger.getGlobal().log(Level.INFO, "Successful UDP packets: ({0} / {1})", new Object[]{mk1.successfulUDPPackets, UDP_TEST_NUM});
        Logger.getGlobal().log(Level.INFO, "Successful TCP packets: ({0} / {1})", new Object[]{mk1.successfulTCPPackets, TCP_TEST_NUM});
        Logger.getGlobal().log(Level.INFO, "This concludes our test.");
    }

    int successfulUDPPackets = 0;
    int successfulTCPPackets = 0;

    public void runPacketTest() {
        TestExecutor ex = new TestExecutor() {
            @Override
            public void execute() {
                successfulUDPPackets++;
            }
        };
        TestPacketTarget target = new TestPacketTarget(ex);

        // test UDP
        for (int i = 0; i < UDP_TEST_NUM; i++) {
            FakeUDP udp = new FakeUDP("" + i, target);
            udp.sendToTarget();
        }

        ex = new TestExecutor() {
            @Override
            public void execute() {
                successfulTCPPackets++;
                if (successfulTCPPackets == TCP_TEST_NUM) {
                    canDie = true;
                }
                Logger.getGlobal().log(Level.INFO, "Successful TCP packets: ({0} / {1})", new Object[]{successfulTCPPackets, TCP_TEST_NUM});
            }
        };
        target = new TestPacketTarget(ex);

        // test UDP
        for (int i = 0; i < TCP_TEST_NUM; i++) {
            FakeTCP tcp = new FakeTCP("" + i, target);
            tcp.sendToTarget();
        }
    }

    class TestExecutor {

        public void execute() {
        }
    }

    class TestPacketTarget implements PacketTarget {

        TestExecutor ex;

        public TestPacketTarget(TestExecutor ex) {
            this.ex = ex;
        }

        @Override
        public void receivePacket(FakePacket packet) {
            Logger.getGlobal().log(Level.INFO, "Received packet message: {0}", packet.getMessage());
            ex.execute();
        }
    }
}

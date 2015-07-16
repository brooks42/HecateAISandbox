/*
 * Copyright 2015 Chris.
 *
 * All rights reserved. For licensing information contact us at cnbrooks36@gmail.com.
 */
package hecate;

import examples.simplebot.SimpleBot;

/**
 * This class will act as an example of "building" a robot, creating a world,
 * putting the robot in the world and interacting with it/it interacting with
 * the world.
 *
 * @author Chris
 */
public class HecateSandboxMk1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HecateSandboxMk1 mk1 = new HecateSandboxMk1();

        // for this quick example we'll make a robot with a "battery" sensor 
        // that mimics a battery being drained, and an actuator to charge the battery.
        SimpleBot bot = new SimpleBot();

        // for visuals, we'll just print out the battery level in the robot for 
        // a few iterations, so we get a feel for the robot working
        for (int i = 0; i < 10000; i++) {
            bot.update(1);
            System.out.println(bot.toString());
        }
    }
}

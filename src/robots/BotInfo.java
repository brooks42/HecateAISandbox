/*
 * Copyright 2015 Chris.
 *
 * All rights reserved. For licensing information contact us at cnbrooks36@gmail.com.
 */
package robots;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import util.filesys.BinfSystem;

/**
 * The BotInfo class describes a robot in full - its capabilities, its
 * positions, sensors, actuators, all that stuff - in a nice, compact data
 * structure that's easy to turn into a bot, or store in a file, or read from a
 * file.
 *
 * @author Chris
 */
public class BotInfo {

    // a hashmap of the JSON stored in a .binf file
    // the map's top level contains strings mapped to JSON dictionaries, for 
    // example actuators=>{ }, sensors=>{ }, etc
    protected HashMap<String, Object> properties;

    protected BotInfo() {
        this.properties = new HashMap<>();
    }

    /**
     * Creates a new BotInfo object from the passed Properties map.
     *
     * @param properties
     */
    public BotInfo(HashMap<String, Object> properties) {
        this.properties = properties;
    }

    /**
     * Reads the passed .binf file and returns a BotInfo object.
     *
     * @param file
     * @return a BotInfo object built from the passed .binf
     * @throws java.io.FileNotFoundException if the file isn't found
     * @throws robots.BotInfoParseException if the file isn't a well-formed
     * .binf file.
     *
     * TODO: finish this part...
     */
    public static BotInfo botInfoFromFile(File file) throws FileNotFoundException, BotInfoParseException, IOException {
        BotInfo info = new BotInfo();

        // .binf files should contain at a minimum a single metadata section. 
        // Most bots will also include a section for Actuators and a section for Sensors.
        // crazy bots will contain even more stuff, like maybe a section for Power?
        String fileContent = BinfSystem.getBinfFileContentsAsString(file);

        // okay so the file is laid out like this:
        // Actuators { 
        // }
        // Sensors {
        // }
        // with comments in /* */

        // first, we'll parse out all the c-style comments
        fileContent = fileContent.replaceAll("/\\*(?:.|[\\n\\r])*?\\*/", "");
        
        // so the idea is we start parsing the file at the top level and go down, 
        // parsing out segments and then turning them into JSON as we go
        char[] charArray = fileContent.toCharArray();
        
        // we'll go through character by character and count the brackets. 
        for (int i = 0; i < charArray.length; i++) {

        }

        return info;
    }
}

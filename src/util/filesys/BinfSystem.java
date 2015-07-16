/*
 * Copyright 2015 Chris.
 *
 * All rights reserved. For licensing information contact us at cnbrooks36@gmail.com.
 */
package util.filesys;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Provides a couple of convenient static methods for saving and loading .binf
 * (bot info) files.
 *
 * binfs contain a section for actuators, a section for sensors, and then a
 * section for metadata. After the metadata you could theoretically shove any
 * more data in there for more sections (I dunno, Lisp/GOOL code in the future?
 * Something.).
 *
 * Binf files are designed to be simple enough to understand and de/serialize,
 * but also extensible enough to do basically any kind of bot representation you
 * could need.
 *
 * @author Chris
 */
public class BinfSystem {

    private static final String FILE_EXT = ".binf";

    /**
     * Convenience method to save a binf file with the passed name into the
     * passed directory.
     *
     * @discussion if the directory doesn't exist, we'll try to create it. If
     * creating it fails, we'll return false.
     *
     * @param directory
     * @param name the name for the file. Don't pass ".binf" in the name - if
     * you do, the name'll be cut off at the first ".binf" occurrence.
     * @param data a String that contains the binf's data. You can use the
     * various Binf calls to get this String...
     * @return true if this method has saved the passed data into a file in the
     * passed directory with the passed name (+".binf"). False if any part of
     * that operation fails.
     */
    public static boolean saveAsBinfFile(File directory, String name, String data) {

        // this is fine actually, we'll just use our current directory, but we
        // have to make sure the directory exists if you pass it in
        if (directory != null) {
            // if the directory doesn't exist, we try to make it. If we can't, we fail.
            if (!directory.exists()) {
                if (!directory.mkdirs()) {
                    return false;
                }
            }
        }

        // we never want to let the user save a .binf file as just ".binf", not
        // sure if this is something we'll stick with later but I see no reason 
        // not to enforce it
        if (name == null || name.isEmpty() || name.equals(FILE_EXT) || name.startsWith(FILE_EXT)) {
            throw new IllegalArgumentException("Cannot save to a null or empty file name");
        }

        // trim out ".binf" if it's in there
        if (name.contains(FILE_EXT)) {
            name = name.substring(0, name.indexOf(FILE_EXT));
        }

        name += FILE_EXT;

        // now we append the file extension to the filename, and then write the
        // passed-in contents to that file
        try {
            Path filepath = (directory == null ? Paths.get(name) : Paths.get(directory.getPath(), name));
            Logger.getGlobal().log(Level.INFO, "Writing to file {0}", filepath.toString());
            Files.write(filepath, data.getBytes(), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        } catch (IOException e) {
            Logger.getGlobal().log(Level.INFO, e.getMessage());
            return false;
        }

        return true;
    }

    /**
     * Returns the contents of the passed file (if it's a well-formed .binf
     * file) as a String.
     *
     * @discussion If the file isn't UTF-8 formatted then you're boned, you
     * really should just UTF-8 I guess
     *
     * @param file the file to get. Throws an IllegalArgumentException if the
     * file is null, not a .binf file, or a directory.
     * @return a String containing the contents of the passed file, or null if
     * something happens...
     * @throws java.io.IOException if the file is bad for some other reason than
     * detailed above, or if the file can't be read or something
     */
    public static String getBinfFileContentsAsString(File file) throws IOException {
        if (file == null || file.isDirectory() || !file.getName().endsWith(FILE_EXT)) {
            throw new IllegalArgumentException("Can't read a null file, or a directory or a file that isn't a .binf...");
        }

        byte[] encoded = Files.readAllBytes(Paths.get(file.toURI()));
        return new String(encoded, StandardCharsets.UTF_8);
    }
}

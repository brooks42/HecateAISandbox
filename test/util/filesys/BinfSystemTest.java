/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.filesys;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Chris
 */
public class BinfSystemTest {

    public BinfSystemTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of saveAsBinfFile method, of class BinfSystem.
     */
    @Test
    public void testSaveAsBinfFile() {
        String filename = "test";
        String fileContent = "======one=====two=====three======\n\n\n";

        BinfSystem.saveAsBinfFile(null, filename, fileContent);
        BinfSystem.saveAsBinfFile(null, filename + "2.binf", fileContent);
        
        try {
            BinfSystem.saveAsBinfFile(null, ".binf" + filename + "3.binf", fileContent);
            assert (false);
        } catch (IllegalArgumentException e) {
            // well good, that works
        }

        File dir = new File("dubz");
        BinfSystem.saveAsBinfFile(dir, filename, fileContent);
        BinfSystem.saveAsBinfFile(dir, filename + "2.binf", fileContent);

        try {
            BinfSystem.saveAsBinfFile(dir, ".binf" + filename + "3.binf", fileContent);
            assert (false);
        } catch (IllegalArgumentException e) {
            // well good, that works
        }
        
        try {
            Logger.getLogger(BinfSystemTest.class.getName()).log(Level.INFO, BinfSystem.getBinfFileContentsAsString(new File(filename + ".binf")));
            assert(BinfSystem.getBinfFileContentsAsString(new File(filename + ".binf")).equals(fileContent));
        } catch (IOException ex) {
            Logger.getLogger(BinfSystemTest.class.getName()).log(Level.SEVERE, null, ex);
            assert(false);
        }
    }
}

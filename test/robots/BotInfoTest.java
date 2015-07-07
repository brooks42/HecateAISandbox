/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robots;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Chris
 */
public class BotInfoTest {

    public BotInfoTest() {
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
     * Test of botInfoFromFile method, of class BotInfo.
     */
    @Test
    public void testBotInfoFromFile() throws Exception {
    }

    @Test
    public void testRegexForCommentRemoval() {
        String source = "blah";

        assert (removeCStyleComments(source).equals(source));

        String source2 = "blah/* */";
        assert (removeCStyleComments(source2).equals(source));

        String source3 = "/*asdasd*/blah/*checkem*/";
        System.out.println(removeCStyleComments(source3));
        assert (removeCStyleComments(source3).equals(source));
    }

    public String removeCStyleComments(String sour) {
        return sour.replaceAll("/\\*(?:.|[\\n\\r])*?\\*/", "");
    }
}

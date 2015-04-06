package ua.epam.rd.repository;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import ua.epam.rd.app.RunnerJPA;

public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */

    @org.junit.Test
    public void testApp() {
        RunnerJPA.main(null);
        assertTrue(true);
    }
}
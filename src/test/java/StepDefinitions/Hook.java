package StepDefinitions;

import DriverManager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

    // Initialize Driver
    @Before
    public void driverSetup() {
        DriverManager.getDriver();
    }

    // Close Driver
    @After
    public void teardown() {
        DriverManager.quitDriver();
    }

}

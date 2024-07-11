package StepDefinitions;

import DriverManager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

    @Before
    public void driverSetup() {
        DriverManager.getDriver();
    }

    @After
    public void teardown() {
        DriverManager.quitDriver();
    }

}

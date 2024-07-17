package com.teladoc.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class TeladocHooks {

    WebDriver driver;

    @Before
    public void initializeDriver() {

        driver = DriverHelper.getDriver();
        driver.get("https://www.way2automation.com/angularjs-protractor/webtables/");
        System.out.println("driver initiated");
    }

    @After
    public void tearDown() {
          driver.quit();
    }
}

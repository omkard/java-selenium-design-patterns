package com.factory.pattern.tests;

import com.factory.pattern.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    @Parameters({"browser", "EnvironmentURL"})
    public void setUp(String browser, String EnvironmentURL) {
        driver = DriverFactory.getDriver(browser).createDriver();
        driver.get(EnvironmentURL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

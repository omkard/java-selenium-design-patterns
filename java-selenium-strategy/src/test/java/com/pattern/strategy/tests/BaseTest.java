
package com.pattern.strategy.tests;

import com.pattern.strategy.DriverContext;
import com.pattern.strategy.HeadlessExecutionStrategy;
import com.pattern.strategy.LocalExecutionStrategy;
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
        DriverContext driverContext = new DriverContext(new HeadlessExecutionStrategy());
        driver = driverContext.getDriver(browser);
        driver.get(EnvironmentURL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

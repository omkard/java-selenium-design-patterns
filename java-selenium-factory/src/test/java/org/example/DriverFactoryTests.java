package org.example;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DriverFactoryTests {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver("chrome").createDriver();
    }

    @Test
    public void test1() {
        driver.get("https://www.google.com");
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

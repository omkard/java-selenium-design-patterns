package org.example.tests;


import org.example.manager.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AppTest {

    private WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) {
        driver = WebDriverManager.getInstance(browser).getDriver();

    }

    @Test
    public void test1() {
        driver.get("https://www.google.com");
        Assert.assertEquals("Google", driver.getTitle());
    }

    @AfterClass
    public void tearDown() {
        WebDriverManager.quitBrowser();
    }

}

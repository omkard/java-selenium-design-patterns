package com.pattern.strategy.tests;

import com.pattern.strategy.pages.AUTPage;
import com.pattern.strategy.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StrategyExampleTest extends BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = BaseTest.driver;
        wait = BaseTest.wait;
    }

    @Test
    public void verifyHideShowElement() {
        wait.until(ExpectedConditions.elementToBeClickable(AUTPage.btnHide));
        driver.findElement(AUTPage.btnHide).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(AUTPage.txtToShowOrHide));
        wait.until(ExpectedConditions.elementToBeClickable(AUTPage.btnShow));
        driver.findElement(AUTPage.btnShow).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AUTPage.txtToShowOrHide));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
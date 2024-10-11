package org.example.tests;

import org.example.pages.ButtonClicksPage;
import org.example.pages.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ButtonClickTests extends BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private String mainWindowHandle;

    @BeforeClass
    public void setUp() {
        driver = BaseTest.driver;
        wait = BaseTest.wait;
    }

    @BeforeMethod
    public void switchToButtonClicksPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.lnkButtonClicks));
        mainWindowHandle = driver.getWindowHandle();
        driver.findElement(HomePage.lnkButtonClicks).click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ButtonClicksPage.btnWebElementClick));
    }

    /**
     * Test case to verify button click using WebElement click() method.
     */
    @Test
    public void verifyWebElementButtonClick() {
        driver.findElement(ButtonClicksPage.btnWebElementClick).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                ButtonClicksPage.ModalPopup.popupWebElementClick));
        wait.until(ExpectedConditions.elementToBeClickable(ButtonClicksPage.ModalPopup.btnClosePopup));
        driver.findElement(ButtonClicksPage.ModalPopup.btnClosePopup).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                ButtonClicksPage.ModalPopup.btnClosePopup));
    }

    @Test
    public void verifyJavascriptButtonClick() {
        WebElement element = driver.findElement(ButtonClicksPage.btnJavascriptClick);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                ButtonClicksPage.ModalPopup.popupJavascriptClick));
        wait.until(ExpectedConditions.elementToBeClickable(ButtonClicksPage.ModalPopup.btnClosePopup));
        driver.findElement(ButtonClicksPage.ModalPopup.btnClosePopup).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                ButtonClicksPage.ModalPopup.btnClosePopup));
    }

    @AfterMethod
    public void switchToHomePage() {
        driver.close();
        driver.switchTo().window(mainWindowHandle);
    }

}

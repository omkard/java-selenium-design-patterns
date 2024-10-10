package org.example.tests;

import org.example.manager.WebDriverManager;
import org.example.pages.ContactUsPage;
import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.ArrayList;

public class ContactUsTests {

    private WebDriver driver;
    private WebDriverWait wait;
    private String mainWindowHandle;

    @BeforeClass
    @Parameters({"browser", "EnvironmentURL"})
    public void setUp(String browser, String EnvironmentURL) {
        driver = WebDriverManager.getInstance(browser).getDriver();
        driver.get(EnvironmentURL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @BeforeMethod
    public void switchToContactUsPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.lnkContactUs));
        mainWindowHandle = driver.getWindowHandle();
        driver.findElement(HomePage.lnkContactUs).click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ContactUsPage.txtFirstName));
    }

    /**
     * Open the WebDriver University "Contact Us" page
     * (http://www.webdriveruniversity.com/Contact-Us/contactus.html).
     * Enter a valid first name in the "First Name" field.
     * Enter a valid last name in the "Last Name" field.
     * Enter a valid email address in the "Email" field.
     * Enter a valid message in the "Message" field.
     * Click the "Send Message" button.
     * Verify that a success message is displayed confirming the message submission.
     */
    @Test
    public void verifyValidSubmission() {
        driver.findElement(ContactUsPage.txtFirstName).sendKeys("John");
        driver.findElement(ContactUsPage.txtLastName).sendKeys("Doe");
        driver.findElement(ContactUsPage.txtEmail).sendKeys("johndoe@email.com");
        driver.findElement(ContactUsPage.txtMessage).sendKeys("This is a test message.");

        driver.findElement(ContactUsPage.btnSubmit).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                ContactUsPage.ThankYouPage.lblThanksMessage));
    }

    /**
     * Open the WebDriver University "Contact Us" page
     * (http://www.webdriveruniversity.com/Contact-Us/contactus.html).
     * Enter a valid last name in the "Last Name" field.
     * Enter a valid email address in the "Email" field.
     * Enter a valid message in the "Message" field.
     * Click the "Send Message" button.
     * Verify the error message.
     */
    @Test
    public void verifyInvalidSubmission() {
        driver.findElement(ContactUsPage.txtLastName).sendKeys("Doe");
        driver.findElement(ContactUsPage.txtEmail).sendKeys("johndoe@email.com");
        driver.findElement(ContactUsPage.txtMessage).sendKeys("This is a test message.");

        driver.findElement(ContactUsPage.btnSubmit).click();
        Assert.assertTrue(driver.getPageSource().contains("Error: all fields are required"));
    }

    /**
     * Open the WebDriver University "Contact Us" page
     * (http://www.webdriveruniversity.com/Contact-Us/contactus.html).
     * Enter a valid first name in the "First Name" field.
     * Enter a valid last name in the "Last Name" field.
     * Enter a valid email address in the "Email" field.
     * Enter a valid message in the "Message" field.
     * Click "Reset" button.
     * Verify all text fields should be cleared.
     */
    @Test
    public void verifyResetButton() {
        driver.findElement(ContactUsPage.txtFirstName).sendKeys("John");
        driver.findElement(ContactUsPage.txtLastName).sendKeys("Doe");
        driver.findElement(ContactUsPage.txtEmail).sendKeys("johndoe@email.com");
        driver.findElement(ContactUsPage.txtMessage).sendKeys("This is a test message.");

        driver.findElement(ContactUsPage.btnReset).click();

        Assert.assertTrue(driver.findElement(ContactUsPage.txtFirstName).
                getAttribute("value").equals(""));
        Assert.assertTrue(driver.findElement(ContactUsPage.txtLastName).
                getAttribute("value").equals(""));
        Assert.assertTrue(driver.findElement(ContactUsPage.txtEmail).
                getAttribute("value").equals(""));
        Assert.assertTrue(driver.findElement(ContactUsPage.txtMessage).
                getAttribute("value").equals(""));
    }

    @AfterMethod
    public void switchToHomePage() {
        driver.close();
        driver.switchTo().window(mainWindowHandle);
    }

    @AfterClass
    public void tearDown() {
        WebDriverManager.quitBrowser();
    }

}
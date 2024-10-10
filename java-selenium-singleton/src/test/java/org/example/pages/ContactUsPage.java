package org.example.pages;

import org.openqa.selenium.By;

public class ContactUsPage {

    public static By txtFirstName = By.name("first_name");
    public static By txtLastName = By.name("last_name");
    public static By txtEmail = By.name("email");
    public static By txtMessage = By.name("message");
    public static By btnSubmit = By.xpath("//input[@type='submit']");
    public static By btnReset = By.xpath("//input[@type='reset']");

    public static class ThankYouPage {
        public static By lblThanksMessage = By.xpath("//h1[text()='Thank You for your Message!']");
    }
}

package org.example.pages;

import org.openqa.selenium.By;

public class ButtonClicksPage {

    public static By btnWebElementClick = By.id("button1");
    public static By btnJavascriptClick = By.cssSelector("#button2");
    public static By btnActionsClick = By.id("button3");

    public static class ModalPopup {
        public static By popupWebElementClick = By.cssSelector(".modal-content");
        public static By popupJavascriptClick = By.xpath("//h4[@class='modal-title']");
        public static By btnClosePopup = By.xpath("//button[text()='Close']");
    }
}

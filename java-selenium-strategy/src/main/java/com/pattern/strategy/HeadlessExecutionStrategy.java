package com.pattern.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessExecutionStrategy implements TestExecutionStrategy {
    @Override
    public WebDriver setupDriver(String browserName) {
        switch (browserName.toLowerCase().trim()) {
            case "chrome":
                ChromeOptions cOptions = new ChromeOptions();
                cOptions.addArguments("--headless");
                return new ChromeDriver(cOptions);
            case "firefox":
                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.addArguments("--headless");
                return new FirefoxDriver(fOptions);
            case "edge":
                EdgeOptions eOptions = new EdgeOptions();
                eOptions.addArguments("--headless");
                new EdgeDriver(eOptions);
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
    }
}

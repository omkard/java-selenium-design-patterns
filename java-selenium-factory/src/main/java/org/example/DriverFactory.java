package org.example;

public class DriverFactory {

    public static BrowserDriver getDriver(String browserType) {
        switch (browserType.toLowerCase()) {
            case "chrome":
                return new ChromeDriverManager();
            case "firefox":
                return new FireFoxDriverManager();
            case "edge":
                return new EdgeDriverManager();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }
    }
}

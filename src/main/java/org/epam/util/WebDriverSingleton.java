package org.epam.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.SystemProperties;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class WebDriverSingleton {
    private static final Logger logger = LoggerFactory.getLogger(WebDriverSingleton.class);
    private static final ThreadLocal<WebDriver> threadLocalInstance;
    private static final WebDriverManager manager;

    static {
        String browser = SystemProperties.getProperty("browser");
        if (browser == null || browser.equals("edge")) {
            manager = WebDriverManager.edgedriver();
        } else if (browser.equals("firefox")) {
            manager = WebDriverManager.firefoxdriver();
        } else if (browser.equals("chrome")) {
            manager = WebDriverManager.chromedriver();
        } else
            throw new IllegalArgumentException(browser + " is not supported");
        manager.setup();
        threadLocalInstance = ThreadLocal.withInitial(WebDriverSingleton::createWebDriver);
    }

    public static WebDriver getDriver() {
        if (threadLocalInstance.get() == null) {
            logger.info("Creating a driver");
            threadLocalInstance.set(createWebDriver());
        }
        return threadLocalInstance.get();
    }

    private static WebDriver createWebDriver() {
        WebDriver driver = manager.create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;
    }

    public static void tearDown() {
        logger.info("Closing a page");
        threadLocalInstance.get().quit();
        threadLocalInstance.remove();
    }

    private WebDriverSingleton() {
    }
}

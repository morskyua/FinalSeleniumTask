package org.epam;

import org.epam.businessobjects.SauceDemoLoginBO;
import org.epam.util.WebDriverSingleton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.epam.util.WebDriverSingleton.getDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


public class SauceDemoTest {
    private static final Logger logger = LoggerFactory.getLogger(SauceDemoTest.class);
    private static Properties properties;
    private SauceDemoLoginBO sauceDemoLoginBO;

    @BeforeAll
    public static void setupAll() {
        properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/prod.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeEach
    public void setup() {
        sauceDemoLoginBO = new SauceDemoLoginBO(getDriver());
        String url = properties.getProperty("sauceDemoURL");
        logger.info("Opening Swag Labs login page: " + url);
        getDriver().get(url);
    }

    @AfterEach
    public void tearDown() {
        WebDriverSingleton.tearDown();
    }

    @ParameterizedTest
    @CsvSource({"DemoLogin, DemoPassword"})
    void testWithEmptyInputs(String name, String password) {
        logger.info("Log in with empty inputs");
        String actual = sauceDemoLoginBO.loginWithEmptyInputs(name, password);
        assertThat(actual, containsString("Username is required"));
    }


    @ParameterizedTest
    @CsvSource({"DemoLogin, DemoPassword"})
    void testWithEmptyPassword(String name, String password) {
        logger.info("Log in with empty password input");
        String actual = sauceDemoLoginBO.loginWithEmptyPassword(name, password);
        assertThat(actual, containsString("Password is required"));
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/loginInfo.csv")
    void testWithValidInputs(String name, String password) {
        logger.info("Log in with {} username and {} password", name, password);
        String expected = "Swag Labs";
        WebElement dashboard = sauceDemoLoginBO.loginWithValidInputs(name, password);
        String actual = dashboard.getText();
        assertThat(actual, equalTo(expected));
    }
}
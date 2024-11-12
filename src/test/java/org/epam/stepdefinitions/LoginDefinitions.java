package org.epam.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.epam.BaseTest;
import org.epam.SauceDemoTest;
import org.epam.businessobjects.SauceDemoLoginBO;
import org.epam.util.WebDriverSingleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.epam.util.WebDriverSingleton.getDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class LoginDefinitions extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(SauceDemoTest.class);
    private SauceDemoLoginBO sauceDemoLoginBO;

    @After
    public void tearDown() {
        logger.info("Closing a page");
        WebDriverSingleton.tearDown();
    }

    @Given("I open {string} page")
    public void iOpenPage(String pageName) {
        String url = propertyReader.getProperty(pageName);
        logger.info("Opening Swag Labs login page: " + url);
        getDriver().get(url);
        sauceDemoLoginBO = new SauceDemoLoginBO(getDriver());
    }

    @Given("I enter username {string} and password {string}")
    public void iEnterUsernameAndPassword(String username, String password) {
        sauceDemoLoginBO.enterLoginCredentials(username, password);
    }

    @When("I clear the username and password inputs")
    public void iClearTheUsernameAndPasswordInputs() {
        sauceDemoLoginBO.clearInputs(true, true);
    }

    @When("I click login button")
    public void iClickLoginButton() {
        sauceDemoLoginBO.clickLoginButton();
    }

    @Then("I see an error message {string}")
    public void iSeeAnErrorMessage(String errorMessage) {
        String actual = sauceDemoLoginBO.getErrorText();
        assertThat(actual, containsString(errorMessage));
    }

    @When("I clear the password input")
    public void iClearThePasswordInput() {
        sauceDemoLoginBO.clearInputs(false, true);
    }

    @Then("I see title {string} on the dashboard")
    public void iSeeTitleOnTheDashboard(String dashboardTitle) {
        String actual = sauceDemoLoginBO.getDashboard().getText();
        assertThat(actual, equalTo(dashboardTitle));
    }
}

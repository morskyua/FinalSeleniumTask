package org.epam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SauceDemoLoginPage extends BasePage {

    @FindBy(xpath = "//input[@data-test='username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@data-test='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@data-test='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorText;

    public WebElement getErrorText() {
        return errorText;
    }

    public WebElement getUsernameInput() {
        return usernameInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }
}

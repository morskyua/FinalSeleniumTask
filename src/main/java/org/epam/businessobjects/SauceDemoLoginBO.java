package org.epam.businessobjects;

import org.epam.util.Util;
import org.epam.pages.SauceDemoCatalogPage;
import org.epam.pages.SauceDemoLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoLoginBO {
    private SauceDemoLoginPage sauceDemoPage;
    private SauceDemoCatalogPage sauceDemoCatalogPage;
    private WebDriver driver;

    public SauceDemoLoginBO(WebDriver driver) {
        this.driver = driver;
        sauceDemoPage = PageFactory.initElements(driver, SauceDemoLoginPage.class);
        sauceDemoCatalogPage = PageFactory.initElements(driver, SauceDemoCatalogPage.class);
    }

    public void enterLoginCredentials(String username, String password) {
        sauceDemoPage.getUsernameInput().sendKeys(username);
        sauceDemoPage.getPasswordInput().sendKeys(password);
    }

    public void clearInputs(boolean clearUsername, boolean clearPassword) {
        if (clearUsername) {
            Util.clearInputWithActions(sauceDemoPage.getUsernameInput(), driver);
        }
        if (clearPassword) {
            Util.clearInputWithActions(sauceDemoPage.getPasswordInput(), driver);
        }
    }

    public void clickLoginButton() {
        sauceDemoPage.getLoginButton().click();
    }

    public String getErrorText() {
        return sauceDemoPage.getErrorText().getText();
    }

    public String loginWithEmptyInputs(String name, String password) {
        enterLoginCredentials(name, password);
        clearInputs(true, true);
        clickLoginButton();
        return getErrorText();
    }

    public String loginWithEmptyPassword(String name, String password) {
        enterLoginCredentials(name, password);
        clearInputs(false, true);
        clickLoginButton();
        return getErrorText();
    }

    public WebElement loginWithValidInputs(String name, String password) {
        enterLoginCredentials(name, password);
        clickLoginButton();
        return getDashboard();
    }

    public WebElement getDashboard() {
        return sauceDemoCatalogPage.getDashboard();
    }
}

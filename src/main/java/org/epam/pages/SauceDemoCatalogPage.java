package org.epam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SauceDemoCatalogPage {
    @FindBy(xpath = "//*[@class='app_logo']")
    private WebElement dashboard;

    public WebElement getDashboard() {
        return dashboard;
    }
}

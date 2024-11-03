package org.epam.util;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Util {
    public static void clearInputWithActions(WebElement target, WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.click(target).keyDown(Keys.CONTROL).sendKeys("a").sendKeys(Keys.BACK_SPACE).build().perform();
    }

    private Util(){}
}

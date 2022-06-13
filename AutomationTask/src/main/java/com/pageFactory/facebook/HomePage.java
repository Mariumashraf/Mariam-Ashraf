package com.pageFactory.facebook;

import com.common.helpers.web.UIActions;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage {

    UIActions uiActions = new UIActions();

    By welcome_label = By.xpath("//*[text()='Welcome']");
    By groups_label = By.xpath("//*[text()='Groups']");

    public void checkHomePageIsDisplayed() {
        uiActions.waitDocumentReady();
        Assert.assertTrue(uiActions.isElementDisplayed(welcome_label), "Welcome label wasn't displayed, user wasn't created successfully");
        Assert.assertTrue(uiActions.isElementDisplayed(groups_label), "Groups label wasn't displayed, user wasn't created successfully");
    }
}

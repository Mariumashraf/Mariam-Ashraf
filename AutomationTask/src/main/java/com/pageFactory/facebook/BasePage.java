package com.pageFactory.facebook;

import com.common.helpers.web.UIActions;
import org.openqa.selenium.By;

public class BasePage {

    UIActions uiActions = new UIActions();
    By login_btn = By.name("login");

    public void navigateToLoginPage(String loginPageURL ) {
        uiActions.navigateToURL(loginPageURL, login_btn);
        uiActions.waitDocumentReady();
    }

}

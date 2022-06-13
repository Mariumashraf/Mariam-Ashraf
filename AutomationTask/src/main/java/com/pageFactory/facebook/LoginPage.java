package com.pageFactory.facebook;

import com.common.helpers.web.UIActions;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.common.helpers.web.BaseBrowser.driver;

public class LoginPage {
    UIActions uiActions = new UIActions();

    By email_txtBox = By.id("email");
    By password_txtBox = By.id("pass");
    By login_btn = By.name("login");
    By errorMessage_label = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2] | /html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[2]/div[2]");

    public void checkErrorMessage(String errorMessage) {
        uiActions.waitDocumentReady();
        Assert.assertTrue(driver.findElement(errorMessage_label).getText().contains(errorMessage));
    }

    public void clickOnLoginBtn() {
        uiActions.clickOn(login_btn);
    }

    public void typeCredential(String email, String password) {
        uiActions.setText(email_txtBox, email);
        uiActions.setText(password_txtBox, password);
    }
}

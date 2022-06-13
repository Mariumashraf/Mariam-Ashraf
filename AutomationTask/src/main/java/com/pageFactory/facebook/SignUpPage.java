package com.pageFactory.facebook;

import com.common.helpers.web.UIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static com.common.helpers.web.BaseBrowser.driver;

public class SignUpPage {

    UIActions uiActions = new UIActions();

    By createNewAccount_btn = By.linkText("Create New Account");
    By firstName_txtBox = By.name("firstname");
    By lastName_txtBox = By.name("lastname");
    By email_txtBox = By.name("reg_email__");
    By confirmEmail_txtBox = By.name("reg_email_confirmation__");
    By password_txtBox = By.id("password_step_input");
    By day_list = By.id("day");
    By month_list = By.id("month");
    By year_list = By.id("year");
    By singUp_btn = By.name("websubmit");
    By progressBar = By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[11]/span/img");
    By errorMessage_label = By.xpath("//*[contains(@id, 'js_')]");

    public void checkErrorMessage(String errorMessage){
        uiActions.waitDocumentReady();
        List<WebElement> errorMessagesElements = driver.findElements(errorMessage_label);
        Assert.assertTrue(errorMessagesElements.get(0).getText().contains(errorMessage));
    }

    public void clickOnSignUpBtn() {
        uiActions.clickOn(singUp_btn);
        uiActions.waitForElementToBeGone(progressBar, 120);
        uiActions.waitDocumentReady();
    }

    public void createNewAccount(String fName, String lName, String email, String confirmEmail,String password, String birthData, String gender) {
        uiActions.setText(firstName_txtBox, fName);
        uiActions.setText(lastName_txtBox, lName);
        uiActions.setText(email_txtBox, email);
        if(!email.equalsIgnoreCase("")){
        uiActions.setText(confirmEmail_txtBox, confirmEmail);}
        uiActions.setText(password_txtBox, password);
        if(!birthData.equalsIgnoreCase("")){
        String[] dateParts = birthData.split("/");
        String day = dateParts[0];
        String month = dateParts[1];
        String year = dateParts[2];
        uiActions.selectItemByValue(day_list, day);
        uiActions.selectItemByValue(month_list, month);
        uiActions.selectItemByValue(year_list, year);}
        if(!gender.equalsIgnoreCase("")){
        uiActions.clickOn(By.xpath("//*[text()='" + gender + "']"));}
    }

    public void clickOnCreateNewAccountBtn() {
        uiActions.clickOn(createNewAccount_btn);
    }

}

package com.common.helpers.web;

import com.common.helpers.Wrappers.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static com.common.helpers.web.BaseBrowser.driver;


public class UIActions {
    private Select select;
    private JavascriptExecutor jse;
    public Actions action;

    public UIActions() {
        jse = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }

    /**
     * This is a method to navigate to URL and assert in a unique element is displayed to make sure that we are at the correct page
     *
     * @param URL
     * @param element: Unique element at the page
     */
    public void navigateToURL(String URL, By element) {
        Log.info("Navigate to URL");
        driver.get(URL);
        Assert.assertTrue(validateElement(ExpectedConditions.presenceOfElementLocated(element)));
    }

    public void clickOn(By element) {
        if (element == null) {
            throw new Error("Couldn't get Element");
        } else if (validateElement(ExpectedConditions.elementToBeClickable(element))) {
            try {
                Log.info("Click On Element With Locator: " + element);
                driver.findElement(element).click();
                Log.info(element + ": is clicked");
            } catch (Exception e) {
                click(driver.findElement(element));
            }
        }
    }

    /**
     * Single click on WebElement By Javascript
     *
     * @param elem WebElement object
     */
    public void click(WebElement elem) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
    }

    /**
     * This method is used to send text to element
     *
     * @param element: which sent text to it
     * @param text:    to be sent
     */

    public void setText(By element, String text) {
        if (element == null) {
            throw new Error("Couldn't get Element");
        } else if (validateElement(ExpectedConditions.visibilityOfElementLocated(element))) {
            Log.info("Set text: " + text + " to this element: " + element);
            driver.findElement(element).sendKeys(text);
            Log.info("Text is sent to: " + element);
        }
    }

    public String getText(By element) {
        try {
            validateElement(ExpectedConditions.presenceOfElementLocated(element));
            return driver.findElement(element).getText();

        } catch (Exception e) {
            Log.error("Can't get text from the element");
            return null;
        }

    }

    public void clearText(By element) {
        if (element == null) {
            throw new Error("Couldn't get Element");
        } else if (validateElement(ExpectedConditions.visibilityOfElementLocated(element))) {
            Log.info("Clear Text From Element With Locator: " + element);
            driver.findElement(element).clear();
        }
    }

    public void selectItem(By selectElement) {
        validateElement(ExpectedConditions.presenceOfElementLocated(selectElement));
        select = new Select(driver.findElement(selectElement));
    }

    public void selectItemByValue(By selectElement, String value) {
        selectItem(selectElement);
        select.selectByValue(value);
        /*validateElement(ExpectedConditions.presenceOfElementLocated(selectElement));
        select = new Select(driver.findElement(selectElement));*/
    }

    public void uploadFile(By uploadPhoto, String imagePath) throws AWTException {
        validateElement(ExpectedConditions.presenceOfElementLocated(uploadPhoto));
        driver.findElement(uploadPhoto).click();
        Robot robot = new Robot();
        StringSelection selection = new StringSelection(imagePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(2000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void scrollToBottom() {
        jse.executeScript("scrollBy(0,2500)");
    }

    public void scrollUntilViewElement(By myElement) {
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(myElement));
    }

    public void hoverElement(By element) {
        action.moveToElement(driver.findElement(element)).perform();
    }


    /**
     * This method is used to validate element under specific condition
     *
     * @param condition: Example: visibility of element
     * @return:
     */
    public boolean validateElement(ExpectedCondition<WebElement> condition) {
        try {
            Log.info("Validate this element under this condition: " + condition);
            new WebDriverWait(driver, 90).until(condition);
            return true;
        } catch (Exception e) {
            Log.error("Can't find Element with this condition: " + condition);
            throw new Error("Can't find Element with this condition: " + condition);
        }
    }

    /**
     * This method is used to check if element is displayed or not
     *
     * @param element: Element to be checked is displayed or not
     * @return True: if element is displayed, False: if element isn't displayed
     */

    public boolean isElementDisplayed(By element) {
        Log.info("Check if the element: " + element + " is displayed or not");
        if (element == null) {
            throw new Error("Couldn't get Element");
        }
        WebDriverWait wait = new WebDriverWait(driver, 120);

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(element));
            return driver.findElement(element).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This method is used to wait for element to be invisible "Progress Bar | Loading"
     *
     * @param element: Element to be checked is displayed or not
     * @param timeout: Time to wait
     */
    public void waitForElementToBeGone(By element, int timeout) {
        Log.info("Wait until this element: " + element + " become invisible");

        if (isElementDisplayed(element)) {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.invisibilityOf(driver.findElement(element)));
        }
    }

    /**
     * wait for page html to be loaded
     */
    public void waitDocumentReady() {
        new WebDriverWait(driver, 120).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                JavascriptExecutor js = (JavascriptExecutor) d;
                return js.executeScript("return document.readyState").toString().contains("complete");
            }
        });
    }
}

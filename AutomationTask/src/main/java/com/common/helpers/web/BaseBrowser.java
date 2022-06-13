package com.common.helpers.web;

import com.common.helpers.Wrappers.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Optional;

import java.net.URL;

public class BaseBrowser {

    public static WebDriver driver;

    public void initializeWebDriver(@Optional("Chrome") String browserName) {
        try {
            if (browserName.equalsIgnoreCase("Chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("Edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            } else if (browserName.equalsIgnoreCase("Internet Explore")) {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            } else if (browserName.equalsIgnoreCase("Headless")) {
                WebDriverManager.phantomjs().setup();
                driver = new PhantomJSDriver();
            } else if (browserName.equalsIgnoreCase("ChromeDocker")) {
                driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), DesiredCapabilities.chrome());
            } else if (browserName.equalsIgnoreCase("FirefoxDocker")) {
                driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), DesiredCapabilities.firefox());
            }
            Log.info("Initialize Browser" + browserName);
        } catch (Exception e) {
            Log.error("Can't initialize browser" + browserName);
        }
    }

    public void clearCookies() {
        Log.info("Clear Cookies");
        driver.manage().deleteAllCookies();
    }

    public void maximizeBrowser() {
        Log.info("Maximize Browser");
        driver.manage().window().maximize();
    }

    public void closeDriver() {
        Log.info("Close Browser");
        driver.quit();
    }
}

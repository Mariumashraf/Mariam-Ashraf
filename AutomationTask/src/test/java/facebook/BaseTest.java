package facebook;

import com.common.helpers.Wrappers.ExtentReport;
import com.common.helpers.web.BaseBrowser;
import com.common.helpers.Wrappers.PropertiesReader;
import com.pageFactory.facebook.BasePage;
import com.pageFactory.facebook.HomePage;
import com.pageFactory.facebook.LoginPage;
import com.pageFactory.facebook.SignUpPage;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTest {
    ExtentReport extent;
    BaseBrowser baseBrowser;
    SignUpPage signUpPage;
    HomePage homePage;
    LoginPage loginPage;
    String loginPageURL;

    public BaseTest() {
        PropertiesReader.readPropertiesFile("src/main/resources/web/facebook/facebookConfig.properties");
        loginPageURL = PropertiesReader.getProperty("Facebook.url");
        extent = new ExtentReport();
        baseBrowser = new BaseBrowser();
    }

    @BeforeSuite
    public void startReport() {
        extent.startReport("TestReport\\FacebookTestResult.html", "Facebook - SignUp and Login");
    }

    @BeforeClass
    @Parameters("browserName")
    public void setup(String browserName) {
        baseBrowser.initializeWebDriver(browserName);
        baseBrowser.maximizeBrowser();
        signUpPage = new SignUpPage();
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @BeforeMethod
    public void openLoginPage(Method method) {
        extent.setup(method);
        baseBrowser.clearCookies();
        new BasePage().navigateToLoginPage(loginPageURL);
    }

    @AfterMethod
    public void finishTest(ITestResult result, Method method) throws IOException {
        extent.logResult(method, result, true);
    }

    @AfterClass
    public void tearDown() {
        baseBrowser.closeDriver();
    }

    @AfterSuite
    public void endReport() {
        extent.endReport();
    }
}

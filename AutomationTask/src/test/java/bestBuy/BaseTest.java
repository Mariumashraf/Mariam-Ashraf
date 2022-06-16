package bestBuy;

import java.io.IOException;
import java.lang.reflect.Method;

import com.common.helpers.Wrappers.ExtentReport;
import com.common.helpers.Wrappers.PropertiesReader;
import com.common.helpers.api.rest.RestAPI;
import com.github.javafaker.Faker;
import com.services.bestBuy.*;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.Locale;

public class BaseTest {
    ExtentReport extent;
    RestAPI restAPI;
    Products products;
    Stores stores;
    Services services;
    Categories categories;
    Utilities utilities;
    Faker fakerData;
    String baseUrl;

    public BaseTest() {
        PropertiesReader.readPropertiesFile("src/main/resources/services/bestBuy/bestBuyConfig.properties");
        extent = new ExtentReport();
        restAPI = new RestAPI();
        products = new Products();
        stores = new Stores();
        services = new Services();
        categories = new Categories();
        utilities = new Utilities();
        fakerData = new Faker(Locale.ENGLISH);
        baseUrl = PropertiesReader.getProperty("BestBuy.Url");
    }

    @BeforeSuite
    public void startReport() {
        extent.startReport("TestReport\\BestBuyTestResult.html","Best Buy - API Background");
    }

    @BeforeMethod
    public void setup(Method method) {
        extent.setup(method);
    }

    @AfterMethod
    public void logResult(Method method, ITestResult result) throws IOException {
      extent.logResult(method, result,false);
    }

    @AfterSuite
    public void endReport() {
        extent.endReport();
    }
}

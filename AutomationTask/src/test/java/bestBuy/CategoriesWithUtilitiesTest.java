package bestBuy;

import com.common.helpers.Wrappers.PropertiesReader;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CategoriesWithUtilitiesTest extends BaseTest {
    Response response;
    String healthCheckEndPoint = PropertiesReader.getProperty("BestBuy.HealthCheckEndPoint");
    String endPoint = PropertiesReader.getProperty("BestBuy.CategoriesEndPoint");
    int categoriesNumBefore;
    int categoriesNumAfter;
    String id;
    String name;


    @BeforeMethod
    public void checkSystemInfo() {
        response = utilities.getHealthInformation(baseUrl, healthCheckEndPoint);

        restAPI.assertStatusCode(200, response);
        categoriesNumBefore = Integer.parseInt(response.jsonPath().getString("documents.categories"));
    }

    @Test
    public void addCategoryAndCheckSystemInfo() {
        id = fakerData.idNumber().valid();
        name = "New Category: " + fakerData.commerce().department();

        response = categories.addNewCategory(baseUrl, id, name, endPoint);
        restAPI.assertStatusCode(201, response);
        restAPI.assertResponseBody("id", id, response);
        restAPI.assertResponseBody("name", name, response);

        response = utilities.getHealthInformation(baseUrl, healthCheckEndPoint);

        restAPI.assertStatusCode(200, response);
        categoriesNumAfter = Integer.parseInt(response.jsonPath().getString("documents.categories"));
        Assert.assertEquals(categoriesNumAfter - categoriesNumBefore, 1);
    }
}

package bestBuy;

import com.common.helpers.Wrappers.PropertiesReader;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CategoriesTest extends BaseTest {

    Response response;
    String endPoint = PropertiesReader.getProperty("BestBuy.CategoriesEndPoint");
    String id;
    String name;

    @Test
    public void addNewCategory() {
        id = fakerData.idNumber().valid();
        name = "New Category: " + fakerData.commerce().department();

        response = categories.addNewCategory(baseUrl, id, name, endPoint);
        restAPI.assertStatusCode(201, response);
        restAPI.assertResponseBody("id", id, response);
        restAPI.assertResponseBody("name", name, response);

        id = response.jsonPath().getString("id");
    }

}

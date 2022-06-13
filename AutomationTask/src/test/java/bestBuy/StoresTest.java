package bestBuy;

import com.common.helpers.Wrappers.PropertiesReader;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class StoresTest extends BaseTest {
    Response response;
    String endPoint = PropertiesReader.getProperty("BestBuy.StoresEndPoint");
    String id;
    String name;
    String address;
    String city;
    String state;
    String zip;

    @Test
    public void addNewStore() {
        name = "New Store: " + fakerData.company().name();
        address = fakerData.address().streetAddress();
        city = fakerData.address().city();
        state = fakerData.address().state();
        zip = fakerData.address().zipCode();

        response = stores.addNewStore(baseUrl, name, address, city, state, zip, endPoint);

        restAPI.assertStatusCode(201, response);
        restAPI.assertResponseBody("name", name, response);
        restAPI.assertResponseBody("address", address, response);
        restAPI.assertResponseBody("city", city, response);
        restAPI.assertResponseBody("state", state, response);
        restAPI.assertResponseBody("zip", zip, response);

        id = response.jsonPath().getString("id");
    }

    @Test(dependsOnMethods = {"addNewStore"})
    public void getStoreByValidId() {
        response = stores.getStoreById(baseUrl, endPoint, id);

        restAPI.assertStatusCode(200, response);
        restAPI.assertResponseBody("id", id, response);
        restAPI.assertResponseBody("name", name, response);
        restAPI.assertResponseBody("address", address, response);
        restAPI.assertResponseBody("city", city, response);
        restAPI.assertResponseBody("state", state, response);
        restAPI.assertResponseBody("zip", zip, response);
    }

    @Test
    public void getStoresByState() {
        String state = "ND";
        response = stores.getStoresByState(baseUrl, state, endPoint);

        restAPI.assertStatusCode(200, response);

        List<String> states = response.jsonPath().get("data.state");
        for (String s : states) {
            Assert.assertEquals(state, s);
        }
    }
}

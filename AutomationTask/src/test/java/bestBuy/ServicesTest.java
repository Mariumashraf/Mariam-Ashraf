package bestBuy;

import com.common.helpers.Wrappers.JsonReader;
import com.common.helpers.Wrappers.PropertiesReader;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ServicesTest extends BaseTest {
    JsonReader jsonReader = new JsonReader("src/main/resources/services/bestBuy/serviceInvalidData.json");
    Response response;
    String endPoint = PropertiesReader.getProperty("BestBuy.ServicesEndPoint");
    String id;
    String name;

    @Test
    public void addNewService() {
        name = "New Service: " + fakerData.company().industry();

        response = services.addNewService(baseUrl, name, endPoint);
        restAPI.assertStatusCode(201, response);
        restAPI.assertResponseBody("name", name, response);

        id = response.jsonPath().getString("id");
    }

    @Test(dependsOnMethods = {"addNewService"})
    public void getServiceByValidId() {
        response = services.getServiceById(baseUrl, endPoint, id);

        restAPI.assertStatusCode(200, response);
        restAPI.assertResponseBody("id", id, response);
        restAPI.assertResponseBody("name", name, response);

    }

    @Test(dataProvider = "invalidServiceNames")
    public void ValidateNameField(String name, String errorMessage, String message2) {
        response = services.addNewService(baseUrl, name, endPoint);

        restAPI.assertStatusCode(400, response);
        restAPI.assertResponseBody("errors[0]", errorMessage, response);
        restAPI.assertResponseBody("message", message2, response);
    }

    @DataProvider
    public Object[][] invalidServiceNames() {
        Object[][] serviceData = new Object[2][3];
        ArrayList<String> nameOfService;
        ArrayList<String> errorMessage;
        ArrayList<String> message;
        nameOfService = jsonReader.getNodeValue("service", "name");
        errorMessage = jsonReader.getNodeValue("service", "errorMessage");
        message = jsonReader.getNodeValue("service", "message");
        for (int i = 0; i < 2; i++) {
            serviceData[i][0] = nameOfService.get(i);
            serviceData[i][1] = errorMessage.get(i);
            serviceData[i][2] = message.get(i);
        }
        return serviceData;
    }
}

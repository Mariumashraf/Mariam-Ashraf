package bestBuy;

import com.common.helpers.Wrappers.PropertiesReader;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UtilitiesTest extends BaseTest {
    Response response;
    String versionEndPoint = PropertiesReader.getProperty("BestBuy.VersionEndPoint");
    String version = PropertiesReader.getProperty("BestBuy.Version");
    String healthCheckEndPoint = PropertiesReader.getProperty("BestBuy.HealthCheckEndPoint");
    String productsNum;
    String storesNum;
    String categoriesNum;

    @Test
    public void getSystemInfo() {
        response = utilities.getHealthInformation(baseUrl, healthCheckEndPoint);

        restAPI.assertStatusCode(200, response);

        productsNum = response.jsonPath().getString("documents.products");
        storesNum = response.jsonPath().getString("documents.stores");
        categoriesNum = response.jsonPath().getString("documents.categories");
    }

    @Test
    public void getVersion() {
        response = utilities.getVersion(baseUrl, versionEndPoint);

        restAPI.assertStatusCode(200, response);
        restAPI.assertResponseBody("version", version, response);

    }

}

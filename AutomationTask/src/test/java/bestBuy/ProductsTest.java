package bestBuy;

import com.common.helpers.Wrappers.PropertiesReader;
import io.restassured.response.Response;
import org.testng.annotations.Test;


public class ProductsTest extends BaseTest {
    Response response;
    String endPoint = PropertiesReader.getProperty("BestBuy.ProductsEndPoint");
    String id;
    String name;
    String type;
    String upc;
    String model;

    @Test(priority = -1)
    public void addNewProductWithEmptyBody() {
        response = products.addNewProduct(baseUrl, name, type, upc, "Add a new product with upc: " + upc, model, endPoint);
        restAPI.assertStatusCode(400, response);
        restAPI.assertResponseBody("message", "Invalid Parameters", response);
    }

    @Test
    public void addNewProduct() {
        name = "New Product: " + fakerData.commerce().productName();
        type = fakerData.commerce().material();
        upc = String.valueOf(fakerData.random().nextInt(100, 1000000));
        model = fakerData.commerce().color();

        response = products.addNewProduct(baseUrl, name, type, upc, "Add a new product with upc: " + upc, model, endPoint);
        restAPI.assertStatusCode(201, response);
        restAPI.assertResponseBody("name", name, response);
        restAPI.assertResponseBody("type", type, response);
        restAPI.assertResponseBody("upc", upc, response);
        restAPI.assertResponseBody("model", model, response);

        id = response.jsonPath().getString("id");
    }

    @Test(dependsOnMethods = {"addNewProduct"})
    public void getProductByValidId() {
        response = products.getProductById(baseUrl, endPoint, id);

        restAPI.assertStatusCode(200, response);
        restAPI.assertResponseBody("id", id, response);
        restAPI.assertResponseBody("name", name, response);
        restAPI.assertResponseBody("type", type, response);
        restAPI.assertResponseBody("upc", upc, response);
        restAPI.assertResponseBody("model", model, response);
    }

    @Test(dependsOnMethods = {"getProductByValidId"})
    public void updateProductName() {
        name = fakerData.commerce().productName();

        response = products.updateProduct(baseUrl, name, endPoint, id);

        restAPI.assertStatusCode(200, response);
        restAPI.assertResponseBody("id", id, response);
        restAPI.assertResponseBody("name", name, response);
    }

    @Test(dependsOnMethods = {"updateProductName"})
    public void deleteProductById() {
        response = products.deleteProductById(baseUrl, endPoint, id);

        restAPI.assertStatusCode(200, response);

        response = products.getProductById(baseUrl, endPoint, id);

        restAPI.assertStatusCode(404, response);
        restAPI.assertResponseBody("message", "No record found for id '" + id + "'", response);
    }

    @Test(dependsOnMethods = {"deleteProductById"})
    public void deleteProductByInvalidId() {
        response = products.deleteProductById(baseUrl, endPoint, id);
        restAPI.assertStatusCode(404, response);
        restAPI.assertResponseBody("message", "No record found for id '" + id + "'", response);
    }

    @Test
    public void getProductByInvalidId() {
        String invalidId = "000";
        response = products.getProductById(baseUrl, endPoint, invalidId);

        restAPI.assertStatusCode(404, response);
        restAPI.assertResponseBody("message", "No record found for id '" + invalidId + "'", response);
    }
}

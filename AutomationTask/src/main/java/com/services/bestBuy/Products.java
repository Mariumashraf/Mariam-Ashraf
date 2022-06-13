package com.services.bestBuy;

import com.common.helpers.api.rest.APIOperations;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class Products {
    APIOperations operations = new APIOperations();
    Map<String, String> productData = new HashMap<>();

    public Response deleteProductById(String url, String endPoint, String id) {
        return operations.deleteRequest(url, endPoint + id);
    }

    public Response updateProduct(String url, String name, String endPoint, String id) {
        productData.put("name", name);
        return operations.patchRequest(url, ContentType.JSON, productData, endPoint + id);

    }

    public Response getProductById(String url, String endPoint, String id) {
        return operations.getRequest(url, endPoint + id);
    }

    public Response addNewProduct(String url, String name, String type, String upc, String description, String model, String endPoint) {
        productData.put("name", name);
        productData.put("type", type);
        productData.put("upc", upc);
        productData.put("description", description);
        productData.put("model", model);
        return operations.postRequest(url, ContentType.JSON, productData, endPoint);
    }

}

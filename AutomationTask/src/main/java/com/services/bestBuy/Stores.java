package com.services.bestBuy;

import com.common.helpers.api.rest.APIOperations;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class Stores {
    APIOperations operations = new APIOperations();
    Map<String, String> storesData = new HashMap<>();
    Map<String, String> queryParameters = new HashMap<>();

    public Response getStoresByState(String url, String state, String endPoint) {
        queryParameters.put("state", state);
        return operations.getRequestWithQueryParameters(url, queryParameters, endPoint);
    }

    public Response getStoreById(String url, String endPoint, String id) {
        return operations.getRequest(url, endPoint + id);
    }

    public Response addNewStore(String url, String name, String address, String city, String state, String zipCode, String endPoint) {
        storesData.put("name", name);
        storesData.put("address", address);
        storesData.put("city", city);
        storesData.put("state", state);
        storesData.put("zip", zipCode);
        return operations.postRequest(url, ContentType.JSON, storesData, endPoint);
    }
}

package com.services.bestBuy;

import com.common.helpers.api.rest.APIOperations;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class Categories {
    APIOperations operations = new APIOperations();
    Map<String, String> categoriesData = new HashMap<>();

    public Response addNewCategory(String url, String id, String name, String endPoint) {
        categoriesData.put("id", id);
        categoriesData.put("name", name);
        return operations.postRequest(url, ContentType.JSON, categoriesData, endPoint);
    }
}

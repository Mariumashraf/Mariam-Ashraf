package com.services.bestBuy;

import com.common.helpers.api.rest.APIOperations;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;


public class Services {
    APIOperations operations = new APIOperations();
    Map<String, String> servicesData = new HashMap<>();

    public Response getServiceById(String url, String endPoint, String id) {
        return operations.getRequest(url, endPoint + id);
    }

    public Response addNewService(String url, String name, String endPoint) {
        servicesData.put("name", name);
        return operations.postRequest(url, ContentType.JSON, servicesData, endPoint);
    }
}

package com.services.bestBuy;

import com.common.helpers.api.rest.APIOperations;
import io.restassured.response.Response;

public class Utilities {
    APIOperations operations = new APIOperations();

    public Response getHealthInformation(String url, String endPoint) {
        return operations.getRequest(url, endPoint);
    }

    public Response getVersion(String url, String endPoint) {
        return operations.getRequest(url, endPoint);
    }
}

package com.common.helpers.api.rest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class APIOperations extends RestAPI {

    public Response deleteRequest(String urlKey, String endPoint) {
        return givenConfig(urlKey).when().log().all().delete(endPoint);
    }

    public Response putRequest(String urlKey, String endPoint) {
        return givenConfig(urlKey).when().log().all().put(endPoint);
    }

    public Response postRequestWithFormParameters(String urlKey, Map<String, Object> formParameters, String endPoint) {
        return givenConfig(urlKey).formParams(formParameters).when().log().all().post(endPoint);
    }

    public Response postRequestWithHeaders(String urlKey, Map<String, Object> headers, String endPoint) {
        return givenConfig(urlKey, headers).when().log().all().post(endPoint);
    }

    public Response patchRequest(String urlKey, ContentType contentType, Map<String, String> body, String endPoint) {
        return givenConfig(urlKey).contentType(contentType).body(body).when().log().all().patch(endPoint);
    }

    public Response postRequest(String urlKey, ContentType contentType, Map<String, String> body, String endPoint) {
        return givenConfig(urlKey).contentType(contentType).body(body).when().log().all().post(endPoint);
    }

    public Response postRequest(String urlKey, Map<String, Object> headers, Map<String, String> formParameters, String endPoint) {
        return givenConfig(urlKey, headers).formParams(formParameters).when().log().all().post(endPoint);
    }

    public Response getRequestWithHeaders(String urlKey, Map<String, Object> headers, String endPoint) {
        return givenConfig(urlKey, headers).when().log().all().get(endPoint);
    }

    public Response getRequest(String urlKey, Map<String, Object> headers, Map<String, String> queryParameters, String endPoint) {
        return givenConfig(urlKey, headers).queryParams(queryParameters).when().log().all().get(endPoint);
    }

    public Response getRequestWithQueryParameters(String urlKey, Map<String, String> queryParameters, String endPoint) {
        return givenConfig(urlKey).queryParams(queryParameters).when().log().all().get(endPoint);
    }

    public Response getRequest(String urlKey, String endPoint) {
        return givenConfig(urlKey).when().log().all().get(endPoint);
    }
}

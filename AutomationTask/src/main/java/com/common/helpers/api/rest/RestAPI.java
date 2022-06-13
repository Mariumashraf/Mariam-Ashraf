package com.common.helpers.api.rest;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import static io.restassured.RestAssured.given;

public class RestAPI {

    public void assertResponseBody(String jsonKey, String jsonValue, Response response) {
        assertThat("Expected Response Value for key: " + jsonKey + " was: " + jsonValue + " , but found Actual Response Value was: " + response.jsonPath().getString(jsonKey), response.jsonPath().getString(jsonKey), containsString(jsonValue));
    }

    public void assertStatusLine(String statusLine, Response response) {
        assertThat("Expected Status Line was: " + statusLine + " , but found Actual Status Line was: " + getStatusLine(response), getStatusLine(response), equalTo(statusLine));
    }

    public void assertStatusCode(int statusCode, Response response) {
        assertThat("Expected Status Code was: " + statusCode + " , but found Actual Status Code was: " + getStatusCode(response), getStatusCode(response), equalTo(statusCode));
    }

    public ResponseBody getResponseBody(Response response) {
        return response.getBody();
    }

    public String getStatusLine(Response response) {
        return response.getStatusLine();
    }

    public int getStatusCode(Response response) {
        return response.getStatusCode();
    }

    public RequestSpecification givenConfig(String urlKey, Map<String, Object> headers) {
        return given().headers(headers).baseUri(urlKey);
    }

    public RequestSpecification givenConfig(String urlKey) {
        return given().baseUri(urlKey);
    }
}


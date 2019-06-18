package com.tradeix.techinical_assement.utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Restservices {

    public void getRequest(String endpoint) {
        given().contentType(ContentType.JSON).when().get(endpoint);
    }

    public Response postRequest(String endpoint, Object payload) {
        return given().contentType(ContentType.JSON).when().body(payload).contentType(ContentType.JSON).post(endpoint);
    }

    public Response putRequest(String endpoint, Object payload, String id) {
        return given().contentType(ContentType.JSON).when().body(payload).put(endpoint + "/" + id);
    }

    public Response deleteRequest(String endpoint, String id) {
        return given().contentType(ContentType.JSON).when().delete(endpoint + "/" + id);
    }
}

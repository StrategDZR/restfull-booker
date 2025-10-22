package com.example.api;

import com.example.specs.ResponseSpecs;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PingApi {

    private static final String PING = "/ping";

    public Response ping() {
        return given()
                .when()
                .get(PING)
                .then()
                .spec(ResponseSpecs.logResponse())
                .extract().response();
    }
}

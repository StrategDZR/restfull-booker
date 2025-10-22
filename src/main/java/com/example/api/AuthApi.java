package com.example.api;

import com.example.model.User;
import com.example.specs.ResponseSpecs;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthApi {

    private static final String AUTH = "/auth";

    public Response auth(User user) {
        return given()
                .body(user)
                .when()
                .post(AUTH)
                .then()
                .spec(ResponseSpecs.logResponse())
                .extract().response();
    }
}

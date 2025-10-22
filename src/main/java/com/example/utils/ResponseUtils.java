package com.example.utils;

import io.restassured.response.Response;

public class ResponseUtils {

    public static String getToken(Response response) {
        return response.getBody().jsonPath().getString("token");
    }

    public static String getReason(Response response) {
        return response.getBody().jsonPath().getString("reason");
    }

    public static int getStatusCode(Response response) {
        return response.getStatusCode();
    }
}

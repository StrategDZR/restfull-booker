package com.example;

import com.example.api.AuthApi;
import com.example.api.BookingApi;
import com.example.api.PingApi;
import com.example.specs.RequestSpecs;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    protected static AuthApi authApi;
    protected static PingApi pingApi;
    protected static BookingApi bookingApi;

    @BeforeAll
    public static void setup() {
        RestAssured.filters(new AllureRestAssured());
        RestAssured.requestSpecification = RequestSpecs.defaultSpec();

        authApi = new AuthApi();
        pingApi = new PingApi();
        bookingApi = new BookingApi();
    }
}

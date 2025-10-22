package com.example.api;

import com.example.model.Booking;
import com.example.specs.ResponseSpecs;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookingApi {

    private static final String BOOKING = "/booking/%s";

    public Response updateBooking(String token, int bookingId, Booking booking) {
        return given()
                .header("Accept", "application/json")
                .header("Cookie", String.format("token=%s", token))
                .body(booking)
                .when()
                .put(String.format(BOOKING, bookingId))
                .then()
                .spec(ResponseSpecs.logResponse())
                .extract().response();
    }
}

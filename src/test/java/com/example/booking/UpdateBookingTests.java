package com.example.booking;

import com.example.BaseTest;
import com.example.model.Booking;
import com.example.model.User;
import org.junit.jupiter.api.Test;

import static com.example.utils.ResponseUtils.getStatusCode;
import static com.example.utils.ResponseUtils.getToken;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateBookingTests extends BaseTest {

    private int bookingId = 1;
    private Booking booking = new Booking("James", "Brown", 111, true,
            new Booking.BookingDates("2018-01-01", "2019-01-01"), "Breakfast");

    @Test
    public void updateBooking() {
        var token = getToken(authApi.auth(new User("admin", "password123")));
        var response = bookingApi.updateBooking(token, bookingId, booking);
        assertEquals(200, getStatusCode(response), "Status code should be 200");
    }

    @Test
    public void updateBookingWithIncorrectToken() {
        var token = "invalidtoken";
        var response = bookingApi.updateBooking(token, bookingId, booking);
        assertEquals(403, getStatusCode(response), "Status code should be 403");
    }
}

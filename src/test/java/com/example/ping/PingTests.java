package com.example.ping;

import com.example.BaseTest;
import org.junit.jupiter.api.Test;

import static com.example.utils.ResponseUtils.getStatusCode;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PingTests extends BaseTest {

    @Test()
    public void pingTest() {
        var response = pingApi.ping();
        assertEquals(201, getStatusCode(response), "Status code should be 201");
    }
}

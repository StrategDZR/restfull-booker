package com.example.auth;

import com.example.BaseTest;
import com.example.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.example.utils.ResponseUtils.getReason;
import static com.example.utils.ResponseUtils.getStatusCode;
import static com.example.utils.ResponseUtils.getToken;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CreateTokenTests extends BaseTest {

    @Test()
    public void createTokenForValidUserTest() {
        var user = new User("admin", "password123");
        var response = authApi.auth(user);
        assertEquals(200, getStatusCode(response), "Status code should be 200");
        assertNotNull(getToken(response));
    }

    @ParameterizedTest()
    @MethodSource("usersWithBadCredentials")
    public void createTokenForBadCredentialsTest(User user) {
        var response = authApi.auth(user);
        assertEquals(200, getStatusCode(response), "Status code should be 200");
        assertNull(getToken(response));
        assertEquals("Bad credentials", getReason(response));
    }

    private static Stream<User> usersWithBadCredentials() {
        return Stream.of(
                new User("", ""),
                new User("", "password123"),
                new User("admin", "password"),
                new User("admin", "")
                );
    }
}

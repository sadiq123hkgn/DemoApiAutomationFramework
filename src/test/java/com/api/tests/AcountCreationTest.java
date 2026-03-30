package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID; // ✅ Added

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AcountCreationTest {

    @Test(description = "Verify account creation API with valid details")
    public void createAccountTest() {

        // ✅ Generate random but FIXED within this test
        String randomUsername = "user_" + UUID.randomUUID().toString().substring(0,5);
        String randomEmail = "user_" + UUID.randomUUID().toString().substring(0,5) + "@gmail.com";

        // Builder pattern
        SignUpRequest signuprequest = new SignUpRequest.Builder()
                .username(randomUsername) // ✅ replaced
                .password("testpassword")
                .email(randomEmail) // ✅ replaced
                .firstName("Test")
                .lastName("User")
                .mobileNumber("1234567890")
                .build();

        AuthService authService = new AuthService();

        Response response = authService.signUp(signuprequest);

        Assert.assertTrue(response.asPrettyString().contains("User registered successfully"));     
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
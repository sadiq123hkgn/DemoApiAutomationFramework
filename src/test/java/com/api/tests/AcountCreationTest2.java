package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class AcountCreationTest2 {

    @Test(description = "Verify if Password API with valid details")
    public void forgotPasswordTest() {

        AuthService authService = new AuthService();

        // ✅ fixed email typo
        Response response = authService.forgotpassword("smdsadiq34@gmail.com");

        System.out.println(response.asPrettyString());

        // ✅ correct validation
        Assert.assertTrue(
                response.jsonPath()
                        .getString("message")
                        .contains("reset instructions")
        );

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
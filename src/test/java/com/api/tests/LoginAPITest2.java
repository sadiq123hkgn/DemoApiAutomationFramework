package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

@Listeners(com.api.listeners.TestListener.class)

public class LoginAPITest2 {

	@Test(description="Verify login API with valid credentials")
	public void loginTest() {

		LoginRequest loginRequest=new LoginRequest("nowziya@123", "hkgn@123");
		AuthService authService=new AuthService();

		Response response=authService.login
				(loginRequest);

		LoginResponse loginresponse= response.as(LoginResponse.class);
		//here as method is used to convert json response
		//to java object and we need to pass the class name
		//of the java object in which we want to convert the json response
		System.out.println(response.asPrettyString());
		
System.out.println("------------Deserealization------------------");
		
		System.out.println(loginresponse.getToken());
		System.out.println(loginresponse.getEmail());
		System.out.println(loginresponse.getId());
		
		Assert.assertTrue(loginresponse.getToken()!=null);
		Assert.assertEquals(loginresponse.getEmail(), "smdsadiq34@gmail.com");
		Assert.assertEquals(loginresponse.getId(), 3276);

	}
}
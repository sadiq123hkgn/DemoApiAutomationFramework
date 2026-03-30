package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {

	@Test
	public void getPrInfoTest() {
		//1. Sign up a new user
		//2. Login with the new user and get the token
		//3. Update the profile information using the token
		//4. Get the profile information and verify the updated information		

		AuthService authService=new AuthService();

		Response response=	authService.login(new LoginRequest("nowziya@123", "hkgn@123"));

		LoginResponse loginresponse=response.as(LoginResponse.class);

		System.out.println(response.asPrettyString());
		//here we are getting the token from login response and we will use that token to get the profile information
		//eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJub3d6aXlhQDEyMyIsImlhdCI6MTc3NDc4NjMxOCwiZXhwIjoxNzc0Nzg5OTE4fQ.ZtdSXgNVtQVluNV-_osYd2RH93bxIlHhXDbS67M9PZ0

		System.out.println("------------------------------");

		UserProfileManagementService userProfileManagementService=new UserProfileManagementService();
		response=userProfileManagementService.getProfile(loginresponse.getToken());
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse=response.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResponse.getEmail(), "smdsadiq34@gmail.com");
		
		System.out.println("------------------------------");
		
		//update the profile information
		ProfileRequest profileUpdateRequest=new ProfileRequest.Builder()
				.firstName("Nowziya")
				.lastName("Khan")
				.email("smdsadiq34@gmail.com")
				.mobileNumber("7654321234")
				.build();
		
		response=userProfileManagementService.updateProfile(loginresponse.getToken(), profileUpdateRequest);
	
		
		System.out.println(response.asPrettyString());
		
	}



}
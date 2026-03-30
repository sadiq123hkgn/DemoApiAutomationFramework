package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {

	@Test(description="Verify get profile API with valid credentials")
	public void getProfileInfoTest() {

		AuthService authService=new AuthService();

		Response response=	authService.login(new LoginRequest("nowziya@123", "hkgn@123"));
		LoginResponse loginresponse=response.as(LoginResponse.class);
		System.out.println(loginresponse.getToken());
		//here we are getting the token from login response and we will use that token to get the profile information
		//eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJub3d6aXlhQDEyMyIsImlhdCI6MTc3NDc4NjMxOCwiZXhwIjoxNzc0Nzg5OTE4fQ.ZtdSXgNVtQVluNV-_osYd2RH93bxIlHhXDbS67M9PZ0
		UserProfileManagementService userProfileTest=new UserProfileManagementService();


		Response profileResponse=userProfileTest.getProfile(loginresponse.getToken());
		UserProfileResponse userProfileResponse=profileResponse.as(UserProfileResponse.class);
		System.out.println(userProfileResponse.getUsername());
	}

}

package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class LoginAPITest {
	@Test(description="Verify login API with valid credentials")
	public void loginTest() {
	Response response=given().baseUri("http://64.227.160.186:8080")
	.header("Content-Type","application/json")
	.body("{\"username\": \"nowziya@123\", \"password\":\"hkgn@123\"}").post("/api/auth/login");

System.out.println(response.asPrettyString());

Assert.assertEquals(response.getStatusCode(), 200);
}
}
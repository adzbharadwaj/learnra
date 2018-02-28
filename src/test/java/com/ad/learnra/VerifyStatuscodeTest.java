package com.ad.learnra;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;

public class VerifyStatuscodeTest {

  @BeforeClass
  public void beforeClass() {
	  RestAssured.baseURI="https://maps.googleapis.com";
	  RestAssured.basePath="/maps/api/";
  }
  
  @Test(enabled=false)
  public void VerifyStatusCode() {
	  given()
	  		.param("units", "imperial")
	  		.param("origins", "Washington,DC")
	  		.param("destinations", "New+York+City,NY")
	  		.param("key", "AIzaSyCDo-IMtR5zHS2sIIQM5T0Iwc57tLJsu5U")
	  .when()
	  		.get("/distancematrix/json")
	  .then()
	  	.statusCode(200);
	  
  }
  
  @Test
  public void VerifyResponseBody() {
	  Response res =
	  given()
	  		.param("units", "imperial")
	  		.param("origins", "Washington,DC")
	  		.param("destinations", "New+York+City,NY")
	  		.param("key", "AIzaSyCDo-IMtR5zHS2sIIQM5T0Iwc57tLJsu5U")
	  .when()
	  		.get("/distancematrix/json");
	  
	  System.out.println(res.body().prettyPrint());
	  
  }

}

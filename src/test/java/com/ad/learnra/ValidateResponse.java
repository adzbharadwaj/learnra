package com.ad.learnra;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ValidateResponse {

	 @BeforeClass
	  public void beforeClass() {
		  RestAssured.baseURI="https://maps.googleapis.com";
		  RestAssured.basePath="/maps/api/";
	  }
	  
	  @Test
	  public void VerifyResponseBody() {
		  given()
		  		.param("units", "imperial")
		  		.param("origins", "Washington,DC")
		  		.param("destinations", "New+York+City,NY")
		  		.param("key", "AIzaSyCDo-IMtR5zHS2sIIQM5T0Iwc57tLJsu5U")
		  .when()
		  		.get("/distancematrix/json")
		  .then()
		  	.statusCode(200)
		  	.and()
		  	.body("rows[0].elements[0].distance.text", equalTo("225 mi"))
		  	.contentType(ContentType.JSON);
		  
	  }
	
}

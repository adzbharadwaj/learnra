package com.ad.learnra;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequestDemo {

	@BeforeClass
	public void beforeClass() {
		RestAssured.baseURI = "https://maps.googleapis.com";
		RestAssured.basePath = "/maps/api";
	}

	@Test
	public void VerifyStatusCode() {
		given()
			.queryParam("key", "AIzaSyCvynaHt7PyFA-oHMOhrCdYL2NRyef1elQ")
			.body("{"
					 + "\"location\": {" 
					 + "\"lat\": -33.866971,"
					 +  "\"lng\": 151.195875"
					 + "},"  
					 +"\"accuracy\": 50,"
					 + "\"name\": \"Rajdeep Shoes!\","
					 +"\"phone_number\": \"(02) 9374 4000\","
					 +"\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","
					 +"\"types\": [\"shoe_store\"],"
					 +"\"website\": \"http://www.google.com.au/\","
					 +"\"language\": \"en-AU\""
					 +"}")
		.when()
			.post("/place/add/json")
		.then()
			.statusCode(200).and()
			.contentType(ContentType.JSON).and()
			.body("scope", equalTo("APP"));

	}

}

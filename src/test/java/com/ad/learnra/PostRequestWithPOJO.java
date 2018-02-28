package com.ad.learnra;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ad.learnra.models.PlacesAddModel;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequestWithPOJO {

	@BeforeClass
	public void beforeClass() {
		RestAssured.baseURI = "https://maps.googleapis.com";
		RestAssured.basePath = "/maps/api";
	}

	@Test
	public void VerifyStatusCode() {
		Map<String,Double> locationMap = new HashMap<String, Double>();
		locationMap.put("lat", -33.866971);
		locationMap.put("lng", 151.195875);
		
		List<String> typesList = new ArrayList<String>();
		typesList.add("shoe_store");
		
		PlacesAddModel places = new PlacesAddModel();
		places.setLocation(locationMap);
		places.setAccuracy(50);
		places.setName("Rajdeep Shoes!");
		places.setPhone_number("(02) 9374 4000");
		places.setAddress("48 Pirrama Road, Pyrmont, NSW 2009, Australia");
		places.setTypes(typesList);
		places.setWebsite("http://www.google.com.au");
		places.setLanguage("en-AU");
		
		Response res=
		given()
			.queryParam("key", "AIzaSyCvynaHt7PyFA-oHMOhrCdYL2NRyef1elQ")
			.body(places)
		.when()
			.post("/place/add/json");
		System.out.println(res.body().asString());
//		.then()
//			.statusCode(200).and()
//			.contentType(ContentType.JSON).and()
//			.body("scope", equalTo("APP"));

	}

}

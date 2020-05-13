import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class RestAssuredBasics {

	public static void main(String[] args) {

    //Validate if add place is working asexpected
		
		//given: All input details
		//When :submit the API
		//Then :Validate the response
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Frontline house\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://google.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"Sample Response\r\n" + 
				" \r\n" + 
				"{\r\n" + 
				"    \"status\": \"OK\",\r\n" + 
				"    \"place_id\": \"928b51f64aed18713b0d164d9be8d67f\",\r\n" + 
				"    \"scope\": \"APP\",\r\n" + 
				"    \"reference\": \"736f3c9bec384af62a184a1936d42bb0736f3c9bec384af62a184a1936d42bb0\",\r\n" + 
				"    \"id\": \"736f3c9bec384af62a184a1936d42bb0\"\r\n" + 
				"}\r\n" + 
				" \r\n" + 
				"").when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200);
		

	}

}

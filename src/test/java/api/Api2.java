package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Api2 {
    /*
	 Positive Scenario
	 when I send a GET Request to https://restful-booker.herokuapp.com/booking
	 and I accept type "application/json"  ==> Means API is accepting data just in Json Format
	 then status code should be 200
	 and content type should be "application/json" ==> Response body must be in Json format
	 */
       @Test
    public void get(){
         Response response =  given().accept(ContentType.JSON).when().get("https://restful-booker.herokuapp.com/booking");

         response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
       }
       /*
	 Negative Scenario
	 when I send a GET Request to https://restful-booker.herokuapp.com/booking/1001
	 then status code should be 404
	 and Response Body contains "Not Found"
	 and Response Body does not contain "Suleyman"
	*/
/*
		When I send a GET request to REST API URL
		https://restful-booker.herokuapp.com/booking/1
	    And Accept type is “application/JSON”
	    Then
	    HTTP Status Code should be 200
	    And Response format should be "application/JSON"
	    And firstname should be "Susan"  incebelbardak
	    And lastname should be "Brown" kulplu
	    And checkin date should be "2015-02-16" tabak
	    And checkout date should be "2017-06-20" kasik
   */

}

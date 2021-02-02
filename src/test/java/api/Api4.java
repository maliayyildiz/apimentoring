package api;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.TestBase;



import static io.restassured.RestAssured.given;

public class Api4 extends TestBase {
     /*
	 When
		 I send a GET request to REST API URL
		 https://restful-booker.herokuapp.com/booking/5
	 Then
		 HTTP Status Code should be 200
		 And response content type is “application/JSON”
		 And response body should be like;
		 {
		  "firstname": "Sally",
		  "lastname": "Ericsson",
		  "totalprice": 111,
		  "depositpaid": false,
		  "bookingdates": { "checkin": "2017-05-23",
		                    "checkout":"2019-07-02" }
	     }
	*/
    @Test
    public void api(){
        spec03.pathParam("id",5);

        Response response =  given().spec(spec03).when().get("/{id}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
        JsonPath jsonPath = response.jsonPath();

        System.out.println(jsonPath.getString("firstname"));



    }
}

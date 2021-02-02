package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Api1 {

    @Test
    public void semaver(){
      Response response =
         given().accept(ContentType.JSON).when().get("https://restful-booker.herokuapp.com/booking");

       //  response.prettyPrint();

       response.then().assertThat().statusCode(200).contentType("application/json");





    }
}

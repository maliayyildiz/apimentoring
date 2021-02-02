package api;

import io.restassured.response.Response;
import org.junit.Test;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.given;

public class Api8 {
    @Test
    public void api8() {
    Response response = given().
            auth().oauth2(ConfigurationReader.getProperty("token")).
            when().
            get(ConfigurationReader.getProperty("endpoint"));
     response.prettyPrint();



  }
}

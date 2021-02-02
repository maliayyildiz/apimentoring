package api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.ConfigurationReader;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class Api7 {
    @Test
    public void gmi20(){
        Response response = given().
                auth().oauth2(ConfigurationReader.getProperty("token")).
                when().
                get(ConfigurationReader.getProperty("endpoint"));
       // response.prettyPrint();

        JsonPath json = response.jsonPath();
        List<String> expectedData = json.getList("ssn");
        System.out.println(expectedData);

        List<String> actualData = json.getList("ssn");
        System.out.println(actualData);

        assertEquals(expectedData,actualData);

        assertTrue(actualData.contains(expectedData.get(3)));

        for(int i = 0; i<expectedData.size(); i++){
            System.out.println(expectedData.get(i));
            assertTrue(actualData.contains(expectedData.get(i)));
        }












    }
}

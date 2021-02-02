package api;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Api3 extends TestBase {
    /*
		     				Warm Up (13 minutes)
		1) Create a class and name it as you wish :)
		2) When
		     I send a GET Request to https://jsonplaceholder.typicode.com/todos
		   Then
			 HTTP Status code should be "200"
			 And Content type should be in "JSON" format
			 And there should be 200 "title"
			 And "dignissimos quo nobis earum saepe" should be one of the "title"s
			 And 111, 121, and 131 should be among the "id"s
			 And 4th title is "et porro tempora"
			 And last title is "ipsam aperiam voluptates qui"
    */
    @Test
    public void api1() {

       Response response = given().accept(ContentType.JSON).spec(spec02).when().get();
       response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
        Assert.assertEquals(200,jsonPath.getList("id").size());
        Assert.assertTrue(jsonPath.getList("title").contains("dignissimos quo nobis earum saepe"));
        List<Integer> idList = new ArrayList<>();
        idList.add(111);
        idList.add(121);
        idList.add(131);
        Assert.assertTrue(jsonPath.getList("id").containsAll(idList));
        Assert.assertEquals("et porro tempora",jsonPath.getString("title[3]"));
        Assert.assertEquals("ipsam aperiam voluptates qui",jsonPath.getString("title[-1]"));


    }
}

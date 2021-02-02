package api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Api5 extends TestBase {
     /*
	 When
	 	 I send GET Request to http://dummy.restapiexample.com/api/v1/employees
	 Then
		 Status code is 200
		 1)Print all ids greater than 10 on the console
		   Assert that there are 14 ids greater than 10
		 2)Print all ages less than 30 on the console
		   Assert that maximum age is 23
		 3)Print all employee names whose salaries are greater than 350000
		   Assert that Charde Marshall is one of the employees whose salary is greater than 350,000
		 4)Print all employee salaries whose ids are less than 11
		   Assert that maximum salary is 433060
	 */
    @Test
    public void api(){
        Response response = given().spec(spec01).when().get();
        response.prettyPrint();

        response.then().assertThat().statusCode(200);
        JsonPath jsonPath = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();
        /*
		 What is the difference between Hard Assertion and Soft Assertion?
		 In Hard Assertion, if any assertion fails next ones do not executed.
		 In Soft Assertion, all assertions are executed everytime then you get report
		 for all assertions one by one.
		*/

		/*
		 There are 3 steps for Soft Assertion
		 1)You have to create an object from SoftAssert class
		   SoftAssert softAssert = new SoftAssert();
		 2)You select assertion methods form SoftAssert Class by using softAssert object
		 3)Do not forget to type assertAll() method at the end.
		   If you do not type assertAll() method at the end you will get green everytime but it is not meaningful
		*/
        List<String> idList = jsonPath.getList("data.findAll{Integer.valueOf(it.id)>10}.id");
        System.out.println(idList);
        softAssert.assertEquals(idList.size(),14);


        List<String> ageList = jsonPath.getList("data.findAll{Integer.valueOf(it.employee_age)<30}.employee_age");
        System.out.println(ageList);

        List<Integer> newAgeList = new ArrayList<>();
        for (String age : ageList){
            newAgeList.add(Integer.valueOf(age));
        }
        System.out.println(newAgeList);

        Collections.sort(newAgeList);
        System.out.println(newAgeList);
        softAssert.assertTrue(newAgeList.get(newAgeList.size()-1)==23);

        softAssert.assertAll();






    }
}
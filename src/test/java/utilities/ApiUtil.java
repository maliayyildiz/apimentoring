package utilities;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiUtil {
    private final static String api_uri = " http://www.gmibank.com/api";
    private static String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJlbXBsb3llZXRlYW0xMyIsImF1dGgiOiJST0xFX0VNUExPWUVFIiwiZXhwIjoxNjA4OTk1NjE4fQ.vwPkbmk91BcN97YL6d8FoWIP_0ugCp4Bb8EisV6Ux7iHc789FCB2nnF8NwrbVQuohhUBcWorIkiOMol3j9BbIw";
    private static Response response;
    private static String getToken() {
        return token;
    }
    private static void setToken(String t) {
        token = t;
    }
    private static void generateToken() {
        Map<String, String> reqBody = new HashMap<>();
        reqBody.put("username", ConfigurationReader.getProperty("Employee_username"));
        reqBody.put("password", ConfigurationReader.getProperty("Employee_password"));
        response =
                given()
                        .contentType("application/JSON")
                        .body(reqBody)
                        .when()
                        .post(api_uri + "/auth/authenticate");
        Map<String, Object> map = response.as(HashMap.class);
        String token = map.get("token").toString();
        setToken(token);
    }
    public static Response post(String pathParams, Map<String, String> reqBody) {
        try {
            response =
                    given()
                            .auth().oauth2(token)
                            .contentType("application/JSON")
                            .body(reqBody)
                            .when()
                            .post(api_uri + pathParams);
            if (response.statusCode() == 401) throw new Exception("new token required");
        } catch (Exception e) {
            generateToken();
            post(pathParams, reqBody);
//            e.printStackTrace();
        }
        return response;
    }

    public static Response put(String pathParams, Map<String, String> reqBody) {
        try {
            response =
                    given()
                            .auth().oauth2(token)
                            .contentType("application/JSON")
                            .body(reqBody)
                            .when()
                            .put(api_uri + pathParams);
            if (response.statusCode() == 401) throw new Exception("new token required");
        } catch (Exception e) {
            generateToken();
            post(pathParams, reqBody);
//            e.printStackTrace();
        }
        return response;
    }
    public static Response get(String pathParams) {
        try {
            response = given()
                    .auth().oauth2(getToken())
                    .when()
                    .get(api_uri + pathParams);
            if (response.statusCode() == 401) throw new Exception("new token required");
        } catch (Exception e) {
            generateToken();
            get(pathParams);
        }
        return response;
    }
    public static Map<String, List<Map<String, Object>>> getResponseAsMap(String pathParams) {
        response = get(pathParams);
        return response.as(HashMap.class);
    }

    public static void main(String[] args) {
    response= get("/tp-countries");
    response.prettyPrint();

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("id", "18937");
        requestBody.put("name", "new eeeee");

        response = ApiUtil.put("/tp-countries", requestBody);
        response.prettyPrint();
    }
}

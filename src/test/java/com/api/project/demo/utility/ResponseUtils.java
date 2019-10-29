package com.api.project.demo.utility;

import java.util.List;
import java.util.Map;

import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

/**
 * @author abhishek.sharda
 *
 */
public class ResponseUtils {
    public static Response response;

    /**
     * Deserialize Json response to an String
     * 
     * @param jsonPath
     * @return
     */
    public static String getDataFromResponseUsingJsonPath(String jsonPath) {
        response.prettyPrint();
        return response.then().extract().jsonPath().getString(jsonPath);
    }

    /**
     * Deserialize Json response to an List
     * 
     * @param jsonPath
     * @return
     */
    public static List<Object>
           getListFromResponseUsingJsonPath(String jsonPath) {
        return response.then().extract().jsonPath().getList(jsonPath);
    }

    /**
     * Deserialize Json response to an Map
     * 
     * @param jsonPath
     * @return
     */
    public static Map<String, Object>
           getMapFromResponseUsingJsonPath(String jsonPath) {
        return response.then().extract().jsonPath().getMap(jsonPath);
    }

    /**
     * @param expectedStatusCode
     */
    public static void assertReponseStatus(int expectedStatusCode) {
        response.prettyPrint();
        response.then().statusCode(expectedStatusCode);

    }

    /**
     * Here just pass the JSON schema from your step definition. It will
     * validate the JSON Schema With The Response
     * 
     * @param schema
     */
    public static void validateJsonSchema(String schema) {
        response.prettyPrint();
        response.then().assertThat().body(JsonSchemaValidator
                .matchesJsonSchema(Utility.readResponseJsonSchema(schema)));

    }

    /**
     * This Method will return the Response Headers
     */
    public static Headers getResponseHeaders() {
        return response.getHeaders();
    }
}

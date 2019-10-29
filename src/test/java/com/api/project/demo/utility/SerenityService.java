package com.api.project.demo.utility;

import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

public class SerenityService extends SerenityRESTService {
    /**
     * Wrapper method which makes a restassured post call with form parameter
     * 
     * @param formParams
     * @param URL
     * @param contentType
     * @return
     * @throws Exception
     */
    public static Response preemptiveAuthWithFormParam(
            Map<String, String> formParams, String URL, String contentType)
            throws Exception {
        return SerenityRest.given().relaxedHTTPSValidation()
                .formParams(formParams).contentType(getContentType(contentType))
                .auth().preemptive().basic("system", "glpApp").log().all()
                .when().post(URL);
    }

    /**
     * Wrapper method which makes a restassured post call with headers and form
     * parameter
     * 
     * @param jsonObject
     * @param URL
     * @param contentType
     * @return
     * @throws Exception
     */
    public static Response postCallWithJsonBodyParam(String jsonBodyAsString,
            String URL, String contentType) throws Exception {
        return SerenityRest.given().relaxedHTTPSValidation()
                .contentType(getContentType(contentType)).body(jsonBodyAsString)
                .log().all().when().post(URL);
    }

    private static ContentType getContentType(String contentType)
            throws Exception {
        if (contentType.equalsIgnoreCase("JSON")) {
            return ContentType.JSON;
        }
        if (contentType.equalsIgnoreCase("URLENC")) {
            return ContentType.URLENC;
        }
        if (contentType.equalsIgnoreCase("TEXT")) {
            return ContentType.TEXT;
        }
        if (contentType.equalsIgnoreCase("HTML")) {
            return ContentType.HTML;
        }
        if (contentType.equalsIgnoreCase("BINARY")) {
            return ContentType.BINARY;
        }
        if (contentType.equalsIgnoreCase("XML")) {
            return ContentType.XML;
        }
        if (contentType.equalsIgnoreCase("")) {
            return ContentType.JSON;
        }
        if (contentType.equalsIgnoreCase("Any")) {
            return ContentType.ANY;
        } else
            throw new Exception(
                    "Not a valid Content Type, Please set the valid Content Type");
    }

}

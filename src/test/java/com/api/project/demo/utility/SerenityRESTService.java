package com.api.project.demo.utility;

import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

/**
 * Legacy Rest Service class which supplies the Serenity wrapper methods
 * available in integrated test framework to support serenity compatibility for
 * the users who uses integrated test framework and want to migrate to serenity
 * falcon.
 * 
 * @author akash rastogi
 *
 */
public class SerenityRESTService {

    /**
     * Wrapper method which makes simple restassured get call
     *
     * @param URL
     * @return response
     */
    public static Response getCall(String URL) {
        return SerenityRest.get(URL);
    }

    /**
     * Wrapper method which makes a restassured get call with path parameter
     * 
     * @param pathParams
     * @param URL
     * @param contentType
     * @return
     * @throws Exception
     */
    public static Response getCallWithPathParam(Map<String, String> pathParams,
            String URL, String contentType) throws Exception {
        return SerenityRest.given().contentType(getContentType(contentType))
                .pathParams(pathParams).log().all().get(URL);
    }

    /**
     * Wrapper method which makes a restassured get call with header parameter
     * 
     * @param headers
     * @param URL
     * @param contentType
     * @return
     * @throws Exception
     */
    public static Response getCallWithHeader(Map<String, String> headers,
            String URL, String contentType) throws Exception {
        return SerenityRest.given().relaxedHTTPSValidation().headers(headers)
                .contentType(getContentType(contentType)).when().log().all()
                .get(URL);
    }

    /**
     * Wrapper method which makes a restassured get call with header path
     * parameter
     * 
     * @param headers
     * @param pathParam
     * @param URL
     * @param contentType
     * @return
     * @throws Exception
     */
    public static Response getCallWithHeaderAndPathParam(
            Map<String, String> headers, Map<String, String> pathParam,
            String URL, String contentType) throws Exception {
        return SerenityRest.given().relaxedHTTPSValidation().headers(headers)
                .pathParams(pathParam).contentType(getContentType(contentType))
                .log().all().when().get(URL);
    }

    /**
     * Wrapper method which makes a restassured get call without any parameter
     * 
     * @param URL
     * @param contentType
     * @return
     * @throws Exception
     */
    public static Response getCallWithContentType(String URL,
            String contentType) throws Exception {
        return SerenityRest.given().relaxedHTTPSValidation()
                .contentType(getContentType(contentType)).log().all().when()
                .get(URL);
    }

    /**
     * Wrapper method which makes a restassured get call with header and query
     * parameter
     * 
     * @param headers
     * @param pathParam
     * @param URL
     * @param contentType
     * @return
     * @throws Exception
     */
    public static Response getCallWithHeaderAndQueryParam(
            Map<String, String> headers, Map<String, String> pathParam,
            String URL, String contentType) throws Exception {
        return SerenityRest.given().relaxedHTTPSValidation().headers(headers)
                .queryParams(pathParam).contentType(getContentType(contentType))
                .log().all().when().get(URL);
    }

    /**
     * Wrapper method which makes a restassured post call with form parameter
     * 
     * @param formParams
     * @param URL
     * @param contentType
     * @return
     * @throws Exception
     */
    public static Response postCallWithFormParam(Map<String, String> formParams,
            String URL, String contentType) throws Exception {
        return SerenityRest.given().relaxedHTTPSValidation()
                .formParams(formParams).contentType(getContentType(contentType))
                .log().all().when().post(URL);
    }

    /**
     * Wrapper method which makes a restassured post call with headers and form
     * parameter
     * 
     * @param headers
     * @param formParam
     * @param URL
     * @param contentType
     * @return
     * @throws Exception
     */
    public static Response postCallWithHeaderAndFormParam(
            Map<String, String> headers, Map<String, String> formParam,
            String URL, String contentType) throws Exception {
        return SerenityRest.given().relaxedHTTPSValidation().headers(headers)
                .formParams(formParam).contentType(getContentType(contentType))
                .log().all().when().post(URL);
    }

    /**
     * Wrapper method which makes a restassured post call with headers and form
     * parameter
     * 
     * @param obj
     * @param URL
     * @param contentType
     * @return
     * @throws Exception
     */
    public static Response postCallWithJsonBodyParam(org.json.JSONObject obj,
            String URL, String contentType) throws Exception {
        return SerenityRest.given().relaxedHTTPSValidation()
                .contentType(getContentType(contentType)).body((Object) obj)
                .log().all().when().post(URL);
    }

    /**
     * Wrapper method which makes a restassured post call with body and path
     * parameter
     * 
     * @param jsonObject
     * @param URL
     * @param contentType
     * @return
     * @throws Exception
     */

    public static Response postCallWithJsonBodyAndPathParam(
            String jsonBodyAsString, Map<String, Object> pathParam, String URL,
            String contentType) throws Exception {
        return SerenityRest.given().relaxedHTTPSValidation()
                .contentType(getContentType(contentType)).pathParams(pathParam)
                .body(jsonBodyAsString).log().all().when().post(URL);
    }

    /**
     * Wrapper method which makes a restassured post call with header and body
     * parameter
     * 
     * @param headers
     * @param jsonBodyAsString
     * @param URL
     * @param contentType
     * @return
     * @throws Exception
     */
    public static Response postCallWithHeaderAndJsonBodyParam(
            Map<String, String> headers, String jsonBodyAsString, String URL,
            String contentType) throws Exception {
        return SerenityRest.given().relaxedHTTPSValidation().headers(headers)
                .contentType(getContentType(contentType)).body(jsonBodyAsString)
                .log().all().when().post(URL);
    }

    /**
     * Wrapper method which makes a restassured post call with header and body
     * parameter
     * 
     * @param headers
     * @param jsonBodyAsString
     * @param URL
     * @param contentType
     * @return
     * @throws Exception
     */
    public static Response postCallWithContentTypeAndJsonBodyParam(
            String jsonBodyAsString, String URL, String contentType)
            throws Exception {
        return SerenityRest.given().relaxedHTTPSValidation()
                .contentType(getContentType(contentType)).body(jsonBodyAsString)
                .log().all().when().post(URL);
    }

    /**
     * Wrapper method which makes a restassured post call with Header and body
     * parameter
     * 
     * @param headers
     * @param jsonObject
     * @param URL
     * @param contentType
     * @return
     * @throws Exception
     */
    public static Response postCallWithHeaderAndBodyParam(
            Map<String, String> headers, String jsonBodyAsString, String URL,
            String contentType) throws Exception {
        return SerenityRest.given().relaxedHTTPSValidation().headers(headers)
                .contentType(getContentType(contentType)).body(jsonBodyAsString)
                .log().all().when().post(URL);
    }

    /**
     * Wrapper method which makes a restassured post call with header and
     * content type only
     * 
     * @param headers
     * @param URL
     * @param contentType
     * @return
     * @throws Exception
     */
    public static Response postCallWithHeaderParam(Map<String, String> headers,
            String URL, String contentType) throws Exception {
        return SerenityRest.given().relaxedHTTPSValidation().headers(headers)
                .contentType(getContentType(contentType)).log().all().when()
                .post(URL);
    }

    /**
     * Wrapper method which makes a restassured delete call with body and
     * headers
     * 
     * @param headers
     * @param jsonObject
     * @param URL
     * @param contentType
     * @return
     * @throws Exception
     */
    public static Response deleteCallWithHeaderAndPathParam(
            Map<String, String> headers, String jsonBodyAsString, String URL,
            String contentType) throws Exception {
        return SerenityRest.given().relaxedHTTPSValidation().headers(headers)
                .contentType(getContentType(contentType)).body(jsonBodyAsString)
                .log().all().when().delete(URL);
    }

    /**
     * Wrapper method which makes a restassured delete call with only content
     * type
     * 
     * @param URL
     * @param contentType
     * @return
     * @throws Exception
     */
    public static Response deleteCallWithPathParam(String URL,
            String contentType) throws Exception {
        return SerenityRest.given().relaxedHTTPSValidation()
                .contentType(getContentType(contentType)).log().all().when()
                .delete(URL);
    }

    /**
     * Wrapper method which makes a restassured delete call with header and
     * content type
     * 
     * @param headers
     * @param URL
     * @param contentType
     * @return
     * @throws Exception
     */
    public static Response deleteCallWithHeaderAndPathParamWithoutRequestBody(
            Map<String, String> headers, String URL, String contentType)
            throws Exception {
        return SerenityRest.given().relaxedHTTPSValidation().headers(headers)
                .contentType(getContentType(contentType)).log().all().when()
                .delete(URL);
    }

    /**
     * Wrapper method which makes a restassured delete call with header and body
     * 
     * @param headers
     * @param jsonObject
     * @param URL
     * @param contentType
     * @return
     * @throws Exception
     */
    public static Response putCallWithHeaderAndJsonParam(
            Map<String, String> headers, String jsonBodyAsString, String URL,
            String contentType) throws Exception {
        return SerenityRest.given().relaxedHTTPSValidation().headers(headers)
                .contentType(getContentType(contentType)).body(jsonBodyAsString)
                .log().all().when().put(URL);
    }

    /**
     * Wrapper method which makes a restassured delete call with content type
     * and body
     * 
     * @param jsonObject
     * @param URL
     * @param contentType
     * @return
     * @throws Exception
     */
    public static Response putCallWithContentTypeAndJsonParam(
            String jsonBodyAsString, String URL, String contentType)
            throws Exception {
        return SerenityRest.given().relaxedHTTPSValidation()
                .contentType(getContentType(contentType)).body(jsonBodyAsString)
                .log().all().when().put(URL);
    }

    /**
     * Wrapper method which makes a restassured put call with body, header and
     * content type
     * 
     * @param headers
     * @param jsonBodyAsString
     * @param URL
     * @param contentType
     * @return
     * @throws Exception
     */
    public static Response putCallWithHeaderAndBodyParam(
            Map<String, String> headers, String jsonBodyAsString, String URL,
            String contentType) throws Exception {
        return SerenityRest.given().relaxedHTTPSValidation().headers(headers)
                .contentType(getContentType(contentType)).body(jsonBodyAsString)
                .log().all().when().put(URL);
    }

    /**
     * Wrapper method which makes a restassured put call with body and content
     * type
     * 
     * @param jsonObject
     * @param URL
     * @param contentType
     * @return
     * @throws Exception
     */
    public static Response putCallWithJsonBodyParam(String jsonBodyAsString,
            String URL, String contentType) throws Exception {
        return SerenityRest.given().relaxedHTTPSValidation()
                .contentType(getContentType(contentType)).body(jsonBodyAsString)
                .log().all().when().put(URL);
    }

    /**
     * Wrapper method which makes a restassured put call with header and path
     * parameters
     * 
     * @param headers
     * @param pathParams
     * @param jsonBodyAsString
     * @param URL
     * @param contentType
     * @return
     * @throws Exception
     */
    public static Response putCallWithHeaderAndPathParamAndJsonBody(
            Map<String, String> headers, Map<String, String> pathParams,
            String jsonBodyAsString, String URL, String contentType)
            throws Exception {
        return SerenityRest.given().relaxedHTTPSValidation()
                .contentType(getContentType(contentType)).headers(headers)
                .pathParams(pathParams).body(jsonBodyAsString).log().all()
                .when().put(URL);
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
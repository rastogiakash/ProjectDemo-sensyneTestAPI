package com.api.project.demo.stepdefinations;

import static com.api.project.demo.utility.ResponseUtils.response;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.api.project.demo.base.SerenityBase;
import com.api.project.demo.utility.ResponseUtils;
import com.api.project.demo.utility.SerenityRESTService;
import com.api.project.demo.utility.Utility;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Scenarios extends SerenityBase {

    protected static String baseUrl = null; // Stores Base Url
    protected static boolean userNameFoundFlag = false;
    protected static String getProductName = null;
    protected static Integer getProductID = 0;
    protected static Map<String, String> updatedPayload = new HashMap<>();
    protected static String payload = null;

    @Given("^I have the base URL$")
    public void i_have_the_base_url() throws Throwable {
        baseUrl = configurationsXlsMap.get("baseURL");
    }

    @When("^I send the GET request for \"([^\"]*)\"$")
    public void i_send_the_get_request_for_something(String argResourcePath)
            throws Throwable {
        response = SerenityRESTService
                .getCallWithContentType(baseUrl + argResourcePath, "json");
        APP_LOG.info("Response is  : " + response.prettyPrint());
    }

    @Then("^I should receive the correct response code \"([^\"]*)\"$")
    public void i_should_receive_the_correct_response_code_something(
            String argStatusCode) throws Throwable {
        int expectedStatusCode = Integer.parseInt(argStatusCode);
        ResponseUtils.assertReponseStatus(expectedStatusCode);
    }

    @Then("^I should receive the correct response with one productName as \"([^\"]*)\"$")
    public void i_should_receive_the_correct_response_with_one_productName_as(
            String argUserName) throws Exception {

    	JSONObject obj = new JSONObject(response.asString());
        String getProductName = obj.getString("name");
               
        if (getProductName.contentEquals(argUserName)) {
           userNameFoundFlag = true;
        }
        		
        assertTrue(userNameFoundFlag,
                "User Name " + argUserName + " not found in response");

    }

    @Then("^I should receive the correct list of ALL products with one productName as \"([^\"]*)\"$")
    public void i_should_receive_the_correct_list_of_ALL_products_with_one_productName_as(
            String argUserName) throws Exception {
    	JSONArray arr = new JSONArray(response.asString());
        for (int i = 0; i < arr.length(); i++) {
        	getProductName = arr.getJSONObject(i).getString("name");
        
        	if (getProductName.contentEquals(argUserName)) {
                userNameFoundFlag = true;
                break;
            }
        }
        		
        assertTrue(userNameFoundFlag,
                "User Name " + argUserName + " not found in response");
    }
    
    
    @When("^I send the POST request for \"([^\"]*)\" with payload \"([^\"]*)\"$")
    public void i_send_the_POST_request_for_with_payload(String argResourcePath,
            String argPayload) throws Exception {

        updatedPayload.put("update", Utility.getRandomString());
        payload = Utility.alterJson(argPayload, updatedPayload);
        response = SerenityRESTService.postCallWithContentTypeAndJsonBodyParam(
                payload, baseUrl + argResourcePath, "json");
        APP_LOG.info("Response is  : " + response.prettyPrint());

    }

    @When("^I send the PUT request for \"([^\"]*)\" with payload \"([^\"]*)\"$")
    public void i_send_the_PUT_request_for_with_payload(String argResourcePath,
            String argPayload) throws Exception {
        updatedPayload.put("update", Utility.getRandomString());
        payload = Utility.alterJson(argPayload, updatedPayload);
        response = SerenityRESTService.putCallWithContentTypeAndJsonParam(
                payload, baseUrl + argResourcePath, "json");
        APP_LOG.info("Response is  : " + response.prettyPrint());
    }

    @When("^I send the DELETE request for \"([^\"]*)\"$")
    public void i_send_the_DELETE_request_for(String argResourcePath) throws Throwable {   	
    	response = SerenityRESTService.deleteCallWithPathParam(baseUrl + argResourcePath,"json"); // Delete the request node
    	
    	
    	//JSONObject obj = new JSONObject(response.asString());
    	// obj.remove(getProductName);
    	/*
    	System.out.print("\n Response :=======>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + response.asString() + "\n");
    	
    	
        String getProductName = obj.getString("name");
      	        System.out.print("\n getProductName :=======>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + getProductName + "\n");
              	
        if (getProductName.contentEquals(deleteProductName)) {
           userNameFoundFlag = true;
           obj.remove(getProductName);
        }
        		
        assertTrue(userNameFoundFlag,
                "User Name " + deleteProductName + " not found in response"); 	
    	*/
    	
    	
    	
   //    response = SerenityRESTService.deleteCallWithHeaderAndPathParamWithoutRequestBody("", endpoint, "json"); // Sends the request
   /*
    	JSONArray arr = new JSONArray(response.asString());
        for (int i = 0; i < arr.length(); i++) {
        	getProductName = arr.getJSONObject(i).getString("name");
            
        	System.out.print("\n getProductName :=======>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + getProductName + "\n");
            
        	if (getProductName.equals(deleteProductName)) {
                userNameFoundFlag = true;
                arr.remove(i);
                break;
            }
        }
        		
        assertTrue(userNameFoundFlag,
                "User Name " + deleteProductName + " not found in response");
    */
    }
    
    
    @Then("^I should receive the correct response with one deleted productID as \"([^\"]*)\"$")
    public void i_should_receive_the_correct_response_with_one_deleted_productID_as(Integer deletedProductID) throws Throwable {
    	JSONArray arr = new JSONArray(response.asString());
        for (int i = 0; i < arr.length(); i++) {
        	getProductID = arr.getJSONObject(i).getInt("id");
            
        	System.out.print("\n getProductID :=======>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + getProductID + "\n");
            
        	if (getProductID.equals(deletedProductID)) {
                userNameFoundFlag = true;
                break;
            }
        }
        		
        assertTrue(userNameFoundFlag,
                "Product ID " + deletedProductID + " not found in response");
    
    }

}
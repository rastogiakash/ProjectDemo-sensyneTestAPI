#Author: Akash Rastogi
#Date  : 28-Oct-2019
#Feature: List of product scenario.

Feature: List of Product scenario
         Here it should list the product and we verify it by verifying the status code and also that one of the product  
         exists from the list of products.
        
   @Demo
    Scenario: Verify one product from the List the products - GET 1 Product request
		Given I have the base URL
		When I send the GET request for "/product/2"
		Then I should receive the correct response code "200"
		And  I should receive the correct response with one productName as "Personalised cufflinks"
		
		@Demo
    Scenario: Verify that it returns a list ALL the products - GET ALL products request
		Given I have the base URL
		When I send the GET request for "/products"
		Then I should receive the correct response code "200"
		And  I should receive the correct list of ALL products with one productName as "Lavender heart"
		
		@Demo
    Scenario: Make a new Product - Post request
		Given I have the base URL
		When I send the POST request for "/product" with payload "PostRequest"
		Then I should receive the correct response code "200"
		
		@Demo
    Scenario: Update a Product - PUT Request
		Given I have the base URL
		When I send the PUT request for "/product/11" with payload "PutRequest"
		Then I should receive the correct response code "200"
		
		@Demo
    Scenario: Delete a product - DELETE 1 product Request
		Given I have the base URL
		When I send the DELETE request for "/product/27"
		Then I should receive the correct response code "200"
		Then I send the GET request for "/products"
		And  I should receive the correct response with one deleted productID as "27"
		
		@Exception
    Scenario: Make a new Product with incorrect payload - Post request
		Given I have the base URL
		When I send the POST request for "/product" with payload "PostRequestError"
		Then I should receive the correct error response code "400"
		And I should receive the correct error response payload with error desc "'price' is a required property" 
		
		@Exception
		Scenario: Delete a product - DELETE 1 product Request
		Given I have the base URL
		When I send the DELETE request for "/product/28"
		Then I should receive the correct error response code "404"
		And I should receive the correct error response payload with error desc "The requested URL was not found on the server. If you entered the URL manually please check your spelling and try again." 
		
		
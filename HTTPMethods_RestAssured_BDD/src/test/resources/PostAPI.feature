
Feature: POSTAPI method
@POST
  Scenario: POST API
    Given Launch the base URL for POST
   	When Add the headers for Post method
   	And create the body 	
    And Add POST method and the end point
    And generate the response body for post
    Then Validate the POST response
 
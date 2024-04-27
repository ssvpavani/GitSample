
Feature: PUTAPI method
  @PUT
  Scenario: PUT API
    Given Launch the base URL for PUT
   	When Add the headers for Put method
   	And Update the body
    And Add PUT method and the end point
    And generate the response body for put
    Then Validate the PUT response

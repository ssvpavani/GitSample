
Feature: GetAPI method
  @GET
  Scenario: GetAPI
    Given Launch the base url for Get
    And Add GET method and the end point
    And generate the response body for Get
    Then Validate the GET response


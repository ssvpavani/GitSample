Feature: PATCHAPI method

  @Patch
  Scenario: PATCH API
    Given Launch the base URL for PATCH
   	When Add the headers and body for PATCH method
    And Add PATCH method and the end point
    And generate the response body for PATCH
    Then Validate the PATCH response
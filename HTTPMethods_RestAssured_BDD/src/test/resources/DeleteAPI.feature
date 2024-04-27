Feature: DeleteAPI method

  @Delete
  Scenario: Delete API
    Given Launch the base URL for Delete
   	When Add the headers for Delete method
    And Add Delete method and the end point
    And generate the response body for Delete
    Then Validate the Delete response
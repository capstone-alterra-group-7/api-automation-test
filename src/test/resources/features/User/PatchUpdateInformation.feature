Feature: As a user i want to update information account with method patch

  @PatchUpdateInformation-validRequest
  Scenario: as user i want to input valid endpoint so that i can update information account
    Given user has endpoint login
    When user send request for get token
    When user has endpoint to update information
    And user patch update information
    Then user can update information with status code 200
    And i can validate data with message response
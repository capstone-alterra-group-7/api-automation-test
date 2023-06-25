Feature: As a user i want to update information account with method patch

  @TESTCASE-CATAPI49
  Scenario: as user i want to input valid endpoint so that i can update information account
    Given user has endpoint login
    When user send request for get token
    When user has endpoint to update information
    And user patch update information
    Then user can update information with status code 200
    And i can validate data with message response

  @TESTCASE-CATAPI50
  Scenario: as user i want to input invalid request so that i cannot update information account
    Given user set endpoint login
    When user send request to endpoint login for get token
    When user has valid endpoint for update information
    And user send request to endpoint update information
    Then user can see status code 400
    And i can see validate data with message response
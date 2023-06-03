Feature: As a user i want to get credentials from data token user

  @TESTCASE-CATAPI6
  Scenario: as user i want to input valid endpoint and valid token so that i can see credentials
    Given user has valid endpoint auth login
    When user send request for get token from auth
    When user has endpoint to get credentials
    And user get credentials
    Then user get credentials with status code 200
    And i receive valid data message response
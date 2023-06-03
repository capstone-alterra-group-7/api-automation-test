Feature: As a user i want to update password with method put

  @TESTCASE-CATAPI52
  Scenario: as user i want to input valid endpoint so that i can update information account
    Given user has endpoint login user
    When user send request to endpoint login user for get token
    When user set endpoint to update password
    And user send request for update password
    Then user can update password with status code 200
    And user can validate data with message response
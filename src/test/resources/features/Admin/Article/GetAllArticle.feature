Feature: As a user i want to get all data articles

  @TESTCASE-CATAPI103
  Scenario: as user i want to input valid endpoint so that i can see detail data articles
    Given user has valid endpoint for login admin
    When user send request for get token admin
    When user has endpoint to get articles
    And user send request to endpoint articles
    Then user get all detail articles with status code 200
    And i validate data with message response

  @TESTCASE-CATAPI104
  Scenario: as user i want to input invalid endpoint so that i cannot see detail data articles
    Given user has valid endpoint for login admin
    When user send request for get token admin
    When user has invalid endpoint for get articles
    And user send request to invalid endpoint articles
    Then user cannot get all detail articles with status code 404
    And i validate data with error message response

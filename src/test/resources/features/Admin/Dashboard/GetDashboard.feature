Feature: As a user i want to get all data on dashboard

  @TESTCASE-CATAPI108
  Scenario: as user i want to input valid endpoint so that i can see detail data on dashboard page
    Given user set valid endpoint for login as admin
    When user send request for login admin
    When user has endpoint to get dashboard
    And user send request to endpoint dashboard
    Then user get all detail dashboard with status code 200
    And i validate data dashboard with message response

  @TESTCASE-CATAPI109
  Scenario: as user i want to input invalid endpoint so that i cannot get detail data on dashboard
    Given user set valid endpoint for login as admin
    When user send request for login admin
    When user has invalid endpoint to get dashboard
    And user send request to invalid endpoint dashboard
    Then user get cannot detail dashboard with status code 404
    And i validate error with message response

  @TESTCASE-CATAPI110
  Scenario: as user i want to input valid endpoint but without auth so that i cannot get detail data on dashboard
    Given user has valid endpoint to get dashboard
    When user send request to valid endpoint dashboard
    Then user validate response with status code 401
    And user validate error with message response
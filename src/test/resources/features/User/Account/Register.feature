Feature: As a user i want to create new user so that i can login

  @TESTCASE-CATAPI4
  Scenario: as user i want to input valid endpoint for create new user
    Given user has endpoint post new user register
    When user send request for create new user register
    Then user get status code 201
    And i receive valid data for new account

  @TESTCASE-CATAPI5
  Scenario: as user i want to cannot register cause email already used
    Given user has endpoint post new user register
    When user send request with existing email
    Then user see status code 400
    And i receive valid error message

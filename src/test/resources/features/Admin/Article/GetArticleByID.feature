Feature: As a user i want to get data article by id

  @TESTCASE-CATAPI105
  Scenario: as user i want to input valid endpoint so that i can see detail data article by id
    Given user has valid endpoint for login admin
    When user send request for get token admin
    When user has endpoint to get article by id
    And user send request to endpoint article by id
    Then user get detail article by id with status code 200
    And i validate data article by id with message response

  @TESTCASE-CATAPI106
  Scenario: as user i want to input valid endpoint but invalid id so that i cannot see data article
    Given user has valid endpoint for login admin
    When user send request for get token admin
    When user has endpoint to get article with invalid id
    And user send request to endpoint article with invalid id
    Then user cannot get detail article cause invalid id and see status code 400
    And i validate error response

  @TESTCASE-CATAPI107
  Scenario: as user i want to input invalid endpoint so that i cannot see detail data article by id
    Given user has valid endpoint for login admin
    When user send request for get token admin
    When user has invalid endpoint to get article
    And user send request to invalid endpoint article
    Then user cannot get detail article cause invalid endpoint and see status code 404
    And user see error response
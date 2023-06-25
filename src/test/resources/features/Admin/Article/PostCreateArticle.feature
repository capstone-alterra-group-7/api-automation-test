Feature: As a user i want to create new article so that i can see detail article

  @TESTCASE-CATAPI94
  Scenario: as user i want to create new article so that i can see detail article
    Given user set valid endpoint for login admin
    When user send request to auth admin
    When user set endpoint for create a new article
    And user send request to request url for create a new article
    Then user success create article and see status code 201
    And i validate data article

  @TESTCASE-CATAPI98
  Scenario: as user i want to create new article without auth
    Given user has endpoint for create a new article
    When user send request for create a new article
    Then user cannot create article and see status code 401
    And i validate data article with message unatuhorized
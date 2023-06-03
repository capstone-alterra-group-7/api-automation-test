Feature: As a user i want to create new article so that i can see detail article

  @TESTCASE-CATAPI94
  Scenario: as user i want to input valid endpoint for create new article
    Given user has endpoint for create a new article
    When user send request for create a new article
    Then user success create article and see status code 201
    And i validate data article
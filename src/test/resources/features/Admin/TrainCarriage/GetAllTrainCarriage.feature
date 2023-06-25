@getalltraincarriage
Feature: As a user i want to get all train carriage
  As a admin
  I want to see list of train carriage
  So that i can see all train carriage

  @GetAllProductValidEndpoint
  Scenario: Get Product Valid Endpoint - As a admin i want to get all train carriage with valid endpoint
    Given I have endpoint post new login for Get All Train Carriage
    When I send request to endpoint for Get All Train Carriage
    When user set GET valid endpoint
    When user send GET HTTP request with valid endpoint
    Then user received valid GET HTTP response code 200

  @GetAllProductInvalidEndpoint
  Scenario: Get Product Invalid Endpoint - As a admin i want to get all train carriage with invalid endpoint
    Given I have invalid endpoint post new login for Get All Train Carriage
    When I send invalid request to endpoint for Get All Train Carriage
    When user set invalid GET valid endpoint
    When user send invalid GET HTTP request with valid endpoint
    Then user received invalid GET HTTP response code 404
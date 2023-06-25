@gettraincarriagebyid
Feature: As a user i want to get train carriage by id
  As a admin
  I want to see train carriage by id
  So that i can see that train carriage

  @gettraincarriagebyidvalid
  Scenario: Get Product Valid Endpoint - As a admin i want to get train carriage with valid endpoint by id
    Given I have endpoint post new login for GTC
    When I send request to endpoint for GTC
    When user set GET valid endpoint for GTC
    When user send GET HTTP request with valid endpoint for GTC
    Then user received valid GET HTTP response code 200 for GTC

  @gettraincarriagebyidinvalidendpoint
  Scenario: Get Product Invalid Endpoint - As a admin i want to get train carriage with invalid endpoint by id
    Given I have endpoint post new login for GTC2
    When I send request to endpoint for GTC2
    When user set GET invalid endpoint for GTC
    When user send GET HTTP request with invalid endpoint for GTC
    Then user received invalid endpoint GET HTTP response code 200 for GTC
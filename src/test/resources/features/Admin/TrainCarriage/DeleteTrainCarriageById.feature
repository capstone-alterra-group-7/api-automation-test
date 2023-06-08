@deletetraincarriagebyid
Feature: As a user i want to delete train carriage by id
  As a admin
  I want to delete train carriage by id
  So that i can delete the train carriage

  @deletetraincarriagebyidvalid
  Scenario: Delete Product Valid Endpoint - As a admin i want to delete train carriage with valid endpoint by id
    Given I have endpoint post new login for DTC
    When I send request to endpoint for DTC
    When user set DELETE valid endpoint for DTC
    When user send DELETE HTTP request with valid endpoint for DTC
    Then user received valid DELETE HTTP response code 200 for DTC

  @deletetraincarriagebyidinvalidendpoint
  Scenario: Delete Product Valid Endpoint - As a admin i want to delete train carriage with invalid endpoint by id
    Given I have endpoint post new login for DTC2
    When I send request to endpoint for DTC2
    When user set DELETE invalid endpoint for DTC
    When user send DELETE HTTP request with invalid endpoint for DTC
    Then user received invalid endpoint DELETE HTTP response code 404 for DTC
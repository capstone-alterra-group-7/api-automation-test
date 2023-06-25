@deletehistorysearch
Feature: As a user i want to delete history search by id
  As a admin
  I want to delete history search by id
  So that i can delete the history search

  @deletehistorysearchbyidvalid
  Scenario: Delete Product Valid Endpoint - As a admin i want to delete history search with valid endpoint by id
    Given I have endpoint post new login for DHS
    When I send request to endpoint for DHS
    When user set DELETE valid endpoint for DHS
    When user send DELETE HTTP request with valid endpoint for DHS
    Then user received valid DELETE HTTP response code 200 for DHS
    Then user received data response for DHS

  @deletehistorysearchbyidinvalidendpoint
  Scenario: Delete Product Valid Endpoint - As a admin i want to delete history search with invalid endpoint by id
    Given I have endpoint post new login for DHS2
    When I send request to endpoint for DHS2
    When user set DELETE invalid endpoint for DHS
    When user send DELETE HTTP request with invalid endpoint for DHS
    Then user received invalid endpoint DELETE HTTP response code 404 for DHS
    Then user received data response for invalid endpoint DHS

  @deletehistorysearchbyidinvalidid
  Scenario: Delete Product Valid Endpoint - As a admin i want to delete history search with valid endpoint and invalid id
    Given I have endpoint post new login for DHS3
    When I send request to endpoint for DHS3
    When user set DELETE valid endpoint for invalid id DHS
    When user send DELETE HTTP request with valid endpoint for invalid id DHS
    Then user received valid endpoint DELETE HTTP response code 400 for invalid id DHS
    Then user received data response for invalid id DHS
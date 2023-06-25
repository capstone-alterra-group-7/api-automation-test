@getallhistorysearch
Feature: As a user i want to get all history search
  As a user
  I want to see list of history search
  So that i can see all result

  @Getallhistorysearchvalid
  Scenario: Get History Search with Valid Endpoint - As a admin i want to get all history search with valid endpoint
    Given I have endpoint post new login for get all history search
    When I send request to endpoint for get all history search
    When user set GET valid endpoint for get all history search
    When user send GET HTTP request with valid endpoint for get all history search
    Then user received valid GET HTTP response code 200 for get all history search
    Then user receive valid data response for get all history search

  @Getallhistorysearchinvalid
  Scenario: Get History Search with Invalid Endpoint - As a admin i want to get all history search with invalid endpoint
    Given I have endpoint post new login for get all history search2
    When I send request to endpoint for get all history search2
    When user set GET invalid endpoint for get all history search
    When user send GET HTTP request with valid endpoint for invalid get all history search
    Then user received valid GET HTTP response code 404 for invalid get all history search
    Then user receive valid data response for invalid get all history search
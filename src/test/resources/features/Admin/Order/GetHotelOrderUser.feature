@gethotelorderuser
Feature: As a admin i want to get hotel order user
  As a admin
  I want to see list of hotel order user
  So that i can see all result

  @gethotelorderuservalid
  Scenario: Get Hotel Order with Valid Endpoint - As a admin i want to get hotel order with valid endpoint
    Given I have endpoint post new login for get hotel order
    When I send request to endpoint for get hotel order
    When I set GET valid endpoint for get hotel order
    When I send GET HTTP request with valid endpoint for get hotel order
    Then I received valid GET HTTP response code 200 for get hotel order
    Then I receive valid data response for get hotel order

  @gethotelorderuserinvalidendpoint
  Scenario: Get Hotel Order with Invalid Endpoint - As a admin i want to get hotel order with invalid endpoint
    Given I have endpoint post new login for get hotel order2
    When I send request to endpoint for get hotel order2
    When I set GET invalid endpoint for get hotel order2
    When I send GET HTTP request with invalid endpoint for get hotel order2
    Then I received invalid GET HTTP response code 404 for get hotel order2
    Then I receive invalid data response for get hotel order2
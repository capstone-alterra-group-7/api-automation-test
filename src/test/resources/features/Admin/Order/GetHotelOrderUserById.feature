@gethotelorderuserbyid
Feature: As a admin i want to get hotel order user by id
  As a admin
  I want to see list of hotel order user by id
  So that i can see all result

  @gethotelorderuservalidById
  Scenario: Get Hotel Order with Valid Endpoint - As a admin i want to get hotel order with valid endpoint by id
    Given I have endpoint post new login for get hotel order ById
    When I send request to endpoint for get hotel order ById
    When I set GET valid endpoint for get hotel order ById
    When I send GET HTTP request with valid endpoint for get hotel order ById
    Then I received valid GET HTTP response code 200 for get hotel order ById
    Then I receive valid data response for get hotel order ById

  @gethotelorderuserinvalidendpointById
  Scenario: Get Hotel Order by id with Invalid Endpoint - As a admin i want to get hotel order with invalid endpoint by id
    Given I have endpoint post new login for get hotel order ById2
    When I send request to endpoint for get hotel order ById2
    When I set GET invalid endpoint for get hotel order ById2
    When I send GET HTTP request with invalid endpoint for get hotel order ById2
    Then I received invalid GET HTTP response code 404 for get hotel order ById2
    Then I receive invalid data response for get hotel order ById2
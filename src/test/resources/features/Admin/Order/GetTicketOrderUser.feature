@getticketorderuser
Feature: As a admin i want to Get Ticket Order user
  As a admin
  I want to see list of ticket order user
  So that i can see all result

  @getticketorderuservalid
  Scenario: Get Ticket Order with Valid Endpoint - As a admin i want to Get Ticket Order with valid endpoint
    Given I have endpoint post new login for Get Ticket Order
    When I send request to endpoint for Get Ticket Order
    When I set GET valid endpoint for Get Ticket Order
    When I send GET HTTP request with valid endpoint for Get Ticket Order
    Then I received valid GET HTTP response code 200 for Get Ticket Order
    Then I receive valid data response for Get Ticket Order

  @getticketorderuserinvalidendpoint
  Scenario: Get Ticket Order with Invalid Endpoint - As a admin i want to Get Ticket Order with invalid endpoint
    Given I have endpoint post new login for Get Ticket Order2
    When I send request to endpoint for Get Ticket Order2
    When I set GET invalid endpoint for Get Ticket Order2
    When I send GET HTTP request with invalid endpoint for Get Ticket Order2
    Then I received invalid GET HTTP response code 404 for Get Ticket Order2
    Then I receive invalid data response for Get Ticket Order2
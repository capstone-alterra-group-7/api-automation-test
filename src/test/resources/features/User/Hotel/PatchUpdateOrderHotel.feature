@updateuserhotelorder
Feature: As a user i want to update status order hotel
  As a user
  I want to update status order hotel
  So that i can see result of order hotel

  @updateuserhotelordervalid
  Scenario: update status order hotel with Valid Endpoint - As a user i want update status order hotel with valid endpoint
    Given Enter Endpoint Login Valid Endpoint PUOH
    When Enter Request Login Valid Endpoint PUOH
    When Enter Endpoint PUOH Valid Endpoint
    When Enter Request PUOH Valid Endpoint
    Then Receive 201 response PUOH Valid Endpoint
    Then Receive Data response PUOH Valid Endpoint

  @createaneworderhotelinvalid
  Scenario: Create A New order hotel with Invalid Endpoint - As a user i want to create a new order hotel with invalid endpoint
    Given Enter Endpoint Login PUOH2
    When Enter Request Login PUOH2
    When Enter Endpoint PUOH2
    When Enter Request PUOH2
    Then Receive 404 response PUOH2
    Then Receive Data response PUOH2

  @createaneworderhotelinvalidreq
  Scenario: Create A New order hotel with Invlid Request - As a user i want to create a new order hotel with invalid Request
    Given Enter Endpoint Login PUOH3
    When Enter Request Login PUOH3
    When Enter Endpoint PUOH3
    When Enter Request PUOH3
    Then Receive 404 response PUOH3
    Then Receive Data response PUOH3
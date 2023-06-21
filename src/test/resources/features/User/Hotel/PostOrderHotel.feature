@createaneworderhotel
Feature: As a user i want to create a order hotel
  As a user
  I want to create a new order hotel
  So that i can see result of order hotel

  @createaneworderhotelvalid
  Scenario: Create A New order hotel with Valid Endpoint - As a user i want to create a new order hotel with valid endpoint
    Given Enter Endpoint Login Valid Endpoint UOH
    When Enter Request Login Valid Endpoint UOH
    When Enter Endpoint UOH Valid Endpoint
    When Enter Request UOH Valid Endpoint
    Then Receive 201 response UOH Valid Endpoint
    Then Receive Data response UOH Valid Endpoint

  @createaneworderhotelinvalid
  Scenario: Create A New order hotel with Invalid Endpoint - As a user i want to create a new order hotel with invalid endpoint
    Given Enter Endpoint Login UOH2
    When Enter Request Login UOH2
    When Enter Endpoint UOH2
    When Enter Request UOH2
    Then Receive 404 response UOH2
    Then Receive Data response UOH2

  @createaneworderhotelinvalidreq
  Scenario: Create A New order hotel with Invlid Request - As a user i want to create a new order hotel with invalid Request
    Given Enter Endpoint Login UOH3
    When Enter Request Login UOH3
    When Enter Endpoint UOH3
    When Enter Request UOH3
    Then Receive 404 response UOH3
    Then Receive Data response UOH3
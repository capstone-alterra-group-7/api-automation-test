@createaneworderhotelmidtrans
Feature: As a user i want to create a order hotel midtrans
  As a user
  I want to create a new order hotel midtrans
  So that i can see result of order hotel midtrans

  @createaneworderhotelmidtransvalid
  Scenario: Create A New order hotel midtrans with Valid Endpoint - As a user i want to create a new order hotel midtrans with valid endpoint
    Given Enter Endpoint Login Valid Endpoint UOHMD
    When Enter Request Login Valid Endpoint UOHMD
    When Enter Endpoint UOHMD Valid Endpoint
    When Enter Request UOHMD Valid Endpoint
    Then Receive 201 response UOHMD Valid Endpoint
    Then Receive Data response UOHMD Valid Endpoint

  @createaneworderhotelmidtransinvalid
  Scenario: Create A New order hotel midtrans with Invalid Endpoint - As a user i want to create a new order hotel midtrans with invalid endpoint
    Given Enter Endpoint Login UOHMD2
    When Enter Request Login UOHMD2
    When Enter Endpoint UOHMD2
    When Enter Request UOHMD2
    Then Receive 404 response UOHMD2
    Then Receive Data response UOHMD2

  @createaneworderhotelmidtransinvalidreq
  Scenario: Create A New order hotel midtrans with Invlid Request - As a user i want to create a new order hotel midtrans with invalid Request
    Given Enter Endpoint Login UOHMD3
    When Enter Request Login UOHMD3
    When Enter Endpoint UOHMD3
    When Enter Request UOHMD3
    Then Receive 404 response UOHMD3
    Then Receive Data response UOHMD3
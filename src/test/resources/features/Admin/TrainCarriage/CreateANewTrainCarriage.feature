@createanewtraincarriage
Feature: As a admin i want to create a new train carriage
  As a admin
  I want to create a new train carriage
  So that i can see result of train carriage

  @createanewtraincarriagevalid
  Scenario: Create A New Train Carriage with Valid Endpoint - As a user i want to create a new train carriage with valid endpoint
    Given Enter Endpoint Login Valid Endpoint TC
    When Enter Request Login Valid Endpoint TC
    When Enter Endpoint TC Valid Endpoint
    When Enter Request TC Valid Endpoint
    Then Receive 201 response Valid Endpoint

  @createanewtraincarriageinvalid
  Scenario: Create A New Train Carriage with Invalid Endpoint - As a user i want to create a new train carriage with valid endpoint
    Given Enter Endpoint Login Valid Endpoint TC2
    When Enter Request Login Valid Endpoint TC2
    When Enter Endpoint TC Invalid Endpoint
    When Enter Request TC Invalid Endpoint
    Then Receive 404 response Invalid Endpoint

  @createanewtraincarriageinvalidrequest
  Scenario: Create A New Train Carriage with Valid Endpoint and Invalid Request - As a user i want to create a new train carriage with valid endpoint and invalid request
    Given Enter Endpoint Login Valid Endpoint TC3
    When Enter Request Login Valid Endpoint TC3
    When Enter Endpoint TC Valid Endpoint for invalid request
    When Enter Request TC Valid Endpoint for invalid request
    Then Receive 400 response Invalid Endpoint for invalid request
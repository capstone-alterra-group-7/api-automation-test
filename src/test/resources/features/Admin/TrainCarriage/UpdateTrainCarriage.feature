@updatetraincarriage
Feature: As a admin i want to update train carriage
  As a admin
  I want to update train carriage
  So that i can see result of train carriage

  @updatetraincarriagevalid
  Scenario: Update Train Carriage with Valid Endpoint - As a user i want to update Train carriage with valid endpoint
    Given Enter Endpoint Login Valid Endpoint UTC
    When Enter Request Login Valid Endpoint UTC
    When Enter Endpoint UTC Valid Endpoint
    When Enter Request UTC Valid Endpoint
    Then Receive 200 UTC response Valid Endpoint

  @updatetraincarriageinvalidendpoint
  Scenario: Update Train Carriage with Valid Endpoint - As a user i want to update Train carriage with invalid endpoint
    Given Enter Endpoint Login Valid Endpoint UTC2
    When Enter Request Login Valid Endpoint UTC2
    When Enter Endpoint UTC Invalid Endpoint
    When Enter Request UTC Invalid Endpoint
    Then Receive 404 UTC response Invalid Endpoint

  @updatetraincarriageinvalidrequest
  Scenario: Update Train Carriage with Valid Endpoint - As a user i want to update Train carriage with invalid request
    Given Enter Endpoint Login Valid Endpoint UTC3
    When Enter Request Login Valid Endpoint UTC3
    When Enter Endpoint UTC Valid Endpoint for invalid request
    When Enter Request UTC Valid Endpoint for invalid request
    Then Receive 400 UTC response Valid Endpoint for invalid request
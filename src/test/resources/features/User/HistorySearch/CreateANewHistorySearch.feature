@createanewhistorysearch
Feature: As a user i want to create a history search
  As a user
  I want to create a new history search
  So that i can see result of history search

  @createanewhistorysearchvalid
  Scenario: Create A New history search with Valid Endpoint - As a user i want to create a new history search with valid endpoint
    Given Enter Endpoint Login Valid Endpoint CHS
    When Enter Request Login Valid Endpoint CHS
    When Enter Endpoint CHS Valid Endpoint
    When Enter Request CHS Valid Endpoint
    Then Receive 201 response CHS Valid Endpoint
    Then Receive Data response CHS Valid Endpoint
#
  @createanewhistorysearchinvalid
  Scenario: Create A New history search with Invalid Endpoint - As a user i want to create a new history search with invalid endpoint
    Given Enter Endpoint Login Valid Endpoint CHS2
    When Enter Request Login Valid Endpoint CHS2
    When Enter Endpoint CHS Invalid Endpoint
    When Enter Request CHS Invalid Endpoint
    Then Receive 404 response CHS Invalid Endpoint
    Then Receive Data response CHS Invalid Endpoint
#
  @createanewhistorysearchinvalidrequest
  Scenario: Create A New history search with Valid Endpoint and Invalid Request - As a user i want to create a new history search with valid endpoint and invalid request
    Given Enter Endpoint Login Valid Endpoint CHS3
    When Enter Request Login Valid Endpoint CHS3
    When Enter Endpoint CHS Invalid Request
    When Enter Request CHS Invalid Request
    Then Receive 400 response CHS Invalid Request
    Then Receive Data response CHS Invalid Request
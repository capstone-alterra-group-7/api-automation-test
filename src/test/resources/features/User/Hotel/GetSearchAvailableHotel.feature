@getsearchavailablehotel
Feature: As a user i want to update status order hotel
  As a user
  I want to search available hotel
  So that i can see result of available hotel

  @getsearchavailablehotelvalid
  Scenario: search available hotel with Valid Endpoint - As a user i want search available hotel with valid endpoint
    Given Enter Endpoint Login Valid Endpoint SHA
    When Enter Request Login Valid Endpoint SHA
    When Enter Endpoint SHA Valid Endpoint
    When Enter Request SHA Valid Endpoint
    Then Receive 201 response SHA Valid Endpoint
    Then Receive Data response SHA Valid Endpoint


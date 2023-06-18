Feature: Get hotel order user

  @GethotelOrderUser-1
  Scenario: as a user i want to get hotel order user
    Given input endpoint Login Valid Endpoint get hotel order user
    When input  request Login Valid Endpoint get hotel order user
    When user on the get hotel order user endpoint
    When user create request with GET method endpoint
    Then get status code 200 OKE
    And get valid data hotel order user
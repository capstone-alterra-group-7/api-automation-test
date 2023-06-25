Feature: Get Train By id

  @GeTrainByID-1
  Scenario: as a user i want to get data train By ID
    Given input Endpoint Login Valid Endpoint get Train By ID
    When input  Request Login Valid Endpoint get Train By ID
    When user on the get Train By ID endpoint
    When user create request with GET method on endpoint get Train By ID
    Then get status code 200 OK
    And get valid data Train By ID
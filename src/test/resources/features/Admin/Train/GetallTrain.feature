Feature: Get all Train

  @GetAllTrain-1
  Scenario: as a user i want to get all data train
    Given input Endpoint Login Valid Endpoint get all Train
    When input  Request Login Valid Endpoint get all Train
    When user on the get all train endpoint
    When user create request with GET method on endpoint
    Then get status code 200 ok
    And get valid data train
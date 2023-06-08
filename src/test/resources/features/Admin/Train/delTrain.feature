Feature: Delete Train

  @Del-ValidEndpoint
  Scenario: as a user i want to delete train by id
    Given Enter Endpoint Login Valid Endpoint Train
    When Enter Request Login Valid Endpoint Train
    When user on the delete train endpoint with id 16
    When user create request with DEL method on endpoint
    When get status code 200
    Then get valid data

Feature: PUT TRAIN

  @Puttrain1
  Scenario: as a user i want to update data train
    Given user on Endpoint Login Valid Endpoint Train
    When user Request Login Valid Endpoint Train
    When user send update request with PUT method on endpoint
    When user on the update train endpoint
    When user update request with PUT method on endpoint
    Then system responds with the status code 200
Feature: Train

  @train1
  Scenario: Create New Train
  Given Enter Endpoint Login Valid Endpoint Train
  When Enter Request Login Valid Endpoint Train
  When user on the create new train endpoint
  When user create request with POST method on endpoint
  Then the system responds with the status code 201 OK

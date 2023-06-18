Feature: Get tiket order user

  @GetTiketorder-1
  Scenario: as a user i want to get tiket order user
    Given input endpoint Login Valid Endpoint get tiket order user
    When input  request Login Valid Endpoint get tiket order user
    When user on the get tiket order user user endpoint
    When user create request with GET method Endpoint
    Then get status code 200 OKK
    And get valid data tiket order user

  @GetTiketorder-TCN2
  Scenario: as a user i want to get tiket order user with invalid token
    Given input endpoint Login Valid Endpoint get tiket order user
    When input  request Login Valid Endpoint get tiket order user
    When user on the get tiket order user endpoint with  invalid token
    When user create request with GET Endpoint tiket order using  invalid token
    Then user get status code 401 unautorizedd
    And get message token signature is invalid:
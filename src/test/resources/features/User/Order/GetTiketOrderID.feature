Feature: Get tiket order user by id

  @GetTiketorderID-1
  Scenario: as a user i want to get tiket order user by id
    Given input endpoint Login Valid Endpoint get tiket order user by id
    When input  request Login Valid Endpoint get tiket order user by id
    When user on the get tiket order user by id endpoint
    When user create request with GET Endpoint
    Then user get status code 200 OK
    And get valid data tiket order user by id

  @GetTiketorderID-TCN1
  Scenario: as a user i want to get tiket order user by id with invalid id
    Given input endpoint Login Valid Endpoint get tiket order user by id
    When input  request Login Valid Endpoint get tiket order user by id
    When user on the get tiket order user by id endpoint with invalid id
    When user create request with GET Endpoint tiket order by id
    Then user get status code 404 not found
    And get get message Failed to get a ticket order

  @GetTiketorderID-TCN2
  Scenario: as a user i want to get tiket order user by id with invalid token
    Given input endpoint Login Valid Endpoint get tiket order user by id
    When input  request Login Valid Endpoint get tiket order user by id
    When user on the get tiket order user by id endpoint with  invalid token
    When user create request with GET Endpoint tiket order by id using  invalid token
    Then user get status code 401 unautorized
    And get get message token signature is invalid
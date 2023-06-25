Feature: Get hotel order user by id

  @GethotelOrderUserbyId-1
  Scenario: as a user i want to get hotel order user by id
    Given input endpoint Login Valid Endpoint get hotel order user by id
    When input  request Login Valid Endpoint get hotel order user by id
    When user on the get hotel order by id user endpoint
    When user create request with GET method valid endpoint
    Then get status code 200 Okk
    And get valid data hotel order user by id

  @GetHotelorderID-TCN2
  Scenario: as a user i want to get hotel order user by id with invalid token
    Given input endpoint Login Valid Endpoint get tiket order user by id
    When input  request Login Valid Endpoint get tiket order user by id
    When user on the get hotel order user by id endpoint with  invalid token
    When user create request with GET Endpoint hotel order by id using  invalid token
    Then get status code 401 unautorized
    And user get message token signature is invalid
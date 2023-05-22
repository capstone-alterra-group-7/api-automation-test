Feature: As a user i want to create new user login

  @PostLogin-ValidEndpoint
  Scenario: as user i want to input valid endpoint for create new user login
    Given user has endpoint post new user login
    When user send request for create new user login
    Then login user get status code 200
    And I receive valid data for new login

  @PostLogin-InvalidEndpoint
  Scenario: as user i want to input invalid endpoint for create new user login
    Given user has invalid endpoint post new user login
    When user send request to invalid endpoint for create new user login
    Then user get error status code 404

  @PostLogin-InvalidRequest
  Scenario: as user i want to input valid endpoint for create new user login
    Given user has valid endpoint post new user login
    When user send invalid request to for create new user login
    Then user see error status code 400
    And I receive valid response message
Feature: As a user i want to update profile with method put

  @UpdateProfile
  Scenario: as user i want to input valid endpoint so that i can update profile
    Given user set endpoint login user
    When user send request to endpoint login user
    When user set endpoint to update profile
    And user send request for update profile
    Then user can update profile with status code 200
    And user see valid data with message response
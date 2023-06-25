Feature: As a user i want to update photo profile with method put

  @UpdatePhotoProfile
  Scenario: as user i want to input valid endpoint so that i can update photo profile
    Given user set endpoint login user for update photo
    When user send request to endpoint login user for update photo
    When user set endpoint to update photo profile
    And user send request for update photo profile
    Then user can update photo profile with status code 200
    And user see valid data photo profile with message response
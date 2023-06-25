Feature: As a user i want to create new hotel rating

  @CreateNewHotelRating
  Scenario: as user i want to create new hotel rating
    Given user set valid endpoint for login user
    When user send request to auth user
    When user set endpoint for create a new hotel rating
    And user send request for create a new hotel rating
    Then user success create new hotel rating and see status code 201
    And i validate data hotel rating
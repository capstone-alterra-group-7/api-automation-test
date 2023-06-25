Feature: As a user i want to get notification

  @GetNotification
  Scenario: as user i want to input valid endpoint and i can success get notification
    Given user has valid endpoint for login
    When user send request for for login
    And user set endpoint for get notification
    And user send request for get notification
    Then user get notification with status code 200
    And i receive valid data notification with message response
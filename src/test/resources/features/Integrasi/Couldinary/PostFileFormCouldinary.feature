Feature: As a user i want to post new image to couldinary with url image

  @PostCouldinary
  Scenario: as user i want to input valid endpoint so that i can create a new image to couldinary
    Given user set valid endpoint for create new image to couldinary
    When user send request url image from couldinary
    Then user can see image data from cloundinary with status code 200
    And i validate data image with message response
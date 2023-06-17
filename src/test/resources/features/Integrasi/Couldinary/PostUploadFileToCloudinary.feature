Feature: As a user i want to post new image to cloudinary with url image

  @UploadFileImageToCloudinary
  Scenario: as user i want to input valid endpoint so that i can create a new image to cloudinary
    Given user set valid endpoint for create new image to cloudinary
    When user send request with upload image from cloudinary
    Then user can see image data from cloudinary with status code 200
    And i validate new image with message response
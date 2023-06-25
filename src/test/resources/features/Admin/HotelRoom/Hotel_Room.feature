Feature: as admin want to can have all information about Hotel Room

  @HotelRoom-Get
  Scenario: as an admin I can get information hotel Room schedules that have been ordered
    Given I set hotel room API api endpoints
    When I request to endpoint for Get All Hotel room
    And user set GET Hotel room valid endpoints
    And user send GET Hotel room HTTP request with valid endpoint
    Then I receive valid HTTP Get Hotel room response code 200

  @HotelRoom-Get-Invalid
  Scenario: as an admin I can get information hotel Room schedules that have been ordered but invalid
    Given I set hotel room API invalid endpoints
    When I request to endpoint for Get All Hotel room invalid
    And user set GET Hotel room invalid endpoints
    And user send GET invalid Hotel room HTTP  request with valid endpoint
    Then I receive valid HTTP Get invalid Hotel room response code 400

    @GetById-HR
    Scenario: I as admin can cek user hotel room by Id
      Given I have endpoint post new login for Id Hotel room
      When I send request to endpoint for Id Hotel room
      And user set GET valid endpoint for Id Hotel room
      And user send GET HTTP request with valid endpoint for Id Hotel room
      Then user received valid Get By Id hr HTTP response code 200


  @GetById-HR-Invalid
  Scenario: I as admin can cek user by Id Invalid hotel room
    Given I have endpoint post new login for Id Invalid Hotel room
    When I send request to endpoint for Id Invalid Hotel room
    And user set GET valid endpoint for Id Invalid Hotel room
    And user send GET HTTP request with invalid endpoint for Id Hotel room
    Then user received invalid Get By Id hr HTTP response code 400

  @CreateNewHotelRoom-Post
  Scenario: Create A New hotel  with Valid Endpoint
    Given Enter Endpoint Login Valid Endpoint New hotel room
    When Enter Request Login Valid Endpoint New hotel room
    And Enter Endpoint New Hotel room Valid Endpoint
    And Enter Request New Hotel room Valid Endpoint
    Then Receive Valid Http Create New Hotel room response code 201


  @Put-UpdateHotelRoom
  Scenario: As a admin want to update hotel room
    Given Enter Endpoint Login Valid Endpoint update hotel room
    When Enter Request Login Valid Endpoint update hotel room
    And Enter Endpoint update hotel room Valid Endpoint
    And Enter Request update hotel room Valid Endpoint
    Then Receive response code Update hotel room 200


  @Delete-HotelRoom
  Scenario: As a admin want to delete hotel room
    Given I have endpoint post new login for delete hotel room
    When I send request to endpoint for delete hotel room
    When user set DELETE valid endpoint for delete hotel room
    When user send DELETE hotel room HTTP request with valid endpoint
    Then user received valid DELETE hotel room HTTP response code 200
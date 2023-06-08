Feature: as admin I am responsible for the station

  @GetAllStation-1
  Scenario: as an admin I can get information on train schedules that have been ordered
    Given I set GET api endpoints
    When I request to endpoint for Get All Train
    And user set GET valid endpoints
    And user send GET HTTP request with valid endpoint
    Then I receive valid HTTP response code 200

    @GetById-2
    Scenario: as admin I can check user data using id
      Given Admin set get api endpoints
      When admin request to endpoint for Get By Id
      And admin set GET valid endpoints
      And admin send GET HTTP request with valid endpoint
      Then admin receive valid HTTP response code 200

      @CreateANewStation-Post3
      Scenario: as admin can create a new station
        Given Admin want to set post api endpoints
        When admin request to endpoint for Create A New Station
        And Admin create a new station
        And admin set POST valid endpoints
        And admin send POST HTTP request with valid endpoint
        Then admin receive valid POST response code 201

        @Put-UpdateStation-4
        Scenario: admin can update information station
          Given Admin want to set put api endpoints
          When admin request to endpoint for Update Station
          And Admin update station
          And admin set put valid endpoints
          And admin send put HTTP request with valid endpoint
          Then admin receive valid put response code 200

          @5-DeleteStation
          Scenario: admin can delete information station
            Given Admin want to set delete api endpoints
            When admin request to endpoint for delete Station
            And Admin delete station
            And admin set delete valid endpoints
            Then admin receive valid delete response code 200
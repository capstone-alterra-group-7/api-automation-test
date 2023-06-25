Feature: as a admin want to get all information for hotel

  @Get-HotelALL
  Scenario: as an admin I can get information hotel schedules that have been ordered
    Given I set Hotel API api endpoints
    When I request to endpoint for Get All Hotel
    And user set GET Hotel valid endpoints
    And user send GET Hotel HTTP request with valid endpoint
    Then I receive valid HTTP Get Hotel response code 200

    @Invalid-GethotelAll
    Scenario: as an admin I can get information hotel schedules that have been ordered
      Given I set Hotel API invalid endpoints
      When I request to invalid endpoint for Get All Hotel
      And user set GET Hotel invalid endpoints
      And user send GET Hotel HTTP request with invalid endpoint
      Then I receive invalid HTTP Get Hotel response code 404


    @CreateNewHotel-Post
    Scenario: Create A New hotel  with Valid Endpoint
      Given Enter Endpoint Login Valid Endpoint New Hotel
      When Enter Request Login Valid Endpoint New Hotel
      And Enter Endpoint New Hotel Valid Endpoint
      And Enter Request New Hotel Valid Endpoint
      Then Receive Valid Http Create New Hotel response code 201


      @GetById-Hotel
      Scenario: I as admin can cek user hotel by Id
      Given I have endpoint post new login for Id Hotel
      When I send request to endpoint for Id Hotel
      And user set GET valid endpoint for Id Hotel
      And user send GET HTTP request with valid endpoint for Id Hotel
      Then user received valid Get By Id HTTP response code 200

        @GetByIdHotel-Invalid
        Scenario: I as admin can cek invalid user hotel by Id
          Given I have endpoint post new login for invalid Id Hotel
          When I send request to endpoint for invalid Id Hotel
          And user set GET invalid endpoint for Id Hotel
          And user send GET HTTP request with invalid endpoint for Id Hotel
          Then user received invalid Get By Id HTTP response code 404

          @Put-UpdateHotel
          Scenario: As a admin want to update hotel
            Given Enter Endpoint Login Valid Endpoint update hotel
            When Enter Request Login Valid Endpoint update hotel
            And Enter Endpoint update hotel Valid Endpoint
            And Enter Request update hotel Valid Endpoint
            Then Receive response code Update hotel 200

            @Delete-Hotel
            Scenario: As a admin want to delete hotel
              Given I have endpoint post new login for delete hotel
              When I send request to endpoint for delete hotel
              When user set DELETE valid endpoint for delete hotel
              When user send DELETE hotel HTTP request with valid endpoint
              Then user received valid DELETE hotel HTTP response code 200

              @DeleteHotel-Invalid
              Scenario: As a admin want to invalid delete hotel
                Given I have invalid endpoint post new login for delete hotel
                When I send request to endpoint invalid for delete hotel
                When user set DELETE invalid endpoint for delete hotel
                When user send DELETE hotel HTTP request with invalid endpoint
                Then user received invalid DELETE hotel HTTP response code 400
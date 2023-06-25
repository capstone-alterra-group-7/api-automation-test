Feature: As Admin Train i want to can have any information about train

  @Post-Article-1
  Scenario: As admin i want to put article station
    Given Admin set put api article endpoints
    When admin request to endpoint for Update Article
    And Admin update Article
    And admin set put valid endpoints article
    And admin send put HTTP request with valid endpoint article
    Then admin receive valid put article response code 201
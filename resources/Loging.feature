Feature: Log in

  Scenario: User can log in
    Given User is on login page
    When User inserts username
    And User inserts password
    And User clicks on Login
    Then User is logged in
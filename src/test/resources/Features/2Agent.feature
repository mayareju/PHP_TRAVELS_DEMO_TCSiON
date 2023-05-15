Feature: Agent FrontEnd Link Functionality

  Background: 
    Given User Launch Chrome browser
    When user open url "https://phptravels.net/login"
    And User enters Email as "agent@phptravels.com" and password as "demoagent"
    And click Login button
    Then Page title should be "Dashboard - PHPTRAVELS"

  Scenario: Agent Test SideLink Functionality
    When user click on Agent My booking Link
    Then Page title should be "Bookings - PHPTRAVELS"
    When user click on Agent Add_funds Link
    Then Page title should be "Add Funds - PHPTRAVELS"
    When agent click on My Profile Link
    Then Page title should be "Profile - PHPTRAVELS"
    And user click on Logout
    Then Page title should be "Login - PHPTRAVELS"

  Scenario: Agent Test HeaderLink Functionality
    When user click on Hotels Link
    Then Page title should be "Search Hotels - PHPTRAVELS"
    When user click on Flights Link
    Then Page title should be "Search flights - PHPTRAVELS"
    And user click on Visa Link
    Then Page title should be "Submit Visa - PHPTRAVELS"
    When user click on Tours Link
    Then Page title should be "Search Tours - PHPTRAVELS"
    And user click on Blog Link
    Then Page title should be "Blog - PHPTRAVELS"
    And user click on Offers Link
    Then Page title should be "Offers - PHPTRAVELS"
    When user click on Home Logo
    Then Page title should be "PHPTRAVELS | Travel Technology Partner - PHPTRAVELS"

  Scenario: Agent Search Hotels by City
    When user click on Hotels Link
    Then Page title should be "Search Hotels - PHPTRAVELS"
    When user can enter "Sin" on city name field
    And click on search button
    Then Page title should be "Hotels in sindal - PHPTRAVELS"

  Scenario: Agent Update USD to INR
    When user click on USD dropdown menu
    And user can select INR from dropdowm menu
    Then navigate to home page and user can view INR instead of USD

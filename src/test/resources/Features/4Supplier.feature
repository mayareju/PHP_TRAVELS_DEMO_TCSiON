Feature: Supplier BackEnd Link Functionality

  Background: 
    Given User Launch Chrome browser
    When supplier open url "https://phptravels.net/api/supplier"
    And supplier enters Email as "supplier@phptravels.com" and password as "demosupplier"
    And supplier click Login button
    Then Page title should be "Dashboard"

  Scenario: Supplier verify the dashboard view and check the text
    When supplier enters dashboard and can view Sales Overview and summary text
    Then supplier can verify the summary text on dashboard

  Scenario: Supplier test the dashboard displays the Revenue breakdown
    When supplier enters dashboard can view Revenue breakdown text
    Then supplier can verify the revenue text on dashboard

  Scenario: Supplier Change the booking status and verify the count in Dashboard
    When supplier enters dashboard verify the count before changing the booking status
    And supplier click on pending button on dashboard
    Then Page title should be "Pending Bookings View"
    And supplier click on booking status pending dropdown and change to confirmed
    Then the count after change the status in dashbord is verified by supplier

  Scenario: Supplier Verify the Functionality of Flight Link
    When supplier click on flight link
    Then Page title should be "Flight Management"

  Scenario: Supplier Verify the Functionality of Visa Link
    When supplier click on Visa link
    Then Page title should be "Visa Management"

  Scenario: Supplier Verify the Functionality of Tours Link
    When supplier click on Tours link
    Then Page title should be "Tours Management"

  Scenario: Supplier Verify the Functionality of Bookings Link
    When supplier click on Bookings link
    Then Page title should be "All Bookings View"

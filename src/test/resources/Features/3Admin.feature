Feature: Admin BackEnd Link Functionality

  Background: 
    Given User Launch Chrome browser
    When user open url "https://phptravels.net/admin"
    And admin enters Email as "admin@phptravels.com" and password as "demoadmin"
    And admin click Login button
    Then Page title should be "Dashboard"

  Scenario: Admin test the Booking link and display the invoice where payment is successful
    When admin click on Bookings Link
    Then Page title should be "All Bookings View"
    And admin click on paid booking link
    Then Page title should be "paid Bookings View"
    When user click on invoice button
    Then Page title should be "Hotel Invoice - PHPTRAVELS"
    Then user can check the payment status is paid

  Scenario: Admin Delete Booking where booking status as cancelled
    When admin click on Cancelled booking Link
    Then Page title should be "cancelled Bookings View"
    When user click on delete button and invoice should be deleted after accepting alert message

  Scenario: Admin Change Booking status and verify the count in dashboard
    When admin click on Pending booking Link on dashboard
    Then Page title should be "Pending Bookings View"
    And the count before change the status is verified by admin
    And admin click on booking status pending dropdown and change to confirmed
    Then the count after change the status in dashbord is verified by admin

  Scenario: Admin check Website link functionality
    When admin click on Website link
    Then Page title should be "PHPTRAVELS | Travel Technology Partner - PHPTRAVELS"

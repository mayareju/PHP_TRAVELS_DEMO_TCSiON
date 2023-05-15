Feature: Customer FrontEnd Link Functionality

  Background: 
    Given User Launch Chrome browser
    When user open url "https://phptravels.net/login"
    And User enters Email as "user@phptravels.com" and password as "demouser"
    And click Login button
    Then Page title should be "Dashboard - PHPTRAVELS"

  Scenario: Customer Test the Link functionality
    When user click on My Booking link
    Then Page title should be "Bookings - PHPTRAVELS"
    And user click on Add_Funds link
    Then Page title should be "Add Funds - PHPTRAVELS"
    When user click on My Profile link
    Then Page title should be "Profile - PHPTRAVELS"
    And user click on Logout link
    Then Page title should be "Login - PHPTRAVELS"

  Scenario: Customer make an automated payment of USD Fifty using Paypal
    When user click on Add_Funds link
    Then Page title should be "Add Funds - PHPTRAVELS"
    And user can select radio button as pay with paypal
    When user click on paynow button for payment
    Then page for paypal payment url should contain "paypal"

  Scenario: Customer check Bookings and Display the Voucher
    When user click on My Booking link
    Then Page title should be "Bookings - PHPTRAVELS"
    And user can check the bookings
    When user can click on view voucher button
    Then download button for voucher is Enable

  Scenario: Customer update the Profile
    When user can click on My Profile button
    Then navigate to profile page
    And user can edit the Address as "Trivandrum, Kerala, India"
    Then user read the message as Profile updated successfully.

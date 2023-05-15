Feature: Login Functionality

  Scenario Outline: Customer Front End Login functionality
    Given User Launch Chrome browser
    When user open url "https://phptravels.net/login"
    And users enters Email as "<email>" and password as "<password>"
    And click Login button
    Then user Page url should contain "dashboard"

    Examples: 
      | email                | password    |
      | user1@phptravels.com | demouser    |
      | user@phptravels.com  | demouser123 |
      | user@phptravelscom   | demouser123 |
      |                      | demouser    |
      | user@phptravels.com  |             |
      |                      |             |
      | user@phptravels.com  | demouser    |

  Scenario Outline: Agent Front End Login functionality
    Given User Launch Chrome browser
    When user open url "https://phptravels.net/login"
    And users enters Email as "<email>" and password as "<password>"
    And click Login button
    Then user Page url should contain "dashboard"

    Examples: 
      | email                 | password     |
      | agent1@phptravels.com | demoagent    |
      | agent@phptravels.com  | demoagent123 |
      | agent@phptravelscom   | demoagent123 |
      |                       | demoagent    |
      | agent@phptravels.com  |              |
      |                       |              |
      | agent@phptravels.com  | demoagent    |

  Scenario Outline: Admin Back End Login functionality
    Given User Launch Chrome browser
    When admin open url "https://phptravels.net/admin"
    And admin enters Email as "<email>" and password as "<password>"
    And admin click Login button
    Then admin Page title should contain "Dashboard"

    Examples: 
      | email                 | password     |
      | admin1@phptravels.com | demoadmin    |
      | admin@phptravels.com  | demoadmin123 |
      | admin@php.com         | demoadmin123 |
      |                       | demoadmin    |
      | admin@phptravels.com  |              |
      |                       |              |
      | admin@phptravels.com  | demoadmin    |

  Scenario Outline: Supplier Back End Login functionality
    Given User Launch Chrome browser
    When supplier open url "https://phptravels.net/api/supplier"
    And supplier enters Email as "<email>" and password as "<password>"
    And admin click Login button
    Then supplier Page title should contain "Dashboard"

    Examples: 
      | email                     | password        |
      | supplier11@phptravels.com | demosupplier    |
      | supplier@phptravels.com   | demosupplier123 |
      | supplierphptravels.com    | demosupplier123 |
      |                           | demosupplier    |
      | supplier@phptravels.com   |                 |
      |                           |                 |
      | supplier@phptravels.com   | demosupplier    |

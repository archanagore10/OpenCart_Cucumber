@E2E
Feature: login functionality

  Background: 
    Given user is on Home page
    And user clicks on Login after navigating to My Account menu

  @Regression
  Scenario Outline: Successful login with valid credentials
    And user enters "<email>" and "<password>"
    And click on login button
    Then user navigates to My Account page

    @one
    Examples: 
      | email              | password  |
      | admin123@gmail.com | admin@123 |

  @Regression
  Scenario Outline: login with invalid credentials
    And user enters "<email>" and "<password>"
    And click on login button
    Then user should not navigate to My Account page

    Examples: 
      | email           | password  |
      | admin@gmail.com | admin@123 |

  #| archanagore@gmail.com | test@123  |
  #  @dataDriven
  Scenario Outline: Successful login with valid credentials
    And user enters email and password from excel "<sheetname>" and <rownumber>
    And click on login button
    Then user navigates to My Account page

    Examples: 
      | sheetname | rownumber |
      | Sheet1    |         0 |

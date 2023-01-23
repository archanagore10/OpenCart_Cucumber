Feature: login with valid credentials

  Scenario: Successful login with valid credentials
    Given user launch browser
    And opens URL "http://localhost/opencart/upload/index.php"
    When user clicks on Login after navigating to My Account menu    
    And user enters email as "archanagore@gmail.com" and password as "admin@123"
    And click on login button
    Then user navigates to My Account page
 
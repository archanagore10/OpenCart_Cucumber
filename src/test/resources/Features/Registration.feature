Feature: Application Registration

  @register
  Scenario: Registration using data table
    Given user is on Home page
    When user clicks on rgister after navigationg to My Account menu
    And user enters following user details
      | Archana | Gore | archana_gore@gmail.com | 1234567819 | admin@123 | admin@123 |
    #   | Linda   | margose | linda@gmail.com        | 2345617816 | test@123  | test@123  |
    And user accepts privacy policy
    And clicks on continue button
    Then Registration should be successful

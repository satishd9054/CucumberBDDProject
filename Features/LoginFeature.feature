Feature: Login

@sanity
Scenario: Successful Login with Valid Credentials
    Given User launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    And close browser
    
#    @sanity
#    Scenario Outline: Successful Login with Valid Credentials DDT
#    Given User launch Chrome browser
#    When User opens URL "https://admin-demo.nopcommerce.com/login"
#    And User enters Email as "<email>" and Password as "<password>"
#    And Click on Login
#    Then Page Title should be "Dashboard / nopCommerce administration"
#    When User click on Log out link
#    And close browser
#    
#    Examples:
#    |email|password|
#    |admin@yourstore.com|admin|
#    |test@yourstore.com|admin|
    
    
    
    
    
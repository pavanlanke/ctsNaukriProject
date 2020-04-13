@invalidLogin
Feature: Test Naukri with invalid credentials Login

  Scenario Outline: Test login with invalid credentials
    Given Open chrome and start application
    When closing popUps and click login
    When I enter Invalid <usernameNumber>
    When user should not able to login
    When taking screenshot
    Then application should be closed

    Examples: 
      | usernameNumber |
      |              3 |

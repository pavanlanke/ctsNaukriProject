@validLogin
Feature: Test Naukri valid credentials Login

  Scenario Outline: Test login with valid credentials
    Given Open chrome and start application
    When closing popUps and click login
    When I enter valid <usernameNumber>
    When user should be able to login
    When user should be able to log out
    Then application should be closed

    Examples: 
      | usernameNumber |
      |              1 |
      |              2 |
  
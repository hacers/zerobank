@login
Feature: Login Page
  Background:
    Given the user is on the login page

  @valid
  Scenario Outline: Login with valid information
    When the user enter the valid "<username>" and "<password>"
    Then the user should be able to login
    And  the title contains
      | Zero - Account Summary |
    Examples:
      | username | password    |
      | username | password |

  @invalid
  Scenario Outline: Login with invalid information
    When the user enter the invalid "<username>" and "<password>"
    Then the user should not be able to login
    And  the title contains
      | Zero - Log in |
    And the error message is displayed
      | Login and/or password are wrong. |
    Examples:
      | username | password    |
      | password | UserUser123 |
      |          |             |
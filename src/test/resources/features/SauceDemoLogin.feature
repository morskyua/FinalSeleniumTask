Feature: Login

  Background: Open SauceDemo login page
    Given I open "sauceDemoURL" page

  Scenario: Login with empty inputs
    Given I enter username "DemoLogin" and password "DemoPassword"
    When I clear the username and password inputs
    And I click login button
    Then I see an error message "Username is required"

  Scenario: Login with empty password
    Given I enter username "DemoLogin" and password "DemoPassword"
    When I clear the password input
    And I click login button
    Then I see an error message "Password is required"

  Scenario Outline: Login with valid inputs
    When I enter username "<login>" and password "<password>"
    And I click login button
    Then I see title "Swag Labs" on the dashboard
    Examples:
      | login                   | password     |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |
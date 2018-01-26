Feature: Login to Demo site

  Background:
    Given Switch to Storefront shopper.

#  Scenario: Possibility to login with username and password credentials
#    Given Opened Start page.
#    When Click on Sign in button.
#    And Login to Storefront.
#    Then Check that Home page is opened.

  Scenario: Possibility to login with username and password credentials
    Given Opened Start page.
    When Click on Sign in button.
    And Login to Storefront.
    Then Check that Home page is opened.

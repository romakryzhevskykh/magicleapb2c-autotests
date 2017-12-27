Feature: Login to Demo site

  Scenario:Check that shopper have possibility to log in to Storefront and first of all see home page
    Given Switch to Storefront shopper.
    Given Opened Start page.
    When Click on Sign in button.
    And Login to Storefront.
    Then Check that Home page is opened.

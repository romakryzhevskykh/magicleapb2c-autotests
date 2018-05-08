Feature: Login to Dev site

  Scenario:Check that shopper have possibility to log in to Storefront and first of all see home page
    Given Switch to Storefront shopper.
    Given Opened Start page.
    When Login to Storefront.
    Then Check that Home page is opened.

Feature: User must be able to view minicart sidebar on selection of the cart icon in the header

  Background:
  Given Switch to Storefront shopper.

    Scenario: Check that logged in user can see Mini Cart sidebar upon click on cart icon
      Given Opened Start page.
      When Login to Storefront.
      And Click on Shopping Cart icon.
      Then Check that Mini Cart sidebar exposed.

    Scenario: Check that Mini Cart header is "Shopping Cart"
      Given Mini Cart sidebar opened.
      Then Check that Mini Cart header equals to "Shopping Cart".

    Scenario: Check that Mini Cart contains "View Cart" button
      Given Mini Cart sidebar opened.
      Then Check that View Cart button is shown.

    Scenario: Check that Mini Cart contains content block
      Given Mini Cart sidebar opened.
      Then Check that content block with text "This content goes from Contentful to zCommerce sidebar." is shown.

    Scenario: Check that user can close Mini Cart side bar
      Given Mini Cart sidebar opened.
      When Click on X button.
      Then Mini Cart sidebar is closed.

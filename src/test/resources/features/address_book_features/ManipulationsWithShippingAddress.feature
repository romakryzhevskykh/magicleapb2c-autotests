Feature: Address book page is a page with address items

  Scenario: Check that logged in user can open Shipping Address Book
    Given Home page opened.
    When Move cursor to my account drop down.
    And Wait until Shipping Address Book item is visible in My Account drop down.
    And Click on Shipping Address Book item in My Account drop down.
    Then Check that header equals to Shipping Address Book

  Scenario: Check that page header is "Shipping Address Book"
    Given Address book page opened.
    Then Check that header equals to Shipping Address Book

  Scenario: Check that page URL is "https://stage.tdsc.com/my-account/address-book"
    Given Address book page opened.
    Then Check that URL equals to https://stage.tdsc.com/my-account/address-book

  Scenario: Check that page contains street address that equals to "14 Francisco St"
    Given Address book page opened.
    Then Check that any address street equals to 14 Francisco St
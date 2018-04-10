Feature: Address book page is a page with address items

  Background:
    Given Switch to Storefront shopper.

  Scenario: Check that logged in user can open Address Book
    Given Home page opened.
    When Click on My Account menu.
    And Click on Address Book item in My Account drop down.
    Then Check that Address Book page is opened.

  Scenario: Check that page header is "Address Book"
    Given Address book page opened.
    Then Check that header equals to Address Book.

  Scenario: Check that page URL is "https://demo-66.zaelab.com/b2b/powertools/en/USD/my-account/address-book"
    Given Address book page opened.
    Then Check that URL equals to https://demo-66.zaelab.com/b2b/powertools/en/USD/my-account/address-book.

  Scenario: Check that new address book is displaying on Address Book page after creating
    Given Address book page opened.
    When Click on Add Address button.
    And Select random country from drop-down on Create new Address page.
    And Select random title from drop-down on Create new Address page.
    And Fill First name with random text on Create new Address page.
    And Fill Last name with random text on Create new Address page.
    And Fill Address 1 with random text on Create new Address page.
    And Fill Town with random text on Create new Address page.
    And Fill Post code with random text on Create new Address page.
    And Click on Save button on Create new Address page.
    And Address book page opened.
    Then Check that created address book entry is present in the list.
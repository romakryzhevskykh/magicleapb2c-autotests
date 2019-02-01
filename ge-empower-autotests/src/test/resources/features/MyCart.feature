Feature: Some actions on My Cart page

  Background:
    Given Switch to Storefront as rmAdmin.
    And User is logged in to Storefront.

  Scenario: Check that user able to open My Cart page and correct header title is displayed.
    And My Cart page is opened.
    Then My Cart title is displayed on My Cart page.

  Scenario Outline: Check that user is able to Save cart on the My Cart page and then see the
  saved cart in the Saved items section with all correct data.
    And Account management page is opened.
    When Choose <region> region.
    And Search random account for chosen region.
    And Click on chosen account.
    And My Cart page is opened.
    Then 0 Item(s) label is displayed on the My cart page.
    Then Build Order header is displayed on the My Cart page.
    Then Order note with <placeholder> placeholder is displayed.
    When User sets random order note to the Build Order field.
    Given Select test product for chosen region.
    And Add the found test product by region to the My Cart.
    Then 1 Item(s) label is displayed on the My cart page.
    When User clicks on the Save items button.
    Then Save to Cart pop-up appears on the My Cart page.
    When User sets random name to the Cart Name input.
    And Click on Save button in the Save to cart pop-up.
    And Saved Items page is opened.
    Then Active Cart table contains <columnsNames> columns.
    Then Active Cart table contains appropriate cart with correct data.
    When User opens appropriate saved cart.
    Then Saved Cart contains previously added Order note.
    Then Saved Cart contains previously added product.
    Then 1 Item(s) label is displayed on the My cart page.
    And Saved Items page is opened.
    When User deletes appropriate saved cart.
    And Refresh page.
    Then Cart with appropriate name disappeared in Saved Cart table.

    Examples:
      | region        | placeholder                                                                              | columnsNames                                                    |
      | North_America | Text entered here is for your information only and does not print on shipping documents. | Cart Name, Created On, Created by, Last Edited On, No. of Items |
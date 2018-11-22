Feature: Some actions with toggles, UI components on the Notification Center page.

  Scenario: Check that admin is able to switch OFF the LessonLy toggle and then switch ON.
    Given Switch to Storefront as internalUser.
    And User is logged in to Storefront.
    And Notification Center page is opened.
    Given Set true value for lessonly.enabled property on HAC f1, HAC f2.
    Given Switch to Storefront as internalUser.
    And Current empowerU toggle position is saved to the threadVarsHashMap.
    And Dashboard page is opened.
    And Notification Center page is opened.
    When Admin switches the empowerU toggle to another state.
    And Dashboard page is opened.
    And Notification Center page is opened.
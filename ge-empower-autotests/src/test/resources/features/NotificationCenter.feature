Feature: Some actions with toggles, UI components on the Notification Center page

  Background:
    Given Switch to Storefront as admin.
    And User is logged in to Storefront.
    And Notification Center page is opened.

  Scenario Outline: Check that all necessary elements are displayed on the Notification Center page
    Then Notification Preferences title is displayed.
    Then Marketing and promotional content title of section is displayed.
    Then Informational toggle section contains <text> description.
    Then Subscription preference <text2> is displayed.
    Then Status & Training Alerts section header is displayed.
    Then Notification Preferences header of Notification Preferences section is displayed.

    Examples:
      | text                                                                                                                                                                                                                                                                                                                                                                         | text2                                                                                            |
      | I would like to receive information on products, services, solutions and events from Industrial Solutions and I give explicit consent based on the privacy policy listed at the footer. Your data may be shared within Industrial Solutions legal entities throughout the world, only to the extent needed to inform you about our products, services, solutions and events. | At any time you will be able to withdraw your consent by modifying your subscription preference. |

#  Scenario: Check that admin is able to switch OFF the LessonLy toggle and then switch ON.
#    And Current Lessonly toggle position is saved to the threadVarsHashMap.
#    When Admin switches the Lessonly toggle to another state.
#    And Click on Save notification preferences button.
#    Then Check that Dashboard page is opened.
#    And Notification Center page is opened.
#    Then Lessonly toggle is switched to previously chosen state.
#    When Admin switches the Lessonly toggle to another state.
#    And Click on Save notification preferences button.
#    Then Check that Dashboard page is opened.
#    And Notification Center page is opened.
#    Then Lessonly toggle is switched to previously chosen state.

   Scenario: Check that admin is able to switch OFF the Status Page toggle and then switch ON.
     And Current Status Page toggle position is saved to the threadVarsHashMap.
     When Admin switches the Status Page toggle to another state.
     And Click on Save notification preferences button.
     Then Check that Dashboard page is opened.
     And Notification Center page is opened.
     Then Status Page toggle is switched to previously chosen state.
     When Admin switches the Status Page toggle to another state.
     And Click on Save notification preferences button.
     Then Check that Dashboard page is opened.
     And Notification Center page is opened.
     Then Status Page toggle is switched to previously chosen state.
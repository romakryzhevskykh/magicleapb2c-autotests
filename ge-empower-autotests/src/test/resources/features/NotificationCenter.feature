Feature: Some actions with toggles, UI components on the Notification Center page

  Background:
    Given Switch to Storefront as internalUser.
    And User is logged in to Storefront.
    And Notification Center page is opened.

  Scenario Outline: Check that all necessary elements are displayed on the Notification Center page
    Then Notification preferences Notification Preferences title is displayed.
    Then Marketing and promotional content title of section is displayed.
    Then Informational toggle section contains <text> description.
    Then Subscription preference <text2> is displayed.
    Then Status & Training Alerts section header is displayed.
    Then Notification Preferences header of Notification Preferences section is displayed.

    Examples:
      | text                                                                                                                                                                                                                                                                                                                                                                         | text2                                                                                            |
      | I would like to receive information on products, services, solutions and events from Industrial Solutions and I give explicit consent based on the privacy policy listed at the footer. Your data may be shared within Industrial Solutions legal entities throughout the world, only to the extent needed to inform you about our products, services, solutions and events. | At any time you will be able to withdraw your consent by modifying your subscription preference. |

  Scenario Outline: Check that admin is able to switch OFF the LessonLy toggle and then switch ON.
    Given Set true value for lessonly.enabled property on HAC f1, HAC f2.
    Given Switch to Storefront as internalUser.
    And Current empowerU toggle position is saved to the threadVarsHashMap.
    And Get Lessonly status for user by email <email>.
    Then Lessonly status corresponds to lessonly toggle position.
    When Admin switches the empowerU toggle to another state.
    And Dashboard page is opened.
    And Notification Center page is opened.
    Then empowerU toggle is switched to previously chosen state.
    And Get Lessonly status for user by email <email>.
    Then Lessonly status corresponds to lessonly toggle position.
    When Admin switches the empowerU toggle to another state.
    And Dashboard page is opened.
    And Notification Center page is opened.
    Then empowerU toggle is switched to previously chosen state.
    And Get Lessonly status for user by email <email>.
    Then Lessonly status corresponds to lessonly toggle position.
    Given Set false value for lessonly.enabled property on HAC f1, HAC f2.

    Examples:
      | email                   |
      | romanlessonly@gmail.com |

  Scenario Outline: Check that admin is able to switch OFF the System Status toggle and then switch ON.
    Given Set true value for lessonly.enabled property on HAC f1, HAC f2.
    Given Switch to Storefront as caAdmin.
    And User is logged in to Storefront.
    And Notification Center page is opened.
    And Current System Status toggle position is saved to the threadVarsHashMap.
    Then StatusPage status for user <email> corresponds to the current System status toggle position.
    When Admin switches the System Status toggle to another state.
    And Dashboard page is opened.
    And Notification Center page is opened.
    Then StatusPage status for user <email> corresponds to the current System status toggle position.
    Then System Status toggle is switched to previously chosen state.
    When Admin switches the System Status toggle to another state.
    And Dashboard page is opened.
    And Notification Center page is opened.
    Then StatusPage status for user <email> corresponds to the current System status toggle position.
    Then System Status toggle is switched to previously chosen state.
    Given Set false value for lessonly.enabled property on HAC f1, HAC f2.

    Examples:
      | email                   |
      | testcaadmin@yopmail.com |

  Scenario: Check that user is able to switch off/on Marketing promotional content toggle.
    And Current promo content toggle position is saved to the threadVarsHashMap.
    When Admin switches the promo content toggle to another state.
    And Dashboard page is opened.
    And Notification Center page is opened.
    Then Promo content toggle is switched to previously chosen state.
    When Admin switches the promo content toggle to another state.
    And Dashboard page is opened.
    And Notification Center page is opened.
    Then Promo content toggle is switched to previously chosen state.
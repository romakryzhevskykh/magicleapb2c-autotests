Feature: Some actions on Profile page

  Background:
    Given Switch to Storefront as secondInternalUser.
    And User is logged in to Storefront.
    And Profile page is opened.

  Scenario: Check that user able to open Profile page and correct header title is displayed
    Then Modify Profile title is displayed on Profile page.

  Scenario Outline: Check that user is able deactivate his user ID in the profile.
    Given Set true value for lessonly.enabled property on HAC f1, HAC f2.
    Given Switch to Storefront as secondInternalUser.
    And User is logged in to Storefront.
    And Profile page is opened.
    Then Unregister section with Unregister title is displayed.
    Then Deactivate description <description> is displayed.
    When User clicks on Deactivate my ID button.
    Then Confirmation pop-up appeared with appropriate <confirmation> text.
    Then Confirmation text <confirmation2> is displayed in the pop-up.
    Then Deactivate my User ID button is disabled.
    When User confirms the deactivate action.
    And User clicks on Deactivate my User ID button.
    Then Login page is opened.
    And Get user status in lessonly service for user by email <email>.
    Then Is INACTIVE user status displayed in lessonly service.
    Given Switch to Storefront as firstEmpAdmin.
    And User is logged in to Storefront.
    And Manage Users page is opened.
    When Admin opens Users tab.
    And Sets <userId> email to the email field.
    And Clicks on the Search button.
    When Clicks on the user name in the table.
    Then User details block for chosen user with <userId> userId is opened.
    Then User sub-status contains Deactivated by: User.
    When Admin opens Actions list.
    And Chooses Reactivate User option from the actions list.
    Then Chosen user has Active user status.
    And Get user status in lessonly service for user by email <email>.
    Then Is ACTIVE user status displayed in lessonly service.

    Examples:
      | email                      | description                               | confirmation                                                       | confirmation2                          | userId          |
      | romanforcaadmin@zaelab.com | If you want to deactivate your empower ID | Are you sure you want to deactivate your user? (No data is erased) | I confirm I want to deactivate my user | romanforcaadmin |

    Scenario:
      And Profile page is opened.
      And Create User instance.
      And Get QMS response for user romanforcaadmin.
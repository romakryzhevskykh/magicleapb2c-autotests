Feature: Some actions on Profile page

  Scenario:
    Given Switch to Storefront as secondInternalUser.
    And User is logged in to Storefront.
    And Profile page is opened.
    And Create User instance.
    And Get QMS response for user romanforcaadmin and save it to the hashmap.
    Then Check that QMS user info are equals to the user info on Profile page for user romanforcaadmin.
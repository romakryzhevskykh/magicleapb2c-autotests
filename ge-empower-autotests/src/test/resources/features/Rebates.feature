Feature: Some actions on Rebates page

  Background:
    Given Switch to Storefront as admin.
    And User is logged in to Storefront.
    And Account management page is opened.
    When Choose North_America region.
    And Search random account for chosen region.
    And Click on chosen account.
    And Rebates page is opened.

  Scenario: Check that Empower regional manager and Regional Account view users are able to see the same count of rebates.
    And Admin see all the rebates.
    Given Switch to Storefront as regionalView.
    And User is logged in to Storefront.
    And Rebates page is opened.
    Then Regional view see the same count of rebates as admin.

  Scenario: Check that user able to open Rebates page and correct header title is displayed.
    Then Rebates title is displayed on Rebates page.

  Scenario: Check that user is able to place rebate manually.
    When Users click on the Create Rebate button on the All Rebates page.
    Then First step of rebate creation process is opened.
    When User chooses Manual Entry option.
    And Sets account for chosen region to the Account No. field.
    And Chooses random SPA No. from Special Pricing Lookup list for the appropriate Account.
    Given Select test product for chosen region.
    When User sets appropriate Catalog No. for appropriate account to the Catalog No. field.
    And Chooses random End Customer Account No. from End Customer Account No. list.
    And Sets correct End Customer Invoice Date.
    And Sets random Distributor Invoice No.
    And Sets random Qty. Sold.
    When User clicks on the Next top button on the first rebate creation step.
    Then Second step is opened.
    Then All data has been replaced correctly from first to second step.
    When User clicks on the Next top button on the second rebate creation step.
    Then Request summary step is opened.
    Then All data has been replaced correctly from second to third step.
    When User clicks on the Submit rebate button.
    And Users accepts Terms and Conditions for Rebates popup.
    Then Request Submission Successful pop-up is displayed.
    And Rebate is created with all parameters.
    Then Rebates title is displayed on Rebates page.
    Then Created rebate is appeared on the All Rebates page.

  Scenario: Check that user is able to place rebate via file uploading.
    When Users click on the Create Rebate button on the All Rebates page.
    Then First step of rebate creation process is opened.
    And Upload test rebate file with name rebate2.xlsx.
    When User clicks on the Next top button on the first rebate creation step.
    Then Second step is opened.
    And Spa No. and Catalog No. are stored to the threadVarsHashMap.
    When User clicks on the Next top button on the second rebate creation step.
    Then Request summary step is opened.
    When User clicks on the Submit rebate button.
    And Users accepts Terms and Conditions for Rebates popup.
    Then Request Submission Successful pop-up is displayed.
    And Rebate is created with all parameters.
    Then Rebates title is displayed on Rebates page.
    Then Created rebate is appeared on the All Rebates page.

  Scenario: Check validation message for End Customer Invoice Date > Current date via file uploading.
    When Users click on the Create Rebate button on the All Rebates page.
    Then First step of rebate creation process is opened.
    And Upload test rebate file with name futureDate-rebate2.xlsx.
    When User clicks on the Next top button on the first rebate creation step.
    Then Second step is opened.
    Then Validation message Date should not be more than current date is displayed under the End Customer Invoice Date field.
    Then Error message is displayed Invalid invoice dates: 01/01/2020 in the top of Rebate Second step page.

  Scenario: Check validation message for Current date < 90 days via file uploading.
    When Users click on the Create Rebate button on the All Rebates page.
    Then First step of rebate creation process is opened.
    And Upload test rebate file with name pastDate-rebate2.xlsx.
    When User clicks on the Next top button on the first rebate creation step.
    Then Second step is opened.
    Then Validation message Date should not be more than 90 days prior to current date is displayed under the End Customer Invoice Date field.
    Then Error message is displayed Invalid invoice dates: 01/01/2017 in the top of Rebate Second step page.
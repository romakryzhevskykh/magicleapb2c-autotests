Feature: Return creation tests

  Background:
    Given Switch to Storefront as empAdmin.
    And User is logged in to Storefront.

#  Scenario: Check that user able to open Returns page and correct header title is displayed
#    And Returns page is opened.
#    Then Returns title is displayed on Returns page.
#
#  Scenario Outline: Check that user is able to create returns in NA, EMEA, ASIA regions
#    And Account management page is opened.
#    When Choose <region> region.
#    And Search random account for chosen region.
#    And Click on chosen account.
#    When Returns page is opened.
#    And Click on Create Request button.
#    Then Return Creation 1 page is opened.
#    When Search All PO No. in the Search field on Return Creation 1 page.
#    And Select First Invoice No. in the Search Result table on Return Creation 1 page.
#    And Select First Product in the Product List table on Return Creation 1 page.
#    And Click on the Next button Return Creation 1 page.
#    Then Return Creation 2 page is opened.
#    Then Correct catalog No is displayed on Return Creation 2 page.
#    And Select Shortage Reason for Request on Return Creation 2 page.
#    And Select Credit Requested Action on Return Creation 2 page.
#    And Set value 1 to the Qty. field on Return Creation 2 page.
#    And Click on Next button on Return Creation 2 page.
#    Then Return Creation 3 page is opened.
#    Then Correct Catalog No, Reason for request and Requested action are displayed on Return Creation 3 page.
#    When Click on Additional Info button on Return Creation 3 page.
#    And Set color of shrink field on Return Creation 3 page.
#    And Set Additional Information field on Return Creation 3 page.
#    And Click on Save button on Return Creation 3 page.
#    Then Is green Additional Info button displayed.
#    And Click on Next button on Return Creation 3 page.
#    Then Return Creation 4 page is opened.
#    Then Correct Catalog No, Reason for request and Requested action are displayed on Return Creation 4 page.
#    When Expand return row on Return Creation 4 page.
#    Then Correct Requested Action, Column of Shrink Wrap and Additional Info are displayed on Return Creation 4 page.
#    When Click on Submit Request button on Return Creation 4 page.
#    And Submit Terms and Conditions for Sale of Products and Services pop-up on Return Creation 4 page.
#    Then Request Submission Successful pop-up is displayed on Return Creation 4 page.
#    When Return is created on Return Creation 4 page.
#    Then Returns title is displayed on Returns page.
#
#    Examples:
#      | region        |
#      | North_America |
#      | EMEA          |
#      | ASIA          |

#  Scenario Outline: Check that user is able to create returns manually via uploading file.
#    And Account management page is opened.
#    When Choose North_America region.
#    And Search random account for chosen region.
#    And Click on chosen account.
#    When Returns page is opened.
#    And Click on Create Request button.
#    And Click on Manual entry option.
#    Then Return Creation 1 page is opened.
#    Then Warning with correct message <warning_message> is displayed.
#    And Upload test return file with name request2.xlsx.
#    And Click on the Next button Return Creation 1 page.
#    Then Return Creation 2 page is opened.
#    Then Correct list of catalogNumbers <catalogNoList> is displayed on Return Creation 2 page.
#    And Select random reason for request for each product.
#    And Click on Next button on Return Creation 2 page.
#    Then Return Creation 3 page is opened.
#    Then Alert message Please remove item from the request. Item cannot be processed online. is displayed on Return Creation 3 page.
#    Then Warning icon is displayed for non-returnable products with No flag.
#    Then Warning icon is not displayed for returnable products with Yes flag.
#    Then Next button is disabled with true value on Return Creation 3 page.
#    When User deletes non-returnable products.
#    And Click on Next button on Return Creation 3 page.
#    Then Return Creation 4 page is opened.
#    When Click on Submit Request button on Return Creation 4 page.
#    And Submit Terms and Conditions for Sale of Products and Services pop-up on Return Creation 4 page.
#    Then Request Submission Successful pop-up is displayed on Return Creation 4 page.
#    When Return is created on Return Creation 4 page.
#    Then Returns title is displayed on Returns page.
#
#    Examples:
#      | warning_message                                                                           | catalogNoList                  |
#      | For North America stock balancing returns, upload a maximum of 150 line items per request | 10091352G1, 10100542G1, TEY330 |
#
#  Scenario: Test coverage for DE91664 - Return with attaching file can't be created
#    And Account management page is opened.
#    When Choose North_America region.
#    And Select account 1143G08.
#    And Click on account with USS1 sales division.
#    When Returns page is opened.
#    And Click on Create Request button.
#    Then Return Creation 1 page is opened.
#    When Search All PO No. in the Search field on Return Creation 1 page.
#    And Select First Invoice No. in the Search Result table on Return Creation 1 page.
#    And Select First Product in the Product List table on Return Creation 1 page.
#    And Click on the Next button Return Creation 1 page.
#    Then Return Creation 2 page is opened.
#    And Select Defective Reason for Request on Return Creation 2 page.
#    And Select Cosmetic Request type on Return Creation 2 page.
#    And Select Paint Request sub-type on Return Creation 2 page.
#    And Select Return & Credit Requested Action on Return Creation 2 page.
#    And Set value 1 to the Qty. field on Return Creation 2 page.
#    And Click on Next button on Return Creation 2 page.
#    Then Return Creation 3 page is opened.
#    When Click on Additional Info button on Return Creation 3 page.
#    And Set Additional Information field on Return Creation 3 page.
#    And Upload request2.xlsx file to the Optional Attach file field on Return Creation 3 page.
#    And Click on Save button on Return Creation 3 page.
#    Then Is green Additional Info button displayed.
#    And Click on Next button on Return Creation 3 page.
#    Then Return Creation 4 page is opened.
#    When Click on Submit Request button on Return Creation 4 page.
#    And Submit Terms and Conditions for Sale of Products and Services pop-up on Return Creation 4 page.
#    Then Request Submission Successful pop-up is displayed on Return Creation 4 page.
#    When Return is created on Return Creation 4 page.
#    Then Returns title is displayed on Returns page.

  Scenario Outline: Check that user is able to save Return for later and then post it.
    And Account management page is opened.
    When Choose North_America region.
    And Search random account for chosen region.
    And Click on chosen account.
    When Returns page is opened.
    And Click on Create Request button.
    Then Return Creation 1 page is opened.
    When User hover mouse over top Next button on Return Creation 1 page.
    Then Is <toolTipNextBtn1and2page> text displayed in the Next button tooltip on Return Creation 1 page.
    When Search All PO No. in the Search field on Return Creation 1 page.
    And Select First Invoice No. in the Search Result table on Return Creation 1 page.
    And Select First Product in the Product List table on Return Creation 1 page.
    And Click on the Next button Return Creation 1 page.
    Then Return Creation 2 page is opened.
    When User hover mouse over bottom Next button on Return Creation 2 page.
    Then Is <toolTipNextBtn1and2page> text displayed in the Next button tooltip on Return Creation 2 page.
    And Select Shortage Reason for Request on Return Creation 2 page.
    And Select Credit Requested Action on Return Creation 2 page.
    And Set value 1 to the Qty. field on Return Creation 2 page.
    When User clicks on Save for later button on Return Creation 2 page.
    Then Save to Return List with title Save to Return List pop-up is appeared.
    Then Save for later Return pop-up contains Please enter a new return list name header.
    When User sets random name to the Return list name input.
    And User clicks on Save button in Save for later Return pop-up.
    Then Returns title is displayed on Returns page.
    When User opens Saved Requests tab.
    Then The return with appropriate name is displayed on the Saved Request tab.
    When User clicks on Edit last saved return icon.
    Then Return Creation 2 page is opened.
    Then Correct catalog No is displayed on Return Creation 2 page.
    And Click on Next button on Return Creation 2 page.
    Then Return Creation 3 page is opened.

    When User hover mouse over bottom Next button on Return Creation 3 page.
    Then Is <toolTipNextBtn3page> text displayed in additional button tooltip on Return Creation 3 page.

    When User hover mouse over Additional Info button on Return Creation 3 page.
    Then Is <additionalButtonTooltip> text displayed in additional button tooltip.


    Examples:
      | toolTipNextBtn1and2page                  | additionalButtonTooltip                               | toolTipNextBtn3page                                                                                            |
      | Required data is missing or is incorrect | Additional information is required for this line item | Additional information missing, please ensure all mandatory data has been entered and saved before proceeding. |
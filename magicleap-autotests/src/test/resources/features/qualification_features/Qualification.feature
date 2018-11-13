Feature: Qualification feature

  Scenario: Fill all qualification forms to update existent customer to B2B
    Given Switch to Storefront shopper.
    When Click on sign up button.
    And Check that Qualification page is opened.
    And Fill Legal Company name Zaelab on the Qualification page.
    And Fill DBA Z-lab on the Qualification page.
    And Fill website zaelab.com on the Qualification page.
    And Fill years in business 10 on the Qualification page.
    And Click on type of business dropdown on the Qualification page.
#    Elements in dropdown: Retailer, Reseller/Wholesaler, Distributor, Other
    And Select type of business Other from dropdown on the Qualification page.
    And Click on market segment dropdown on the Qualification page.
#    Elements in dropdown: Education, Healthcare, Government, Technology, Business, Other
    And Select market segment Technology from dropdown on the Qualification page.
#    Radio buttons: corporation, llc, solePractitioner, other
    And Click on type of ownership llc radio button on the Qualification page.
    And Click on prior business dealings with Magic Leap false radio button on the Qualification page.
    And Click on the next button
    And Fill full user name Stan SmithTest on the Qualification page.
    And Fill mail smithTest@ml.com on the Qualification page.
    And Fill title Mr on the Qualification page.
    And Fill phoneNumber +48 32 44 00 810 on the Qualification page.
    And Fill Street Address Line 1 Columbus 56 on the Qualification page.
    And Fill Street Address Line 2 app 2345 on the Qualification page.
    And Fill City Chicago on the Qualification page.
    And Select state IL from dropdown on the Qualification page.
    And Fill Zip code 05669 on the Qualification page.
    And Click on the next button
    And Fill email to send invoice to smith2Test@ml.com on the Qualification page.
    And Click on Are you Tax Exempt false radio button on the Qualification page.
    And Click on Is your billing address different from the one below false radio button on the Qualification page.
    And Click on Is your shipping address different from the one below false radio button on the Qualification page.
    And Click on Preferred form of payment prepay radio button on the Qualification page.
    And Click on the Get Qualified button
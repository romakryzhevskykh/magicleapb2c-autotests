Feature: Login to Backoffice as user with admin access rights and open main pages.

  Background:
    Given Switch to Backoffice as admin.
    Given Admin is logged in to Backoffice.
    And Refresh page.

  Scenario: Check that admin is able to login to Backoffice and Users - Customers section is opened.
    Given Switch to Backoffice as admin.
    Given Admin is logged in to Backoffice.
    And Refresh page.
    Given Switch to Backoffice as admin.
    Given Admin is logged in to Backoffice.
    And Commerce logo is displayed on the main backoffice page.
    When Admin opens Users tab in Backoffice.
    And Admin opens Customers section in Backoffice.
    And List of users is displayed on the Customers section.
    When Admin opens System tab in Backoffice.
    And Admin opens Background processes tab in Backoffice.
    And Admin opens CronJobs section in Backoffice.
    And List of cronJobs is displayed on the CronJobs section.
    When Admin opens Catalog tab in Backoffice.
    And Admin opens Categories section in Backoffice.
    And List of categories is displayed on the Customers section.
    And Admin opens Products section in Backoffice.
    And List of products is displayed on the Customers section.
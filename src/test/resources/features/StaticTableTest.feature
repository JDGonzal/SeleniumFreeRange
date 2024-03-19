@Test
Feature: Test different actions on Static Table page.

Rule: The user can return values from the table and validate them.

Background: Navigate to Table web app
  Given I navigate to the static table

Scenario: As a Test Engineer, I want to retrieve the value of an static table.
  Then I can return the value I wanted

Scenario: As a Test Engineer, I want to validate the static table is displayed.
  Then I can validate the table is displayed

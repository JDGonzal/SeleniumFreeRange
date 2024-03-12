
Feature: Test different actions on a sandbox page.

Scenario: As a Test Engineer, I try out different actions on a sandbox page.
  Given I navigate to the sandbox page
  And select a value from the dropwdown

Scenario: As a Test Engineer, I want to retrieve the value of an static table.
  Given I navigate to the static table
  Then I can return the value I wanted

@Test
Scenario: As a Test Engineer, I want to validate the static table is displayed.
  Given I navigate to the static table
  Then I can validate the table is displayed

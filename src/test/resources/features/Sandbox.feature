
Feature: Test different actions on a sandbox page.

Scenario: As a Test Engineer, I try out different actions on a sandbox page.
  Given I navigate to the sandbox page
  And select a value from the dropwdown

Scenario: As a Test Engineer, I want to validate that a text is present inside the list.
  Given I navigate to the list page
  When I search the list
  Then I can find the text in the list

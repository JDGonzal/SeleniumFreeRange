Feature: Test Google seach functionality

Scenario: As a user I enter a search criteria in Google
  Given I am on the Google seach page
  When I enter a search criteria
  And click on the seach button
  Then the results match the criteria
Feature: I can find a city inside a state.

@List
Scenario Outline: As a Test Engineer, I want to validate that a <city> is present inside the <state>.
  Given I navigate to the list page
  When I search <state> in the list
  Then I can find <city> in the list

  Examples:
      |state     |city                           |
      |Washington|Washington,Kansas,United States|
      |Chicago   |Chicago,Illinois,United States |
      |California|Adelanto, California, United States|

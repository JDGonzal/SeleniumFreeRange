@Navigation
Feature: Navigation bar
    To see the subpages
    Without logging in
    I can click the navigation bar links

Background: I am on the Free Range Testers web without logging in.
    Given I navigate to www.freerangetesters.com

Scenario Outline: I can access the subpages through the navigation bar: <section>
    When I go to <section> using the navigation bar
    Examples:
        | section    |
            | Cursos     |
            | Recursos   |
            | Udemy      |
            | Mentorías  |
            | Newsletter |

@Courses
Scenario: Courses are presented correctly to potential customers
    When I go to Cursos using the navigation bar
    And The user selects Introduction to Testing

@Plans @Courses
Scenario: I can select a plan when signing up
    When The user selects Elegir Plan
    Then The client can validate the options in the checkout page

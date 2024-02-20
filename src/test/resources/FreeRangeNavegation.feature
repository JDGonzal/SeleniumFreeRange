Feature: Navigation bar
    To see the subpages
    Without logging in
    I can click the navigation bar links
 
Scenario Outline: I can access the subpages through the navigation bar: <section>
    Given I navigate to www.freerangetesters.com 
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
    Given I navigate to www.freerangetesters.com
    When I go to Cursos using the navigation bar
    And select Introduction to Testing

@Plans @Courses
Scenario: Users can select a plan when signing up
    Given I navigate to www.freerangetesters.com
    When I select Elegir Plan
    Then I can validate the options in the checkout page

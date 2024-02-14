Feature: Navigation bar
    To see the subpages
    Without logging in
    I can click the navigation bar links
 
Scenario Outline: I can access the subpages through the navigation bar 
    Given I navigate to www.freerangetesters.com 
    When I go to <section> using the navigation bar
    Examples:
        | section    |
            | Cursos     |
            | Recursos   |
            | Udemy      |
            | Mentorías  |
            | Newsletter |

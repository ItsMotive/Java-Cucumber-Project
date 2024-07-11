# Based on https://practicetestautomation.com/practice-test-login/

Feature: Test login functionality of this site

    @PracticeTestAutomation
    Scenario: TC01: Check login with successful credentials

        Given user is on login homepage

        When user enters <username> and <password> valid
        And user clicks on login button
        Then user is navigated to logout page

        Examples:
        | username | password |
        | student | Password123 |

    @PracticeTestAutomation
    Scenario: TC02: Check login with invalid username

        Given user is on login homepage

        When user enters invalid <username> and valid <password>
        And user clicks on login button
        Then user should see invalid username popup

        Examples:
        | username | password |
        | invalidStudent | Password123 |

    @PracticeTestAutomation
    Scenario: TC03: Check login with invalid password

        Given user is on login homepage

        When user enters valid <username> and invalid <password>
        And user clicks on login button
        Then user should see invalid password popup

        Examples:
        | username | password |
        | student | invalidPass |
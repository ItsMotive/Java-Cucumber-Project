Feature: feature to test login functionality (Using Parameters)

    Scenario: Check login is successful with valid credentials (Param)

        Given user is on login page

        When user enters <username> and <password> parameter
        And user clicks on login button
        Then user is navigated to the home page

        Examples:
        | username | password |
        | student | Password123 |


    Scenario: Check login is successful with invalid username

        Given user is on login page

        When user enters <username> and <password> parameter
        And user clicks on login button
        Then user sees user error popup

        Examples:
        | username | password |
        | InvalidStudent | Password123 |


    Scenario: Check login is successful with invalid password

        Given user is on login page

        When user enters <username> and <password> parameter
        And user clicks on login button
        Then user sees pass error popup

        Examples:
        | username | password |
        | student | InvalidPassword |
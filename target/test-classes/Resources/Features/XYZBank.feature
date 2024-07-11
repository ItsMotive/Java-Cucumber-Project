# Based on this website: https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login

Feature: Testing flow of demo banking website

    @Banking
    Scenario: TC01: Successful Login

        Given user is on banking login
        When user clicks on customer login
        And user selects <user> profile
        And user clicks on bank login
        Then user should be navigated to welcome page

        Examples: 
        |user|
        |Hermoine Granger|
        |Harry Potter|
        |Ron Weasly|
        |Albus Dumbledore|
        |Neville Longbottom|




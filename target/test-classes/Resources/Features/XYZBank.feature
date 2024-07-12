# Based on this website: https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login

Feature: Testing flow of demo banking website

    @Banking
    Scenario: TC01: Successful Customer Login

        Given user is on banking website
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

    @Banking
    Scenario: TC02: Validate successfully adding customer

        Given user is on banking website
        When user clicks on manager login
        And user clicks on add customer
        And user enters <first> first name
        And user enters <last> last name
        And user enters <postal> code
        And user clicks on adding customer
        Then user has alert that confirms successful creation

        Examples:
        |first|last|postal|
        |John|Doe|06183|
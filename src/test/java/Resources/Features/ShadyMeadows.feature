# Based on this site https://automationintesting.online/

Feature: Used for testing hotel website

    @HotelTest
    Scenario: TC01: Validating getting in touch with hotel

        Given user is on website

        When user enters contact name <name>
        And user enters contact email <email>
        And user enters contact phone <phone>
        And user enters contact subject <subject>
        And user enters contact message <message>
        And user clicks on contact submit
        Then user is prompted with thanks message

        Examples:
        | name | email | phone | subject | message |
        | John Doe | johndoe@mail.com | 31232132111 | Getting Access | Something that is 20 characters long |

    @HotelTest @WIP
    Scenario: TC02: Validating booking reservation
        Given user is on website
        When user clicks on booking button
        And user enters booking first name <firstname>
        And user enters booking last name <lastname>
        And user enters booking email <email>
        And user enters booking phone <phone>
        And user clicks and drags the days requesting
        And user clicks on book button
        Then user sees popup of confirmation

        Examples:
        | firstname | lastname | email | phone |
        | John | Doe | johndoe@gmail.com | 32131212333 |
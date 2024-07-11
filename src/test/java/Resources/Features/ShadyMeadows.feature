# Based on this site https://automationintesting.online/

Feature: Used for testing hotel website

    @HotelTest
    Scenario: TC01: Validating getting in touch with hotel

        Given user is on website

        When user enters name <name>
        And user enters email <email>
        And user enters phone <phone>
        And user enters subject <subject>
        And user enters message <message>
        And user clicks on submit
        Then user is prompted with thanks message

        Examples:
        | name | email | phone | subject | message |
        | John Doe | johndoe@mail.com | 31232132111 | Getting Access | Something that is 20 characters long |

        
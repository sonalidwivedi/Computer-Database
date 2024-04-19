Feature: As an inventory manager, I want to add a computer to the system.

  Background:
    Given user access computer database application

  Scenario: Computer is added by entering all the details
    When the user clicks on Add a new computer button and verifies the title
    When the user enters the data for Computer name
    When the user enters the data for Introduced
    When the user enters the data for Discontinued
    When the user selects company name
    When the user clicks on Create this computer button
    Then the user verifies that new computer has been added to the application

  Scenario: User adds new computer without entering computer name
    When the user clicks on Add a new computer button and verifies the title
    When the user enters the data for Introduced
    When the user enters the data for Discontinued
    When the user selects company name
    When the user clicks on Create this computer button
    Then the user verifies the error message


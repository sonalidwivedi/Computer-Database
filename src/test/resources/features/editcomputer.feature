Feature: As an inventory manager, I want to edit the details for existing computer.

  Background:
    Given user access computer database application

  Scenario: User edits all the data for an existing computer
    When the user search for computer by entering computer name
    When the user clicks on filter by name button
    When the user clicks on the first computer
    When the user edits computer name
    When the user edits introduced date
    When the user edits discontinued date
    When the user edits company name
    When the user clicks on Save this computer button
    Then the user verifies that details has been updated successfully

  Scenario: User edits introduced date by providing incorrect format
    When the user search for computer by entering computer name
    When the user clicks on filter by name button
    When the user clicks on the first computer
    When the user edits computer name
    When the user edits introduced date using different format
    When the user clicks on Save this computer button
    Then the user verifies date error message



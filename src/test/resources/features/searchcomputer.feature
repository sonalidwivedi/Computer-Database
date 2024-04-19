Feature: As an inventory manager, I want to filter computers by their name.

  Background:
    Given user access computer database application

  Scenario: User search for computer by entering computer name
    When the user search for computer by entering computer name
    When the user clicks on filter by name button
    Then the user verifies the search result

  Scenario: User search for computer without entering computer name
    When the user clicks on filter by name button
    Then the user verifies the error message displayed



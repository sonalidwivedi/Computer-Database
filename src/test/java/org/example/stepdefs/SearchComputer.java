package org.example.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.factory.DriverFactory;
import org.example.pages.ComputerDataBase;
import org.testng.Assert;

public class SearchComputer {

    public ComputerDataBase computerDatabase = new ComputerDataBase(DriverFactory.getDriver());

    @When("the user search for computer by entering computer name")
    public void the_user_search_for_computer_by_entering_computer_name() {
        computerDatabase.searchComputer("ACE");
    }

    @When("the user clicks on filter by name button")
    public void the_user_clicks_on_filter_by_name_button() {
        computerDatabase.filterByNameButton();
    }

    @Then("the user verifies the search result")
    public void the_user_verifies_the_search_result() {
        Assert.assertTrue(computerDatabase.resultComputers("ACE"),"true");
    }

    @Then("the user verifies the error message displayed")
    public void the_user_verifies_the_error_message_displayed() {
        computerDatabase.errorDialogue();
    }
}

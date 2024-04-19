package org.example.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.factory.DriverFactory;
import org.example.pages.ComputerDataBase;
import org.testng.Assert;

public class EditComputer {

    public ComputerDataBase computerDatabase = new ComputerDataBase(DriverFactory.getDriver());

    @When("the user clicks on the first computer")
    public void the_user_clicks_on_the_first_computer() {
        computerDatabase.clickOnComputerToEdit("ACE");
    }

    @When("the user edits computer name")
    public void the_user_edits_computer_name() {
        computerDatabase.enterComputerName("ASCI Yellow");
    }

    @When("the user edits introduced date")
    public void the_user_edits_introduced_date() {
        computerDatabase.enterIntroducedDate("2019-09-09");
    }

    @When("the user edits discontinued date")
    public void the_user_edits_discontinued_date() {
        computerDatabase.enterDiscontinuedDate("2024-09-09");
    }

    @When("the user edits company name")
    public void the_UserEditsCompanyName() {
        computerDatabase.selectCompany("Canon");
    }

    @Then("the user verifies that details has been updated successfully")
    public void the_user_verifies_that_details_has_been_updated_successfully() {
        String strMessage =computerDatabase.verifyEditMessage();
        Assert.assertEquals(strMessage,"Done ! Computer ASCI Yellow has been updated");
    }

    @When("the user clicks on Save this computer button")
    public void the_user_clicks_on_save_this_computer_button() {
        computerDatabase.clickAddButton();
    }

    @When("the user edits introduced date using different format")
    public void the_user_edits_introduced_date_using_different_format() {
        computerDatabase.enterIntroducedDate("2019.09.09");
    }

    @Then("the user verifies date error message")
    public void the_user_verifies_date_error_message() {
        String strMessage = computerDatabase.verifyIncorrectDateMessage();
        Assert.assertEquals(strMessage,"Failed to decode date : java.time.format.DateTimeParseException: Text '2019.09.09' could not be parsed at index 4");
    }
}

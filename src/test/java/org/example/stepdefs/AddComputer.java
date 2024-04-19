package org.example.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.factory.DriverFactory;
import org.example.pages.ComputerDataBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddComputer {

    public String title;
    public String headerText;

    public ComputerDataBase computerDatabase;
    public DriverFactory driverFactory;
    public WebDriver driver;

    @Before
    public void launchBrowser() {
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver();

    }

    @After(order = 0)
    public void quitBrowser() {
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);

        }
    }

    @Given("user access computer database application")
    public void user_access_computer_database_application() {
        DriverFactory.getDriver().get("https://computer-database.gatling.io/computers");
        computerDatabase = new ComputerDataBase(driver);
        title = computerDatabase.homePage();
        Assert.assertTrue(title.contains("Computers database"));
    }

    @When("the user clicks on Add a new computer button and verifies the title")
    public void the_user_clicks_on_Add_a_new_computer_button_and_verifies_the_title() {
        headerText = computerDatabase.addNewComputer();
        System.out.println(headerText);
        Assert.assertTrue(headerText.contains("Add a computer"));
    }

    @When("the user enters the data for Computer name")
    public void the_user_enters_the_data_for_Computer_name() {
        computerDatabase.enterComputerName("Testing Computer");
    }

    @When("the user enters the data for Introduced")
    public void the_user_enters_the_data_for_Introduced() {
        computerDatabase.enterIntroducedDate("2023-03-10");
    }

    @When("the user enters the data for Discontinued")
    public void the_user_enters_the_data_for_Discontinued() {
        computerDatabase.enterDiscontinuedDate("2024-03-10");
    }

    @When("the user selects company name")
    public void the_user_selects_company_name() {
        computerDatabase.selectCompany("Apple Inc.");
    }

    @When("the user clicks on Create this computer button")
    public void the_user_clicks_on_Create_this_computer_button() {
        computerDatabase.clickAddButton();
    }

    @Then("the user verifies that new computer has been added to the application")
    public void the_user_verifies_that_new_computer_has_been_added_to_the_application() {
        String strMessage = computerDatabase.verifySuccessMessage();
        Assert.assertEquals(strMessage,"Done ! Computer Testing Computer has been created");

    }

    @Then("the user verifies the error message")
    public void the_user_verifies_the_error_message() {
        String strErrorMsg = computerDatabase.verifyErrorMessage();
        Assert.assertEquals(strErrorMsg,"Failed to refine type : Predicate isEmpty() did not fail.");
    }
}
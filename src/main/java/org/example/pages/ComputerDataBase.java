package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ComputerDataBase {

    public WebDriver driver;

    // Locators
    private final By addNewComputer = By.xpath("//a[text()='Add a new computer']");
    private final By computerName = By.id("name");
    private final By introduced = By.id("introduced");
    private final By discontinued = By.id("discontinued");
    private final By companySel = By.xpath("//select[@id='company']");
    private final By submitButton = By.xpath("//input[@type='submit']");
    private final By successMessage = By.xpath("//div[contains(text(),'has been created')]");
    private final By errorMessage = By.xpath("//span[contains(text(),'Failed to refine type')]");
    private final By searchBox = By.xpath("//input[@id='searchbox']");
    private final By filterByName = By.id("searchsubmit");
    private final By editMessage = By.xpath("//div[contains(text(),'has been updated')]");
    private final By incorrectDate = By.xpath("//span[contains(text(),'Failed to decode date')]");
    private final By header = By.xpath("//h1[text()='Add a computer']");

    // Constructor
    public ComputerDataBase(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public String homePage() {
        String strTitle;
        strTitle = driver.getTitle();
        return strTitle;
    }

    public String addNewComputer() {
        WebElement addNewComputerButton = driver.findElement(addNewComputer);
        addNewComputerButton.click();
        String strTitle;
        strTitle = driver.findElement(header).getText();
        return strTitle;
    }

    public void enterComputerName(String computer) {
        WebElement computerloc = driver.findElement(computerName);
        computerloc.clear();
        computerloc.sendKeys(computer);
    }

    public void enterIntroducedDate(String introducedDate) {
        WebElement introducedloc = driver.findElement(introduced);
        introducedloc.clear();
        introducedloc.sendKeys(introducedDate);
    }

    public void enterDiscontinuedDate(String discontinuedDate) {
        WebElement discontinuedloc = driver.findElement(discontinued);
        discontinuedloc.clear();
        discontinuedloc.sendKeys(discontinuedDate);
    }

    public void selectCompany(String companyName) {
        Select dropdownSelect = new Select(driver.findElement(companySel));
        dropdownSelect.selectByVisibleText(companyName);
    }

    public void clickAddButton() {
        WebElement addButton = driver.findElement(submitButton);
        addButton.click();
    }

    public String verifySuccessMessage() {
        WebElement message = driver.findElement(successMessage);
        String strMessage;
        strMessage = message.getText();
        return strMessage;
    }

    public String verifyErrorMessage() {
        WebElement message = driver.findElement(errorMessage);
        String strError;
        strError = message.getText();
        return strError;
    }

    public void searchComputer(String computerName) {
        driver.findElement(searchBox).sendKeys(computerName);
    }

    public void filterByNameButton() {
        driver.findElement(filterByName).click();
    }

    public boolean resultComputers(String computer) {
        String strOut = "(//a[text()='computerName'])".replace("computerName", computer);
        WebElement result = driver.findElement(By.xpath(strOut));
        return result.isDisplayed();
    }

    public void errorDialogue() {
        WebElement enterComputerName = driver.findElement(searchBox);
        enterComputerName.getAttribute("required");
    }

    public void clickOnComputerToEdit(String firstComputer) {
        String strOut = "(//a[text()='computerName'])".replace("computerName", firstComputer);
        WebElement result = driver.findElement(By.xpath(strOut));
        result.click();
    }

    public String verifyEditMessage() {
        WebElement message = driver.findElement(editMessage);
        String strMessage;
        strMessage = message.getText();
        return strMessage;
    }

    public String verifyIncorrectDateMessage() {
        WebElement message = driver.findElement(incorrectDate);
        String strMessage;
        strMessage = message.getText();
        return strMessage;
    }
}

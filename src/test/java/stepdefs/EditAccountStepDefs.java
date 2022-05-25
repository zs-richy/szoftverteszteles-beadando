package stepdefs;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class EditAccountStepDefs extends AbstractStepDefs {
    private final By BUTTON_EDITACCOUNT = By.xpath("/html/body/div[2]/div/aside/div/a[2]");
    private final By INPUT_FIRSTNAME = By.xpath("/html/body/div[2]/div/div/form/fieldset/div[1]/div/input");
    private final By INPUT_LASTNAME = By.xpath("/html/body/div[2]/div/div/form/fieldset/div[2]/div/input");
    private final By INPUT_EMAIL = By.xpath("/html/body/div[2]/div/div/form/fieldset/div[3]/div/input");
    private final By INPUT_TELEPHONE = By.xpath("/html/body/div[2]/div/div/form/fieldset/div[4]/div/input");
    private final By BUTTON_CONTINUE = By.xpath("/html/body/div[2]/div/div/form/div/div[2]/input");
    private final By MESSAGE_NAMELENGTH = By.xpath("/html/body/div[2]/div/div/form/fieldset/div[1]/div/div");
    private final By MESSAGE_EMAILVALID = By.xpath("/html/body/div[2]/div/div/form/fieldset/div[3]/div/div");
    private final By MESSAGE_TELEPHONELENGTH = By.xpath("/html/body/div[2]/div/div/form/fieldset/div[4]/div/div");
    private final By MESSAGE_SUCCESSEDIT = By.xpath("/html/body/div[2]/div[1]");

    private final String VALID_FIRSTNAME = "Teszt";
    private final String VALID_LASTNAME = "ELEK";
    private final String VALID_EMAIL = "teszt@elek.com";
    private final String VALID_TELEPHONE = "06203336789";

    @ParameterType(value = "namelength|emailvalid|phonelength|success")
    public By messageValue(String value) {
        switch (value) {
            case "namelength": return MESSAGE_NAMELENGTH;
            case "emailvalid": return MESSAGE_EMAILVALID;
            case "phonelength": return MESSAGE_TELEPHONELENGTH;
            case "success": return MESSAGE_SUCCESSEDIT;
        }

        return null;
    }

    @ParameterType(value = "firstname|email|telephone|none")
    public By editField(String value) {
        switch (value) {
            case "firstname": return INPUT_FIRSTNAME;
            case "email": return INPUT_EMAIL;
            case "telephone": return INPUT_TELEPHONE;
            case "none": return null;
        }

        return null;
    }

    @And("the Edit Account option is clicked")
    public void theEditAccountOptionIsClicked() {
        homePage.findBy(BUTTON_EDITACCOUNT).click();
    }


    @And("the fields are filled with valid data")
    public void theFieldsAreFilledWithValidData() {
        clearFields();
        homePage.findBy(INPUT_FIRSTNAME).sendKeys(VALID_FIRSTNAME);
        homePage.findBy(INPUT_LASTNAME).sendKeys(VALID_LASTNAME);
        homePage.findBy(INPUT_EMAIL).sendKeys(VALID_EMAIL);
        homePage.findBy(INPUT_TELEPHONE).sendKeys(VALID_TELEPHONE);
    }

    private void clearFields() {
        homePage.findBy(INPUT_FIRSTNAME).clear();
        homePage.findBy(INPUT_LASTNAME).clear();
        homePage.findBy(INPUT_EMAIL).clear();
        homePage.findBy(INPUT_TELEPHONE).clear();
    }

    @And("the Continue \\(save edit) button is clicked")
    public void theContinueSaveEditButtonIsClicked() {
        homePage.findBy(BUTTON_CONTINUE).click();
    }

    @Then("the message {messageValue} should be shown")
    public void thenTheMessageShouldBeShown(By message) {
        Assert.assertTrue(homePage.findBy(message).isDisplayed());
    }

    @Given("the field {editField} is filled with {string}")
    public void theFieldFieldIsFilledWithField_data(By field, String data) {
        if (field == null) return;
        if (data == null || data.isEmpty() || data.equals("null")) data = "";
        homePage.findBy(field).clear();
        homePage.findBy(field).sendKeys(data);
    }

}

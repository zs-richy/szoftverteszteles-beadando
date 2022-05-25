package stepdefs;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import utils.CommonUtils;

import java.util.UUID;

public class SuccessfulRegistrationStepDefs extends AbstractStepDefs {
    private final By TEXT_SUCCESSREGISTER = By.xpath("//*[@id=\"content\"]/h1");
    private final By INPUT_FIRSTNAME = By.xpath("//*[@id=\"input-firstname\"]");
    private final By INPUT_LASTNAME = By.xpath("//*[@id=\"input-lastname\"]");
    private final By INPUT_EMAIL = By.xpath("//*[@id=\"input-email\"]");
    private final By INPUT_TELEPHONE = By.xpath("//*[@id=\"input-telephone\"]");
    private final By INPUT_PASSWORD = By.xpath("//*[@id=\"input-password\"]");
    private final By INPUT_CONFIRMPASSWORD = By.xpath("//*[@id=\"input-confirm\"]");

    @ParameterType(value = "firstname|lastname|email|telephone|password|confirm_password")
    public By registrationField(String value) {
        switch (value) {
            case "firstname": return INPUT_FIRSTNAME;
            case "lastname": return INPUT_LASTNAME;
            case "email": return INPUT_EMAIL;
            case "telephone": return INPUT_TELEPHONE;
            case "password": return INPUT_PASSWORD;
            case "confirm_password": return INPUT_CONFIRMPASSWORD;
        }

        return null;
    }

    @Then("the success message is shown")
    public void theSuccessMessageIsShown() {
        Assert.assertTrue(homePage.findBy(TEXT_SUCCESSREGISTER).isDisplayed());
    }

    @And("the registration field {registrationField} is filled with {string}")
    public void theRegistrationFieldIsFilledWith(By field, String value) {
        homePage.findBy(field).sendKeys(value);
    }

    @And("the registration field email is filled with random email address")
    public void theRegistrationFieldEmailIsFilledWithRandomEmailAddress() {
        homePage.findBy(INPUT_EMAIL).sendKeys(CommonUtils.randomEmail());
    }
}

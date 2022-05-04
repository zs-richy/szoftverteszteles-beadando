package stepdefs;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterStepDefs extends AbstractStepDefs {
    private final By OPTION_REGISTER = By.xpath("/html/body/nav/div/div[2]/ul/li[2]/ul/li[1]/a");
    private final By INPUT_FIRSTNAME = By.xpath("//*[@id=\"input-firstname\"]");
    private final By INPUT_LASTNAME = By.xpath("//*[@id=\"input-lastname\"]");
    private final By INPUT_EMAIL = By.xpath("//*[@id=\"input-email\"]");
    private final By INPUT_TELEPHONE = By.xpath("//*[@id=\"input-telephone\"]");
    private final By INPUT_PASSWORD = By.xpath("//*[@id=\"input-password\"]");
    private final By INPUT_CONFIRMPASS = By.xpath("//*[@id=\"input-confirm\"]");
    private final By CB_AGREEPOLICY = By.xpath("/html/body/div[2]/div/div/form/div/div/input[1]");
    private final By VALIDATORMSG_AGREEPOLICY = By.xpath("/html/body/div[2]/div[1]");
    private final By VALIDATORMSG_PWDLENGTH = By.xpath("/html/body/div[2]/div/div/form/fieldset[2]/div[1]/div/div");
    private final By VALIDATORMSG_PWDMATCH = By.xpath("/html/body/div[2]/div/div/form/fieldset[2]/div[2]/div/div");
    private final By VALIDATORMSG_EMAILVALID = By.xpath("/html/body/div[2]/div/div/form/fieldset[1]/div[4]/div/div");
    private final By BUTTON_CONTINUE = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");

    @ParameterType(value = "true|True|TRUE|false|False|FALSE")
    public Boolean booleanValue(String value) {
        return Boolean.valueOf(value);
    }

    @ParameterType(value = "agreeToPrivacy|passwordLength|passwordMatch|emailValid")
    public String errorValue(String value) {
        return value;
    }

    @Given("the Register option is clicked")
    public void theRegisterOptionIsClicked() {
        homePage.findBy(OPTION_REGISTER).click();
    }

    @Given("the {string} is filled with {string}")
    public void theFieldIsFilledWithParameter(String field, String parameter) {
        homePage.findByXpath(field).sendKeys(parameter);
    }

    @Given("the first name is filled with {string}")
    public void theFirstNameIsFilledWithParameter(String parameter) {
        homePage.findBy(INPUT_FIRSTNAME).sendKeys(parameter);
    }

    @Given("the last name is filled with {string}")
    public void theLastNameIsFilledWithParameter(String parameter) {
        homePage.findBy(INPUT_LASTNAME).sendKeys(parameter);
    }

    @Given("the email is filled with {string}")
    public void theEmailIsFilledWithParameter(String parameter) {
        homePage.findBy(INPUT_EMAIL).sendKeys(parameter);
    }

    @Given("the telephone is filled with {string}")
    public void theTelephoneIsFilledWithParameter(String parameter) {
        homePage.findBy(INPUT_TELEPHONE).sendKeys(parameter);
    }

    @Given("the password is filled with {string}")
    public void thePasswordIsFilledWithParameter(String parameter) {
        homePage.findBy(INPUT_PASSWORD).sendKeys(parameter);
    }

    @Given("the confirm password is filled with {string}")
    public void theConfirmPasswordIsFilledWithParameter(String parameter) {
        homePage.findBy(INPUT_CONFIRMPASS).sendKeys(parameter);
    }

    @Given("the Agree to Privacy Policy is checked {booleanValue}")
    public void theAgreeToPrivacyPolicyIsChecked(Boolean isChecked) {
        if (isChecked) {
            homePage.findBy(CB_AGREEPOLICY).click();
        }
    }

    @Then("the message {errorValue} is shown")
    public void theMessageIsShown(String message) {
        WebElement elementToCheck = null;
        switch (message) {
            case "agreeToPrivacy": elementToCheck = homePage.findBy(VALIDATORMSG_AGREEPOLICY); break;
            case "passwordLength": elementToCheck = homePage.findBy(VALIDATORMSG_PWDLENGTH); break;
            case "passwordMatch": elementToCheck = homePage.findBy(VALIDATORMSG_PWDMATCH); break;
            case "emailValid": elementToCheck = homePage.findBy(VALIDATORMSG_EMAILVALID); break;
        }
        Assert.assertNotNull(elementToCheck);
    }

    @And("the Continue button is clicked")
    public void theContinueButtonIsClicked() {
        homePage.findBy(BUTTON_CONTINUE).click();
    }
}

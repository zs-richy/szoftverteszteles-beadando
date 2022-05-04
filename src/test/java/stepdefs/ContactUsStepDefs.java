package stepdefs;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactUsStepDefs extends AbstractStepDefs {
    private final By BUTTON_CONTACTUS = By.xpath("/html/body/footer/div/div/div[2]/ul/li[1]/a");
    private final By INPUT_NAME = By.xpath("//*[@id=\"input-name\"]");
    private final By INPUT_EMAIL = By.xpath("//*[@id=\"input-email\"]");
    private final By INPUT_ENQUIRY = By.xpath("//*[@id=\"input-enquiry\"]");
    private final By BUTTON_SUBMIT = By.xpath("//*[@id=\"content\"]/form/div/div/input");
    private final By VALIDATORMSG_EMAIL = By.xpath("//*[@id=\"content\"]/form/fieldset/div[2]/div/div");
    private final By VALIDATORMSG_ENQUIRY = By.xpath("//*[@id=\"content\"]/form/fieldset/div[3]/div/div");

    @ParameterType(value = "emailNotValid|enquiryLength")
    public String contactUsErrorValue(String value) {
        return value;
    }

    @And("the Contact Us option is clicked")
    public void contactUsClicked() {
        homePage.findBy(BUTTON_CONTACTUS).click();
    }

    @Given("the name is filled with {string}")
    public void theNameIsFilledWithEmail(String param) {
        homePage.findBy(INPUT_NAME).sendKeys(param);
    }

    @And("the contact email is filled with {string}")
    public void theContactEmailIsFilledWithEmail(String param) {
        homePage.findBy(INPUT_EMAIL).sendKeys(param);
    }

    @And("the enquiry is filled with {string}")
    public void theEnquiryIsFilledWithEnquiry(String param) {
        homePage.findBy(INPUT_ENQUIRY).sendKeys(param);
    }

    @And("the Submit button is clicked")
    public void theSubmitButtonIsClicked() {
        homePage.findBy(BUTTON_SUBMIT).click();
    }

    @Then("the {contactUsErrorValue} is shown")
    public void theMessageContactUsMessageIsShown(String message) {
        WebElement elementToCheck = null;
        switch (message) {
            case "emailNotValid": elementToCheck = homePage.findBy(VALIDATORMSG_EMAIL); break;
            case "enquiryLength": elementToCheck = homePage.findBy(VALIDATORMSG_ENQUIRY); break;
        }
        Assert.assertNotNull(elementToCheck);
    }

}

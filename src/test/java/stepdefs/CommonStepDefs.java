package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import utils.CommonUtils;

import java.util.UUID;

public class CommonStepDefs extends AbstractStepDefs {
    private final By DROPDOWN_MYACCOUNT = By.cssSelector("ul li:nth-child(2)");
    private final By INPUT_EMAIL = By.xpath("//*[@id=\"input-email\"]");
    private final By TOP_LINKS = By.id("top-links");

    @Given("the home page is opened")
    public void theHomePageIsOpened() {
        homePage.openPage();
    }

    @Given("the My Account option is clicked")
    public void theMyAccountOptionIsClicked() {
        homePage.findBy(TOP_LINKS).findElement(DROPDOWN_MYACCOUNT).click();
    }

    @Given("the field {string} is filled with {string}")
    public void theFieldIsFilledWith(String field, String parameter) {
        homePage.findByXpath(field).sendKeys(parameter);
    }

    @And("the email is filled with random email address")
    public void fillEmailWithRandomEmailAddress() {
        homePage.findBy(INPUT_EMAIL).sendKeys(CommonUtils.randomEmail());
    }
}

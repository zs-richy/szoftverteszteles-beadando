package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NewsletterStepDefs extends AbstractStepDefs {
    private final By BUTTON_NEWSLETTER = By.xpath("/html/body/div[2]/div/aside/div/a[12]");
    private final By RB_YES = By.xpath("/html/body/div[2]/div/div/form/fieldset/div/div/label[1]/input");
    private final By RB_NO = By.xpath("/html/body/div[2]/div/div/form/fieldset/div/div/label[2]/input");
    private final By BUTTON_BACK = By.xpath("/html/body/div[2]/div/div/form/div/div[1]/a");
    private final By BUTTON_CONTINUE = By.xpath("/html/body/div[2]/div/div/form/div/div[2]/input");
    private final By MESSAGE_SUCCESS = By.cssSelector("div.alert-success");

    private final String DATA_MESSAGE = "Your newsletter subscription has been successfully updated!";

    @Given("the Newsletter option is clicked")
    public void theNewsletterOptionIsClicked() {
        homePage.findBy(BUTTON_NEWSLETTER).click();
    }

    @And("the option {string} is selected")
    public void theOptionOptionIsSelected(String option) throws Exception {
        WebElement rb;

        if (option.equals("yes")) {
            rb = homePage.findBy(RB_YES);
        } else if (option.equals("no")) {
            rb = homePage.findBy(RB_NO);
        } else {
            throw new Exception("Unexpected value for 'option'");
        }

        rb.click();
        homePage.findBy(BUTTON_CONTINUE).click();
    }

    @Then("the previously selected {string} should be selected")
    public void thePreviouslySelectedOptionShouldBeSelected(String option) throws Exception {
        WebElement rb;

        if (option.equals("yes")) {
            rb = homePage.findBy(RB_YES);
        } else if (option.equals("no")) {
            rb = homePage.findBy(RB_NO);
        } else {
            throw new Exception("Unexpected value for 'option'");
        }

        Assert.assertTrue(rb.getAttribute("checked").equals("true"));
    }

    @Then("the successfully updated message should be shown")
    public void theSuccessfullyUpdatedMessageShouldBeShown() {
        String message = homePage.findBy(MESSAGE_SUCCESS).getText();
        System.out.println(message);

        Assert.assertTrue(message.contains(DATA_MESSAGE));
    }
}

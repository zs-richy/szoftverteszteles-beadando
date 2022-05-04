package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.UUID;

public class SuccessfulRegistrationStepDefs extends AbstractStepDefs {
    private final By TEXT_SUCCESSREGISTER = By.xpath("//*[@id=\"content\"]/h1");

    @Then("the success message is shown")
    public void theSuccessMessageIsShown() {
        Assert.assertTrue(homePage.findBy(TEXT_SUCCESSREGISTER).isDisplayed());
    }
}

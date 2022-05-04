package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LogoutStepDefs extends AbstractStepDefs {
    private final By LINKS = By.id("top-links");
    private final By BUTTON_MYACCOUNT = By.cssSelector("ul li:nth-child(2)");
    private final By TEXT_SUCCESSLOGOUT = By.xpath("/html/body/div[2]/div/div/p[1]");
    private final By OPTION_LOGOUT = By.xpath("/html/body/nav/div/div[2]/ul/li[2]/ul/li[5]/a");

    @Then("successfully logged out")
    public void successfulLogout() {
        homePage.findBy(LINKS).findElement(BUTTON_MYACCOUNT).click();
        homePage.findBy(OPTION_LOGOUT).click();
        Assert.assertTrue(homePage.findBy(TEXT_SUCCESSLOGOUT).isDisplayed());
    }
}

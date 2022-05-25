package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginStepDefs extends AbstractStepDefs {
    private final By OPTION_LOGIN = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a");
    private final By OPTION_LOGOUT = By.xpath("/html/body/nav/div/div[2]/ul/li[2]/ul/li[5]/a");
    private final By BUTTON_LOGIN = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
    private final By TEXT_MYACCOUNT = By.xpath("//*[@id=\"content\"]/h2[1]");
    private final By TEXT_SUCCESSLOGOUT = By.xpath("/html/body/div[2]/div/div/p[1]");
    private final By INPUT_EMAIL = By.xpath("/html/body/div[2]/div/div/div/div[2]/div/form/div[1]/input");
    private final By INPUT_PASSWORD = By.xpath("/html/body/div[2]/div/div/div/div[2]/div/form/div[2]/input");
    private final By MENU_ITEMS = By.cssSelector(".dropdown-menu-right li");
    private final By OPTION_MYACCOUNT = By.xpath("/html/body/nav/div/div[2]/ul/li[2]/ul/li[1]/a");

    private final String DATA_EMAIL = "teszt@elek.com";
    private final String DATA_PASSWORD = "TesztElek";

    @And("the Login option is clicked")
    public void loginOptionIsClicked() {
        homePage.findBy(OPTION_LOGIN).click();
    }

    @And("the Login button is pressed")
    public void theLoginButtonIsPressed() {
        homePage.findBy(BUTTON_LOGIN).click();
    }

    @Then("the My Account page is shown")
    public void theMyAccountPageIsShown() {
        Assert.assertTrue(homePage.findBy(TEXT_MYACCOUNT).isDisplayed());
    }

    @And("the Logout option is clicked")
    public void logoutOptionIsClicked() {
        homePage.findBy(OPTION_LOGOUT).click();
    }

    @Then("the Successful logout message is shown")
    public void theSuccessfulLogoutMessageIsShown() {
        Assert.assertTrue(homePage.findBy(TEXT_SUCCESSLOGOUT).isDisplayed());
    }


    @And("the user is logged in")
    public void theUserIsLoggedIn() {
        if (homePage.findAllBy(MENU_ITEMS).size() > 2) {
            homePage.findBy(OPTION_MYACCOUNT).click();
        } else {
            loginOptionIsClicked();
            theFieldEmailFieldIsFilledWith("teszt@elek.com");
            theFieldPasswordIsFilledWith("TesztElek");
            theLoginButtonIsPressed();
        }
    }

    @And("the field email field is filled with {string}")
    public void theFieldEmailFieldIsFilledWith(String param) {
        homePage.findBy(INPUT_EMAIL).sendKeys(param);
    }

    @And("the field password field is filled with {string}")
    public void theFieldPasswordIsFilledWith(String param) {
        homePage.findBy(INPUT_PASSWORD).sendKeys(param);
    }
}

package stepdefs;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangeCurrencyStepDefs extends AbstractStepDefs {
    private final By DROPDOWN_CURRENCIES = By.xpath("/html/body/nav/div/div[1]/form/div/button");
    private final By OPTION_EUR = By.xpath("/html/body/nav/div/div[1]/form/div/ul/li[1]/button");
    private final By OPTION_GBP = By.xpath("/html/body/nav/div/div[1]/form/div/ul/li[2]/button");
    private final By OPTION_USD = By.xpath("/html/body/nav/div/div[1]/form/div/ul/li[3]/button");
    private final By TEXT_CURRENCY = By.cssSelector("#form-currency > div > button > strong");
    private final By BUTTON_CART = By.cssSelector("#cart > button");

    @ParameterType(value = "eur|usd|gbp")
    public String currencies(String value) {
        return value;
    }

    @Given("the currency dropdown is clicked")
    public void theCurrencyDropdownIsClicked() {
        homePage.findBy(DROPDOWN_CURRENCIES).click();
    }

    @And("the {currencies} is selected")
    public void theCurrencyIsSelected(String currency) {
        WebElement optionToSelect = null;

        switch (currency) {
            case "eur": optionToSelect = homePage.findBy(OPTION_EUR); break;
            case "gbp": optionToSelect = homePage.findBy(OPTION_GBP); break;
            case "usd": optionToSelect = homePage.findBy(OPTION_USD); break;
        }
        optionToSelect.click();
    }

    @Then("the price should be in {currencies}")
    public void thePriceShouldBeInCurrency(String currency) {
        String currencyType = homePage.findBy(TEXT_CURRENCY).getText();

        char currencyChar = ' ';
        switch (currency) {
            case "eur": currencyChar = '€'; break;
            case "usd": currencyChar = '$'; break;
            case "gbp": currencyChar = '£'; break;
        }

        Assert.assertNotNull(currencyType);
        Assert.assertEquals(currencyType.charAt(0), currencyChar);

        String cartButtonText = homePage.findBy(BUTTON_CART).getText();

        String regex = "";
        if (currency.equals("eur")) {
            regex = ".*item\\(s\\) - .*" + currencyChar;
        } else {
            regex = ".*item\\(s\\) - \\" + currencyChar + ".*";
        }
        Assert.assertTrue(cartButtonText.matches(regex));

    }
}

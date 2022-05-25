package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchStepDefs extends AbstractStepDefs {
    private final By BUTTON_MAGNIFYINGGLASS = By.xpath("//*[@id=\"search\"]/span/button");
    private final By BUTTON_SEARCH = By.xpath("//*[@id=\"button-search\"]");
    private final By INPUT_KEYWORD = By.xpath("//*[@id=\"input-search\"]");
    private final By DROPDOWN_CATEGORY = By.xpath("/html/body/div[2]/div/div/div/div[2]/select");
    private final By OPTION_DESKTOP = By.xpath("//*[@id=\"content\"]/div/div[2]/select/option[2]");
    private final By CB_SUBCATEGORIES = By.xpath("//*[@id=\"content\"]/div/div[3]/label");
    private final By CB_SEARCHDESC = By.xpath("//*[@id=\"content\"]/p[1]/label");
    private final By IMG_IPHONE = By.cssSelector("img[title=\"iPhone\"]");
    private final By IMG_MAC = By.cssSelector("img[title=\"iMac\"]");
    private final By INPUT_MAINSEARCHBAR = By.xpath("/html/body/header/div/div/div[2]/div/input");

    private final String DATA_KEYWORD = "mac";

    @And("the magnifying glass is pressed")
    public void magnifyingGlassIsPressed() {
        homePage.findBy(BUTTON_MAGNIFYINGGLASS).click();
    }

    @And("the Search button is pressed")
    public void searchButtonPressed() {
        homePage.findBy(BUTTON_SEARCH).click();
    }

    @And("the Keyword is filled with {string}")
    public void theKeywordIsFilledWithMac(String param) {
        homePage.findBy(INPUT_KEYWORD).sendKeys(param);
    }

    @And("the category \'Desktops\' is selected")
    public void theCategoryDesktopIsSelected() {
        homePage.findBy(DROPDOWN_CATEGORY).click();
        homePage.findBy(OPTION_DESKTOP).click();
    }

    @Given("the subcategories checkbox is selected: {booleanValue}")
    public void theSubcategoriesCheckboxIsSelectedIsSubcatCbSelected(Boolean isChecked) {
        if (isChecked) {
            homePage.findBy(CB_SUBCATEGORIES).click();
        }
    }

    @And("the search in descriptions checkbox is selected: {booleanValue}")
    public void theSearchInDescriptionsCheckboxIsSelectedIsDescriptionCbSelected(Boolean isChecked) {
        if (isChecked) {
            homePage.findBy(CB_SEARCHDESC).click();
        }
    }

    @Then("the product {string} is shown in the results")
    public void theProductProductIsShownInTheResults(String product) throws InterruptedException {
        Thread.sleep(500);
        switch (product) {
            case "iPhone":
                boolean containsIPhone = homePage.findBy(IMG_IPHONE).isDisplayed();
                Assert.assertTrue(containsIPhone);
                break;
            case "iMac":
                boolean containsIMac = homePage.findBy(IMG_MAC).isDisplayed();
                Assert.assertTrue(containsIMac);
                break;
        }
    }

    @And("the main searchbar is filled with {string}")
    public void theMainSearchbarIsFilledWith(String param) {
        homePage.findBy(INPUT_MAINSEARCHBAR).sendKeys(param);
    }
}

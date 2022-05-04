package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

public class AddressStepDefs extends AbstractStepDefs {
    private final By BUTTON_ADDRESS = By.xpath("/html/body/div[2]/div/aside/div/a[4]");
    private final By BUTTON_NEWADDRESS = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/a");
    private final By INPUT_FIRSTNAME = By.xpath("/html/body/div[2]/div/div/form/fieldset/div[1]/div/input");
    private final By INPUT_LASTNAME = By.xpath("/html/body/div[2]/div/div/form/fieldset/div[2]/div/input");
    private final By INPUT_ADDRESS1 = By.xpath("/html/body/div[2]/div/div/form/fieldset/div[4]/div/input");
    private final By INPUT_CITY = By.xpath("/html/body/div[2]/div/div/form/fieldset/div[6]/div/input");
    private final By INPUT_POSTCODE = By.xpath("/html/body/div[2]/div/div/form/fieldset/div[7]/div/input");
    private final By INPUT_COUNTRY = By.xpath("/html/body/div[2]/div/div/form/fieldset/div[8]/div/select");
    private final By OPTION_HUNGARY = By.xpath("/html/body/div[2]/div/div/form/fieldset/div[8]/div/select/option[105]");
    private final By INPUT_REGION = By.xpath("/html/body/div[2]/div/div/form/fieldset/div[9]/div/select");
    private final By OPTION_NONE = By.xpath("/html/body/div[2]/div/div/form/fieldset/div[9]/div/select/option[2]");
    private final By BUTTON_CONTINUE = By.xpath("/html/body/div[2]/div/div/form/div/div[2]/input");
    private final By TABLE_LASTROW = By.cssSelector("#content div.table-responsive tr:last-of-type");
    private final By BUTTON_DELETE = By.cssSelector(".btn-danger");
    private final By MESSAGE_DELETE_SUCCESS = By.cssSelector(".alert-success");

    private final String DATA_FIRSTNAME = "Elek";
    private final String DATA_LASTNAME = "Teszt";
    private final String DATA_ADDRESS1 = "Zsák utca 1.";
    private final String DATA_CITY = "Zsákfalva";
    private final String DATA_POSTCODE = "13579";
    private final String DATA_COUNTRY = "Hungary";

    @Given("the Address Book is clicked")
    public void theAddressBookIsClicked() {
        homePage.findBy(BUTTON_ADDRESS).click();
    }


    @Given("the address inputs are filled")
    public void theAddressInputsAreFilled() {
        homePage.findBy(INPUT_FIRSTNAME).sendKeys(DATA_FIRSTNAME);
        homePage.findBy(INPUT_LASTNAME).sendKeys(DATA_LASTNAME);
        homePage.findBy(INPUT_ADDRESS1).sendKeys(DATA_ADDRESS1);
        homePage.findBy(INPUT_CITY).sendKeys(DATA_CITY);
        homePage.findBy(INPUT_POSTCODE).sendKeys(DATA_POSTCODE);
        homePage.findBy(INPUT_COUNTRY).click();
        homePage.findBy(OPTION_HUNGARY).click();
        homePage.findBy(INPUT_REGION).click();
        homePage.findBy(OPTION_NONE).click();
    }

    @And("the continue is clicked")
    public void theContinueIsClicked() {
        homePage.findBy(BUTTON_CONTINUE).click();
    }

    @Then("the new address should be at the bottom of the table")
    public void theNewAddressShouldBeAtTheBottomOfTheTable() {
        WebElement tableRow =
                homePage.findBy(TABLE_LASTROW);

        String leftText = tableRow.findElement(By.cssSelector(".text-left")).getText();

        StringBuilder sb = new StringBuilder()
                .append(DATA_FIRSTNAME).append(" ").append(DATA_LASTNAME).append("\n")
                .append(DATA_ADDRESS1).append("\n")
                .append(DATA_CITY).append(" ").append(DATA_POSTCODE).append("\n")
                .append(DATA_COUNTRY);

        Assert.assertTrue(leftText.contains(sb.toString()));
    }

    @And("the New Address button is pressed")
    public void theNewAddressButtonIsPressed() {
        homePage.findBy(BUTTON_NEWADDRESS).click();
    }

    @And("the Delete \\(address) button is pressed")
    public void theDeleteAddressButtonIsPressed() {
        List<WebElement> deleteButtons = homePage.findAllBy(BUTTON_DELETE);
        Assert.assertNotNull(deleteButtons);
        if (deleteButtons.size() == 1) return;

        WebElement iterButton = deleteButtons.get(1);
        iterButton.click();
        theAddressShouldBeDeleted();
        theDeleteAddressButtonIsPressed();
    }

    @Then("the address should be deleted")
    public void theAddressShouldBeDeleted() {
        Assert.assertTrue(homePage.findBy(MESSAGE_DELETE_SUCCESS).isDisplayed());
    }
}

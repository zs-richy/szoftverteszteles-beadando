package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class CartStepDefs extends AbstractStepDefs {
    private final By BUTTON_SHOPPINGCART = By.xpath("/html/body/nav/div/div[2]/ul/li[4]/a/i");
    private final By MESSAGE_EMPTYCART = By.xpath("/html/body/div[2]/div/div/p");
    private final By BUTTON_DELETE = By.cssSelector(".fa-times-circle");
    private final By DIV_PRODUCT = By.cssSelector(".product-layout");
    private final By TITLE_PRODUCT = By.cssSelector("div.caption h4 a");
    private final By ICON_ADDTOCART = By.cssSelector(".fa-shopping-cart");
    private final By MESSAGE_CART = By.xpath("/html/body/div[2]/div[1]/a[2]");
    private final By TABLE_CARTITEMS = By.cssSelector("form .table-bordered tbody tr");
    private final By INPUT_QUANTITY = By.xpath("/html/body/div[2]/div/div/form/div/table/tbody/tr/td[4]/div/input");
    private final By TEXT_PRODUCTNAME = By.xpath("/html/body/div[2]/div/div/form/div/table/tbody/tr/td[2]/a");
    private final By BUTTON_CHECKOUT = By.xpath("/html/body/div[2]/div/div/div[3]/div[2]/a");
    private final By BUTTON_CONTINUE = By.cssSelector(".clearfix .pull-right .btn-primary");

    private final By CB_ACCEPT = By.xpath("/html/body/div[2]/div/div/div/div[5]/div[2]/div/div[2]/div/input[1]");
    private final By BUTTON_CONFIRMORDER = By.xpath("/html/body/div[2]/div/div/div/div[6]/div[2]/div/div[2]/div/input");
    private final By MESSAGE_ORDERPLACED = By.cssSelector("div#content h1");

    private final String ORDER_SUCCESSFUL = "Your order has been placed!";


    @And("the cart is empty")
    public void theCartIsEmpty() {
        Boolean conditionToMeet = false;

        homePage.findBy(BUTTON_SHOPPINGCART).click();

        if (homePage.findBy(MESSAGE_EMPTYCART).getText().contains("Your shopping cart is empty!")) {
            conditionToMeet = true;
        }

        if (!conditionToMeet) {
            List<WebElement> deleteButtons = homePage.findAllBy(BUTTON_DELETE);
            if (deleteButtons == null || deleteButtons.size() == 0) return;

            WebElement iterButton = deleteButtons.get(0);
            iterButton.click();
            theCartIsEmpty();
        }

    }

    @And("the {string} is added to cart")
    public void theItemIsAddedToCart(String product) {
        List<WebElement> results = homePage.findAllBy(DIV_PRODUCT);

        for (WebElement webElement : results) {
            String productText = webElement.findElement(TITLE_PRODUCT).getText();
            if (productText != null && productText.equals(product)) {
                webElement.findElement(ICON_ADDTOCART).click();
                break;
            }
        }

    }

    @And("the cart is opened")
    public void theCartIsOpened() {
        homePage.findBy(MESSAGE_CART).click();
    }

    @Then("the cart contains {int} {string}")
    public void theCartContainsMacBook(int quantity, String product) {
        List<WebElement> rows = homePage.findAllBy(TABLE_CARTITEMS);

        Assert.assertEquals(1, rows.size());

        String productName = homePage.findBy(TEXT_PRODUCTNAME).getText();
        Assert.assertEquals(productName, product);

        System.out.println(homePage.findBy(INPUT_QUANTITY).getText());
        int inputQuantity = Integer.parseInt(homePage.findBy(INPUT_QUANTITY).getAttribute("value"));
        Assert.assertEquals(inputQuantity, quantity);

    }

    @And("the Checkout button is pressed")
    public void theCheckoutButtonIsPressed() {
        homePage.findBy(BUTTON_CHECKOUT).click();
    }

}

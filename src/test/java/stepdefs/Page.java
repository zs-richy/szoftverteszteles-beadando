package stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Optional;

public class Page {
    private static final String PAGE_URL = "http://tutorialsninja.com/demo/";
    private WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public WebElement findBy(By by) { return driver.findElement(by); }

    public List<WebElement> findAllBy(By by) { return driver.findElements(by); }

    public WebElement findById(String id) {
        return driver.findElement(By.id(id));
    }

    public WebElement findByClass(String className) {
        return driver.findElement(By.className(className));
    }

    public WebElement findByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public WebDriver getDriver() {
        return driver;
    }

}

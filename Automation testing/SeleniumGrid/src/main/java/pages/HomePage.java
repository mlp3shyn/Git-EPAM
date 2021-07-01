package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='masthead-inner']//div[contains(@class, 'masthead-action-dropdown')]")
    private WebElement locationButton;

    @FindBy(xpath = "//div[@class='masthead-inner']//a[contains(@href, '/account/signin')]")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class='masthead-inner']//a[contains(@href, '/account/signin')]')]")
    private WebElement cardButton;

    //SnowBoard Category
    @FindBy(xpath = "//li[@data-id ='snowboard']")
    private WebElement snBcategory;



    public void clickSigInButton(){signInButton.click();}

    public void moveToSnowboardCategory(){
        snBcategory.click();
    }





}

package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Locale;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Continue to cart')]")
    private WebElement continueToCartButton;

    @FindBy(xpath = "//div[@class='product-hero']/h1")
    private WebElement itemDescription;

    @FindBy(xpath = "//span[@class='product-colour']")
    private WebElement productColor;

    @FindBy(xpath = "//button[@data-test-id='add-button']")
    private WebElement addToBag;


    public boolean checkIfItemDescriptionContainText(String text){
        boolean result =true;
            if (itemDescription.getText().toLowerCase(Locale.ROOT).contains(text.toLowerCase(Locale.ROOT))) result = true;
            else {
                result = false;

            }
        return result;
    }
    public String getProductColor(){
        return productColor.getText();
    }

    public void addToBag(){
        addToBag.click();
    }
}

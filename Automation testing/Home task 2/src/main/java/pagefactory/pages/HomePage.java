package pagefactory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(xpath = "//input[@id='input_search']")
    private WebElement searchInput;

    @FindBy(xpath = "//span[@class='sidebar-item']")
    private WebElement productCatalogButton;

    @FindBy(xpath = "//div[@class = 'sidebar-wrapp']//a[contains(@href, 'telefonyi-i-aksessuaryi')]")
    private WebElement mobiPhonesCategory;

    @FindBy(xpath = "//div[@class='category-top']/div[@class='sort-holder']//select/option[@value='priceasc']")
    private WebElement sortByLowestPriceMenu;

    @FindBy(xpath = "//div[@class='category-top']/div[@class='sort-holder']//select/option[@value='pricedesc']")
    private WebElement sortByHighestPriceMenu;

    @FindBy(xpath = "//div[@class='filter-nav']//label[@for='fltr-1']")
    private WebElement onlyAvaible;

    private static String ItemsPrice =  "//div[@class='prod-cart__prise-new']";



    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void selectOnlyAvable(){ onlyAvaible.click();}
    public void searchByKeyword(final String keyword) {
        searchInput.sendKeys(keyword, Keys.ENTER);
    }
    public void sortItemsByHighestPrice(){ sortByHighestPriceMenu.click();  }
    public void sortItemsByLowestPrice(){ sortByLowestPriceMenu.click();  }
    public List<WebElement> getItemsPrices(){ return driver.findElements(By.xpath(ItemsPrice)); }




    public void clickOnProductCatalogButton() {  }
    public void clickOnMobilePhoneCatalog(){  productCatalogButton.click();
        mobiPhonesCategory.click();
    }
//
//    public void clickOnAppleStoreButton() {
//        appleSеoreButton.click();
//    }
//
//    public String getTextOfAmountProductsInCart() {
//        return amountOfProductsInCart.getText();
//    }
}

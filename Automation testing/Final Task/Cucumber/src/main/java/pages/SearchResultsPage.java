package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@data-auto-id='productTileDescription']//p")
    private List<WebElement> itemsDescription;

    @FindBy(xpath = "//span[@data-auto-id='productTilePrice']")
    private List<WebElement> itemsPrices;

     @FindBy(xpath = "//li[@data-auto-id='sort']//button")
    private WebElement sortButton;

    @FindBy(xpath = "//li[@data-auto-id='brand']//button")
    private WebElement brandButton;

    @FindBy(xpath = "//li[@data-auto-id='base_colour']//button")
    private WebElement colourButton;

    @FindBy(xpath = "//div[contains(text(),'adidas')]")
    private WebElement brandAdidas;

    @FindBy(xpath = "//div[contains(text(),'Black')]")
    private WebElement colorBlack;

    @FindBy(xpath = "//div[contains(text(),'Blue')]")
    private WebElement colorBlue;

    @FindBy(xpath = "//li[@id='plp_web_sort_price_high_to_low']")
    private WebElement sortPriceHighToLow;

    @FindBy(xpath = "//li[@id='plp_web_sort_price_low_to_high']")
    private WebElement sortPriceLowToHigh;

    @FindBy(xpath = "//img[@data-auto-id='productTileImage']")
    private List<WebElement> productTitles;

    @FindBy(xpath = "//div[@id='search-term-banner']")
    private WebElement banner;

    @FindBy(xpath = "//button[@data-auto-id='saveForLater']")
    private List<WebElement> wishListIcon;

    public void selectSortPriceHighToLow(){
        sortButton.click();
        waitForPageLoadComplete(60);
        sortPriceHighToLow.click();
    }
    public void selectSortPriceLowToHigh(){

        sortButton.click();
        waitForPageLoadComplete(60);
        waitForAjaxToCompletePdp(60);
        waitForAjaxToComplete(120);
        sortPriceLowToHigh.click();
    }

    public void selectBlackColorItems(){
        waitForPageLoadComplete(120);
        colourButton.click();
        waitForPageLoadComplete(120);
        colorBlack.click();


    }
    public void selectBlueColorItems(){
        waitForPageLoadComplete(120);
        colourButton.click();
        waitForPageLoadComplete(120);
        colorBlue.click();


    }

    public void selectAdidasBrandItems(){
        brandButton.click();
        waitForPageLoadComplete(60);
        waitForAjaxToComplete(60);
        brandAdidas.click();
        waitForAjaxToComplete(60);
    }
    public void moveToFirstItem(){
        waitForPageLoadComplete(60);
        productTitles.get(0).click();
    }
    public boolean checkIfItemsAreSorted(final String sortType){

        Iterator<WebElement> iter = itemsPrices.iterator();
        boolean result= false;
        WebElement current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if((sortType.equals("highToLow")) &&
                    (Float.parseFloat(getPrice(previous)) > Float.parseFloat(getPrice(current)))) {
                result = true;
                previous = current;
                break;
            }
            if((sortType.equals("lowToHigh")) &&
                    (Float.parseFloat(getPrice(previous)) < Float.parseFloat(getPrice(current)))){
                result = true;
                previous = current;
                break;
            }
        }
        return result;
    }

    public boolean checkIfPriceContainsCurrency(final String currency){
        boolean result = false;
        Map<String, String> currencies = new HashMap<String, String>();
        currencies.put("USD","$");
        currencies.put("GBP","£");
        currencies.put("EU","€");

       for (WebElement tmpWebEl: itemsPrices) {
            if (tmpWebEl.getText().contains(currencies.get(currency)))
                result = true;
            else
                result = false;
                break; }
        return result;
    }

    public boolean checkIfItemDescriptionContainText(String text){
        boolean result =true;
        for (WebElement tmpWebEl: itemsDescription) {
            if (tmpWebEl.getText().toLowerCase(Locale.ROOT).contains(text.toLowerCase(Locale.ROOT))) result = true;
            else
                result = false;
                break; }
        return result;
    }
    // Вибираємо тільки цифри з ціни
    public static String getPrice(WebElement input)
    {
        String output = "";
        Pattern pattern = Pattern.compile("\\d{1,3}[,\\.]?(\\d{1,2})?");
        Matcher matcher = pattern.matcher(input.toString());
        if (matcher.find())
        {
            output = matcher.group(0);
        }
        return output;
    }


    public void clickWishListOnFirstProduct() {
        wishListIcon.get(0).click();
    }

}

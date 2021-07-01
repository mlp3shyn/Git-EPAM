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

    private static final String SITE_URL = "https://www.asos.com/";

    @FindBy(xpath = "//div[@data-testid='search-field']//input[@type='search']")
    private WebElement searchField;

    @FindBy(xpath = "//div[@id ='myAccountDropdown']")
    private WebElement myAccount;

    @FindBy(xpath = "//a[@data-testid='signin-link']")
    private WebElement signIn;

    @FindBy(xpath = "//a[@data-testid='signup-link']")
    private WebElement join;

    @FindBy(xpath = "//header//div[@data-testid='country-selector']")
    private WebElement preferencePopUp;

    @FindBy(xpath = "//select[@id='country']//option[@value='UA']")
    private WebElement languageUA;

    @FindBy(xpath = "//select[@id='country']//option[@value='PL']")
    private WebElement languagePL;

    @FindBy(xpath = "//select[@id='currency']//option[@value='1']")
    private WebElement currencyGBP;

    @FindBy(xpath = "//select[@id='currency']//option[@value='2']")
    private WebElement currencyUSD;

    @FindBy(xpath = "//select[@id='currency']//option[@value='19']")
    private WebElement currencyEUR;

    @FindBy(xpath = "//button[@data-testid='save-country-button']")
    private WebElement updatePreferencesButton;

    @FindBy(xpath = "//a[@data-testid='women-floor']")
    private WebElement womanCategorie;

    @FindBy(xpath = "//a[@data-testid='men-floor']")
    private WebElement manCategorie;

    @FindBy(xpath = "//a[@data-testid='asoslogo']")
    private WebElement asosLogo;

    @FindBy(xpath = "//a[@data-testid='savedItemsIcon']")
    private WebElement wishListIcon;


    @FindBy(xpath = "//button[@data-testid='miniBagIcon']")
    private WebElement bagIcon;

    @FindBy(xpath = "//a[@data-test-id='bag-link']")
    private WebElement viewBag;


    public void openHomePage() {
        driver.get(SITE_URL);   }
    public boolean isSearchFieldDisplayed() {
        return searchField.isDisplayed();    }

    public void enterTextIntoSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText, Keys.ENTER); }

    public void clickUserIcon()         { myAccount.click(); }
    public void clickLogIn()            { signIn.click();    }
    public void clickJoin()             { join.click();      }
    public void clickPreference()       {preferencePopUp.click();}
    public void clickUpdatePreferences(){ updatePreferencesButton.click();  }
    public void clickManCAtegorie()     { manCategorie.click();  }
    public void selectCurrency(final String curr){
        if(curr.equals("GBP")) currencyGBP.click();
        if(curr.equals("USD")) currencyUSD.click();
        if(curr.equals("EU")) currencyEUR.click();
        else currencyUSD.click();
    }
    public void selectLanguage(final String lang){
        if (lang.equals("UA")) languageUA.click();
        if (lang.equals("PL")) languagePL.click();
    }

    public void moveToWishList(){
        wishListIcon.click();
    }

    public void clickBagIcon(){
        bagIcon.click();
    }
    public void clickViewBAg(){
        viewBag.click();
    }

    public void clickLogo() {
        asosLogo.click();
    }












}

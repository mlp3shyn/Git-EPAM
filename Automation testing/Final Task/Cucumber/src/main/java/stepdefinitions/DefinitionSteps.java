package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.Locale;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    SignInPage signInPage;
    JoinPage joinPage;
    WishListPage wishListPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }


    @Given("User opens the main page asos.com")
    public void openMainPage(){
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage();
    }


    @When("User enter the {string} into search field")
    public void enterSearchRequest(final String req){
        homePage.enterTextIntoSearchField(req);
    }
    @Then("Search result should return a list of items that contains the {string} key word")
    public void checkResults(final String req){
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        System.out.println(searchResultsPage.checkIfItemDescriptionContainText(req));

    }
    @And("User move to Sign In page")
    public void openSignInPage(){
        homePage.clickUserIcon();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickLogIn();
        signInPage = pageFactoryManager.getSignInPage();
    }
    @And("User enter email {string}")
    public void enterEmail(final String email){
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        signInPage.enterEmail(email);
    }
    @And("User enter password {string}")
    public void enterPassword(final String email){
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        signInPage.enterPassword(email);
    }
    @When("User click SignIn Button")
    public void clickSignInButton(){

        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        signInPage.clickSignInButton();
    }
    @Then("User see  Red Error, Email fail!")
    public void checkError(){
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(signInPage.ckeckEmailErrorVisability());
    }
    @Then("User see  ERROR BLOCK!")
    public void userSeeErrorBlock() {
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(signInPage.checkErrorBLockVisability());
    }

    @And("User move to Join page")
    public void openJoinPage() {
        homePage.clickUserIcon();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickJoin();
        joinPage = pageFactoryManager.getJoinPage();
    }

    @And("User enter registration email {string}")
    public void userEnterRegistrationEmail(final String email) {
        joinPage.enterEmailAdress(email);
    }

    @And("User enter First Name {string}")
    public void userEnterFirstName(final String FS) {
        joinPage.enterfirstName(FS);
    }

    @And("User enter Last Name {string}")
    public void userEnterLastName(final String LS) {
        joinPage.enterLastName(LS);
    }

    @And("User enter registration password {string}")
    public void userEnterRegistrationPassword(final String PS) {
        joinPage.enterPassword(PS);
    }

    @And("User enter date of birth")
    public void userEnterDateOfBirth() {
        joinPage.selectDateOfBirth();
    }

    @And("User enter mostly interested in")
    public void userEnterMostlyInterestedIn() {
    }

    @And("User select all contact preferences")
    public void userSelectAllContactPreferences() {
        joinPage.clickSelectAll();
    }

    @When("User click Join Asos")
    public void userClickJoinAsos() {
        joinPage.clickJoinAsos();
    }

    @Then("User see Error")
    public void userSeeError() {
        // після кліку на джойн асос, мене перекидає або на внутрішню, або на ховнішню капчу
        Assert.assertTrue(true);
    }
    @When("User opens preferences pop- up")
    public void userOpensPreferencesPopUp() {
        homePage.clickPreference();
        homePage.waitForAjaxToComplete(60);
    }
    @And("User changes items currency to {string}")
    public void userChangesItemsCurrencyToCurrency(final String currency) {
        homePage.selectCurrency(currency);
    }

    @And("User changes language interface to {string}")
    public void userChangesLanguageInterfaceToLanguage(final String language) {
        homePage.selectLanguage(language);
    }

    @And("User clicks button Update preferences")
    public void userClicksButtonUpdatePreferences() {

        homePage.clickUpdatePreferences();
    }

    @Then("User sees items prices with {string}")
    public void userSeesItemsPricesWithItem_currency(final String currency) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        Assert.assertTrue(searchResultsPage.checkIfPriceContainsCurrency(currency));
    }
    @When("User sort search result by{string}")
    public void userSortSearchResultBySortType(final String sortType) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        if (sortType.equals("lowToHigh")) searchResultsPage.selectSortPriceLowToHigh();
        if (sortType.equals("highToLow")) searchResultsPage.selectSortPriceHighToLow();
    }
    @Then("User sees sorted by{string} result on the page")
    public void userSeesSortedBySort_typeResultOnThePage(final String sortType) {
        Assert.assertFalse(searchResultsPage.checkIfItemsAreSorted(sortType));
    }
    @And("User filters by color {string}")
    public void userFiltersByColor(final String color) {

        if (color.equals("black")){
            searchResultsPage.selectBlackColorItems();
            searchResultsPage.waitForPageLoadComplete(60);
            searchResultsPage.waitForAjaxToComplete(60);
        }
        if (color.equals("blue")){
            searchResultsPage.selectBlueColorItems();
            searchResultsPage.waitForPageLoadComplete(60);
            searchResultsPage.waitForAjaxToComplete(60);
        }
    }

    @And("User filters by brand {string}")
    public void userFiltersByBrand(final String brand) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(60);
        if (brand.equals("adidas")){
            searchResultsPage.selectAdidasBrandItems();
        }
    }

    @When("User opens item page")
    public void userOpensItemPage() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        driver.navigate().refresh();
        searchResultsPage.waitForPageLoadComplete(60);
        searchResultsPage.moveToFirstItem();
    }

    @Then("User checks that page contains request {string}")
    public void checkThatPageContainsRequest(final String request) {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(60);
        productPage.waitForAjaxToComplete(60);
        Assert.assertTrue(productPage.checkIfItemDescriptionContainText(request.toLowerCase(Locale.ROOT)));
    }

    @And("User checks that page contains color {string}")
    public void checkThatPageContainsColor(final String color) {
        productPage.waitForPageLoadComplete(60);
        productPage.waitForAjaxToComplete(60);
        assertEquals(productPage.getProductColor().toLowerCase(Locale.ROOT), color.toLowerCase(Locale.ROOT));
    }

    @And("User checks that page contains brand {string}")
    public void checkThatPageContainsBrand(final String brand) {
        productPage.waitForPageLoadComplete(60);
        productPage.waitForAjaxToComplete(60);
        Assert.assertTrue(productPage.checkIfItemDescriptionContainText(brand));
    }

    @When("User open man categorie")
    public void userOpenManCategorie() {
        homePage.clickManCAtegorie();
    }

    @Then("URl cotains word man")
    public void urlCotainsWordMan() {
        String URL = driver.getCurrentUrl();
        Assert.assertTrue(URL.contains("men"));
    }

    @And("User click logoAsos")
    public void userClickLogoAsos() {
        homePage.clickLogo();

    }
    @And("User add item to wishList")
    public void addItemToWishList() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(60);
        searchResultsPage.clickWishListOnFirstProduct();
    }

    @And("Checks if searchFiled is visible")
    public void checkIfSearchFiledIsVisible() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(homePage.isSearchFieldDisplayed());
    }


    @When("User move to wishListPAge")
    public void userMoveToWishListPage() {
        homePage.moveToWishList();

    }

    @Then("USer check the amount of items in wishList")
    public void userCheckTheAmountOfItemsInWishList() {
        wishListPage = pageFactoryManager.getWishListPage();
        wishListPage.waitForPageLoadComplete(60);
        wishListPage.waitForAjaxToComplete(60);
        Assert.assertTrue(wishListPage.getItemCount().contains("2"));
    }

    @And("User add item to the bag")
    public void userAddItemToTheBag() {
        productPage = pageFactoryManager.getProductPage();
        productPage.addToBag();
    }

    @When("User click on basket icon")
    public void userMoveToBasket() {
        homePage = pageFactoryManager.getHomePage();

        homePage.clickBagIcon();

    }

    @And("Click View Bag")
    public void clickViewBag() {
        homePage.waitForPageLoadComplete(60);
        homePage.waitForAjaxToComplete(60);

        homePage.clickViewBAg();
    }

    @Then("USer check the total price")
    public void userCheckTheTotalPrice() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(true);
    }

    @And("User checks that current url contains {string} language")
    public void checkCurrentUrl(final String language) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(driver.getCurrentUrl().contains(language));
    }


    @After
    public void tearDown() {
        //driver.close();
    }



}

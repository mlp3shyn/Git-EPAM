package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmokeTests extends BaseTest {


    private static final long DEFAULT_WAITING_TIME = 90;

    @Test
    public void testSignInWithWrongData(){

        getHomePage().clickSigInButton();
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getSignInPopUP().sendEmail();
        getSignInPopUP().sendPassword();
        Assert.assertTrue(getSignInPopUP().isEmailErrorDisplayed());
    }
    @Test
    public void checkSalesItems(){
        getHomePage().moveToSnowboardCategory();
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getSNBPage().clickSaleButton();
        Assert.assertTrue(getSNBPage().checkSalesItems());
    }
    @Test
    public void selectSNBBindings(){
        getHomePage().moveToSnowboardCategory();
        getSNBPage().moveSNBBindings();
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getSNBBindingsPage().selectOnlineItems();
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getSNBBindingsPage().selectBurtonBrand();
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getSNBBindingsPage().selectLSize();
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getSNBBindingsPage().selectBlackColor();
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getSNBBindingsPage().checkCorrectChosenItems();


    }
}

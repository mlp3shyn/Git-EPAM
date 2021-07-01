package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SnowBoardPage extends BasePage {

    public SnowBoardPage(WebDriver driver) {
        super(driver);
    }

    //Sale radio button //a/div[contains(text(), 'Sale')]
    @FindBy(xpath = "//a/div[contains(text(), 'Sale')]")
    private WebElement saleButton;

    @FindBy(xpath = "//span[@class='discount']")
    private List<WebElement> discountItems;

    @FindBy(xpath = "//div[@id='results-navigation-list']//a[@aria-label='Snowboard Bindings']")
    private WebElement snbBindings;


    public void clickSaleButton(){
        saleButton.click();
    }
    public void moveSNBBindings(){
        snbBindings.click();
    }

    public boolean checkSalesItems(){
        for (WebElement wb : discountItems){
            System.out.println(wb);
            if(!wb.isDisplayed()) return false;
        }
        return true;
    }
}

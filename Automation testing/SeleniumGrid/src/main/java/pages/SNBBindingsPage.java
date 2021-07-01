package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SNBBindingsPage extends BasePage{

    public SNBBindingsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a/div[contains(text(), 'Sale')]")
    private WebElement saleButton;

    @FindBy(xpath = "//a[@aria-label='Online']")
    private WebElement availabilityOnline;

    @FindBy(xpath = "//a[@aria-label='Burton']")
    private WebElement brandBurton;

    @FindBy(xpath = "//a[@aria-label='L']")
    private WebElement largeSize;

    @FindBy(xpath = "//a[@aria-label='Black']")
    private WebElement colorBlack;


    @FindBy(xpath = "//span[@class='product-thumb-title']")
    private List <WebElement> itemThumbs;

    public void selectOnlineItems(){
        availabilityOnline.click();
    }
    public void selectBurtonBrand(){
        brandBurton.click();
    }

    public void selectLSize(){
        largeSize.click();
    }

    public void selectBlackColor(){
        colorBlack.click();
    }
    public boolean checkCorrectChosenItems(){
        boolean result = true;
        for (WebElement wb : itemThumbs){
            if(! wb.getText().contains("Butron")) {
                result = false;
                break;
            }
            }return result;
    }

}

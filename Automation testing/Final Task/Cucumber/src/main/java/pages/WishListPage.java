package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage{
    public WishListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='itemCount_3vWat']")
    private WebElement itemCount;

    public String getItemCount(){
        return itemCount.getText();
    }

}

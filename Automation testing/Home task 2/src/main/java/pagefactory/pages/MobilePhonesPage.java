package pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobilePhonesPage extends BasePage{

    private String CATEGORY = "Накопичувач";
    public MobilePhonesPage(WebDriver drv) {
        super(drv);
    }

    @FindBy(xpath = "//div[@class = 'container']//div[@class='height brand-box'][1]")
    private WebElement smartPhones;

    @FindBy(xpath = "//div[@class='filter-wrapp']/p[contains(text(),'Накопичувач')]")
    private WebElement categoryHDD;

    @FindBy(xpath = "//div[@class='filter__items checkbox']//label[@for='fltr-nakopitel-16gb']/a")
    private WebElement categoryHDD16GB;

    @FindBy(xpath = "//div[@class = ' choose-config__right ']/span[@class='config__memory active ']")
    private WebElement fildHddCapacity;


    public void clickOnSmartphones() {
        smartPhones.click();
    }
    public void selectFilteredByHDD(){
        categoryHDD.click();
    }
    public void select16GBHDD(){
        categoryHDD16GB.click();
    }

}

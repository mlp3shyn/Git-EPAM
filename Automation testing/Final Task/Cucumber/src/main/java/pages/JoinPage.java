package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JoinPage extends BasePage{
    public JoinPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//fieldset//input[@type='email']")
    private WebElement email;

    @FindBy(xpath = "//fieldset//input[@name='FirstName']")
    private WebElement firstName;

    @FindBy(xpath = "//fieldset//input[@name='LastName']")
    private WebElement lastName;

    @FindBy(xpath = "//fieldset//input[@name='Password']")
    private WebElement password;

    @FindBy(xpath = "//fieldset//select[@name='BirthDay']//option[@value='3']")
    private WebElement BirthDay;

    @FindBy(xpath = "//fieldset//select[@name='BirthMonth']//option[@value='3']")
    private WebElement BirthMonth;

    @FindBy(xpath = "//fieldset//select[@name='BirthYear']//option[@value='1992']")
    private WebElement BirthYear;

    @FindBy(xpath = "//button[@data-text-all='Select All']")
    private WebElement selectAll;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement joinAsos;

    @FindBy(xpath = "//span[@class='qa-email-validation field-validation-valid']")
    private WebElement emailValidation;


    public void enterEmailAdress(final String emailAddress){
        email.sendKeys(emailAddress);
    }
    public void enterfirstName(final String fn){
        firstName.sendKeys(fn);
    }
    public void enterLastName(final String ln){
        lastName.sendKeys(ln);
    }

    public void enterPassword(final String pass){
        password.sendKeys(pass);
    }

    public void selectDateOfBirth(){
        BirthDay.click();
        waitForPageLoadComplete(20);
        BirthMonth.click();
        waitForPageLoadComplete(20);
        BirthYear.click();
    }

    public void clickSelectAll(){
        selectAll.click();
    }
    public void clickJoinAsos(){
        joinAsos.click();
    }
    public boolean checkIfErrorisDispaled(){
        return emailValidation.isDisplayed();
    }

}

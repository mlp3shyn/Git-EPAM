package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{
    public SignInPage(WebDriver driver) { super(driver); }

    @FindBy(xpath = "//input[@data-st-field='id-signIn-emailAddress']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@data-st-field='id-signIn-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//span[@id='EmailAddress-error']")
    private WebElement emailAddressError;

    @FindBy(xpath = "//div[@class='error-block']")
    private WebElement errorBlock;


    public void enterEmail(final String email){
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(final String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSignInButton(){
        signInButton.click();
    }

    public boolean ckeckEmailErrorVisability(){
        return emailAddressError.isDisplayed();
    }

    public boolean checkErrorBLockVisability(){return errorBlock.isDisplayed();     }


}

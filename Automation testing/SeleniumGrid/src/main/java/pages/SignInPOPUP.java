package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPOPUP extends BasePage {

    public SignInPOPUP(WebDriver driver) {
        super(driver); }
    private static final String EMAIL = "zaika@gmail@FM";
    private static final String PASSWORD = "zaika";

    @FindBy(xpath = "//div[@class='form-group']/input[@name='EmailAddress']")
    private WebElement inputEmail;

    @FindBy(xpath = "//div[@class='form-group']/input[@name='Password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//span[@id='EmailAddress-error']")
    private WebElement EmailAddressError;


    public void sendEmail(){
        inputEmail.sendKeys(EMAIL);
    }
    public void sendPassword(){
        inputPassword.sendKeys(PASSWORD);
    }
    public boolean isEmailErrorDisplayed(){
    return EmailAddressError.isDisplayed();
    }
}

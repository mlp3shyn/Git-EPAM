package TA.pr1;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoogleTest {
    @Test
    public void testGoogle(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driverChrome = new ChromeDriver();
        driverChrome.get("http://www.google.com/");

        WebElement search = driverChrome.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        search.sendKeys("Chrome Driver");
        search.submit();
    }


}

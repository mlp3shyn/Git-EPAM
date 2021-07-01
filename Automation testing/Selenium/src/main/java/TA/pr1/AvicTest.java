package TA.pr1;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;
import java.security.PublicKey;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertTrue;

public class AvicTest {
    private WebDriver chromeDriver;

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeMethod
    public void testsSetUp() {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://avic.ua/");
    }

    @Test(priority = 1)
    public void checkThatUrlContainsSearchWord() {
        chromeDriver.findElement(xpath("//input[@id='input_search']")).sendKeys("iPhone 11", Keys.ENTER);//вводим в поиск iPhone 11
        assertTrue(chromeDriver.getCurrentUrl().contains("query=iPhone"));//проверяем что урла содержит кверю
    }
    @Test
    public void checkIfLogoClickReturnToMainPage(){
        chromeDriver.navigate().to("https://avic.ua/ua/smart-chasy-samsung-galaxy-watch-active-2-40mm-rose-gold-aluminium-sm-r830nadaxsg-item");
        WebElement logo = chromeDriver.findElement(xpath("//a[contains(@class, 'mobile-logo')]"));
        chromeDriver.findElement(xpath("//div[@class='header-bottom__logo']/a")).click();
        Assert.assertEquals(chromeDriver.getCurrentUrl(),"https://avic.ua/ua");

    }
    @Test
    public void checkIfIteamAreSorted(){
        boolean result = false;
        chromeDriver.navigate().to("https://avic.ua/ua/smartfonyi");
        chromeDriver.findElement(xpath("//div[@class='category-top']/div[@class='sort-holder']//select/option[@value='pricedesc']")).click();
        List<WebElement> elements = chromeDriver.findElements(xpath("//div[@class='prod-cart__prise-new']"));
        Iterator<WebElement> iter = elements.iterator();
        WebElement current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if(Integer.parseInt(previous.getText().substring(0,4)) > Integer.parseInt(current.getText().substring(0,4))) result = true;
            previous = current;
        }
        Assert.assertEquals(result, true);
    }
    @Test
    public void chooseBy16GBMemory(){
        boolean result = false;
        chromeDriver.navigate().to("https://avic.ua/ua/smartfonyi");
        chromeDriver.findElement(xpath("//div[@class='filter-wrapp']/p[contains(text(),'Накопичувач')]")).click();
        chromeDriver.findElement(xpath("//div[@class='filter__items checkbox']//label[@for='fltr-nakopitel-16gb']/a")).click();
        List<WebElement> elements = chromeDriver.findElements(xpath("//div[@class = ' choose-config__right ']/span[@class='config__memory active ']"));
        for (WebElement we: elements) {
            System.out.println(Integer.parseInt(we.getText().substring(0,2)) == 16 );
            if(Integer.parseInt(we.getText().substring(0,2)) == 16 ) {
                System.out.println("in if");
                result = true;}   }
        Assert.assertEquals(result, true);
    }

    @Test
    public void checkOnDifferentLaguages(){
        // Сайт підтримує тільки одну мову
    }
    @AfterMethod
    public void tearDown() {
        chromeDriver.close();
    }
}

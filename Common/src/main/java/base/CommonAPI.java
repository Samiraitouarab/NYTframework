package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class CommonAPI {
    public WebDriver driver = null;

    @Parameters({"url"})
    @BeforeMethod
    public void setUp(String url){
        System.setProperty("webdriver.chrome.driver","/Users/mirouflyer/mirou-workspace/SamirFrameWork/Common/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate().to(url);
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void cleanUp(){
        driver.close();
    }

    public void findElementByXpath(String locator){
        driver.findElement(By.xpath(locator)).click();
    }



    public void findElementByxPathAndClick(String locator,String locator2,String keyword ){
        driver.findElement(By.xpath(locator)).click();
        driver.findElement(By.xpath(locator2)).click();

    }

    public void typeOnID(String locator, String value) {
        driver.findElement(By.id(locator)).sendKeys(value);
    }


}

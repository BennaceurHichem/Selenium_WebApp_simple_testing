package Exos1;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class TestClass {
  List<WebElement> brandList,carList,materialList,productList;
  WebElement carItem,actionItem,materialItem;
    int totalProductNumber;

    //declare the web Driver
    static WebDriver driver;


    //instantiate the driver
    @org.junit.Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();



    }
@Test
public void testOnWebsite() throws Exception{

        driver.get("https://www.ebay.com");

        carList = new ArrayList<WebElement>();
        brandList = new ArrayList<WebElement>();
        materialList = new ArrayList<WebElement>();






    WebElement categoryButton = driver.findElement(By.id("gh-shop-a"));
         categoryButton.click();




            WebElement kidToysLink  = driver.findElement(By.linkText("Kids toys"));
            kidToysLink.click();


            brandList =  driver.findElements(By.className("b-guidancecard__link"));
            actionItem=brandList.get(2);
            actionItem.click();


    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);




    carList = driver.findElements(By.className("b-guidancecard__link"));
            carItem = carList.get(1);
         carItem.click();


    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    materialList = driver.findElements(By.className("b-guidancecard__link"));
    materialItem =materialList.get(3);
    materialItem.click();




productList = driver.findElements(By.className("s-item"));
        totalProductNumber = productList.size();


    Assert.assertEquals(totalProductNumber,5);









































}

    //quit the driver connection after the test finished
    @org.junit.After
    public void tearDown() throws Exception {

        driver.quit();
    }
}
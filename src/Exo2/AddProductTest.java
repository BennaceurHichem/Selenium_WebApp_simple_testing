package Exo2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class AddProductTest {
    static WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void addProductTest() throws Exception{

        driver.get("https://www.ebay.com");

        WebElement inputSreach=driver.findElement(By.id("gh-ac"));
        inputSreach.sendKeys("shoes for men");

        inputSreach.submit();


        List<WebElement>shoesList=new ArrayList<WebElement>();

        shoesList=driver.findElements(By.className("s-item__title"));

        if(!shoesList.isEmpty())
        {
            WebElement shoes=shoesList.get(2);
            shoes.click();

        }


        Select colors = new Select(driver.findElement(By.id("msku-sel-1")));

        colors.selectByIndex(1);

        Select sizes = new Select(driver.findElement(By.id("msku-sel-2")));
        sizes.selectByIndex(1);

        WebElement addToCartBtn = driver.findElement(By.id("isCartBtn_btn"));
        addToCartBtn.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement totalPrice = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[4]/div/table/tr[4]/td[2]/span/span"));


        Assert.assertEquals("US $15.84",totalPrice.getText());


        ////*[@id="mainContent"]/div/div[4]/div/table/tr[4]/td[2]/span/span















    }
    @After
    public void tearDown() throws Exception {
        driver.close();




    }
}
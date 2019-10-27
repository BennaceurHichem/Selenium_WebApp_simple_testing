import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class TestClass {


//declare the web Driver
    static WebDriver driver;


    //instantiate the driver
    @org.junit.Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();



    }
@Test
public void testOnWebsite() throws Exception{

        driver.get("https://www.wikipedia.org");
        WebElement recherchInput = driver.findElement(By.id("searchInput"));
        recherchInput.sendKeys("Mutation testing");


        //select english a a language
          Select sel = new Select(driver.findElement(By.id("searchLanguage")));
          sel.selectByValue("en");

             recherchInput.submit();




             //set a wait time between pages
             driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


            WebElement header = driver.findElement(By.id("firstHeading"));
            String headerText = header.getText();

            Assert.assertEquals("Mutation testing",headerText);



            //WebElement submitBtn = driver.findElement(By.id)



    }

    //quit the driver connection after the test finished
    @org.junit.After
    public void tearDown() throws Exception {

        driver.quit();
    }
}
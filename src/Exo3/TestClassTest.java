package Exo3;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class TestClassTest {


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
        PageObject.driver = new ChromeDriver();
        PageObject.driver.get("http://www.ebay.com");

    }



    @Test
    public void mainTest() throws Exception{

            HomePage homePage = new HomePage(PageObject.driver);

            homePage.fillSearch("shoes for men");
            homePage.submitSearch();

        ShoesPage shoesPage = new ShoesPage(PageObject.driver);
        shoesPage.clickElementByIndex(0);

        ShoesInformationPage shoesInformationPage= new ShoesInformationPage(PageObject.driver);
    //y'a des chaussures qui n'ont pas de couleur, donc on evite de tester le champ de couleur



        //shoesInformationPage.selectColor(1);
        shoesInformationPage.selectSize(1);

        shoesInformationPage.clickaddToCart();

        AddToCartPage addToCartPage = new AddToCartPage(PageObject.driver);



        // le prix n'est pas stable
        Assert.assertEquals("US $15.84",addToCartPage.getTotalPrice());



    }
    @After
    public void tearDown() throws Exception {


        PageObject.driver.close();
    }
}
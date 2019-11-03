package Exo3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;

public class ShoesPage extends PageObject{

    @FindBy(className = "s-item__title") List<WebElement> shoesList;
    WebElement shoes;


    public ShoesPage(WebDriver driver) {
        super(driver);

    }





        public void clickElementByIndex(int index)
        {
            if(!shoesList.isEmpty())
            {
                shoes=shoesList.get(index);
                shoes.click();

            }
            else
            {
                System.out.println("no element ");
            }

        }





}

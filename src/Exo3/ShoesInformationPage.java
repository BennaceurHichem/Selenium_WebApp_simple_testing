package Exo3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class ShoesInformationPage extends PageObject{
    //y'a des chaussures qui n'ont pas de couleur, donc on essaye de tester le size seulement
    //@FindBy(id ="msku-sel-1" ) WebElement color;
    @FindBy(className ="msku-sel" ) WebElement size;
    @FindBy(id = "isCartBtn_btn") WebElement addToCartBtn;


    public ShoesInformationPage(WebDriver driver) {
        super(driver);
    }


    public void selectSize(int index ){
        Select sizes = new Select(this.size);
        sizes.selectByIndex(index);
    }


   /* public void selectColor(int index ){
        Select colors = new Select(this.color);
        colors.selectByIndex(index);
    }*/


   public void clickaddToCart(){
       addToCartBtn.click();
   }








}

package Exo3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    static WebDriver driver;

            public PageObject(WebDriver driver) {
                this.driver = driver;
                PageFactory.initElements(driver, this);

            }

}



package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends PageFactoryManager {
    public WebDriver driver;

    public BasePage (WebDriver driver){
        super(driver);

    }

    public String returnRandomFourDigit(){
        int randomPIN = (int)(Math.random()*9000)+1000;
        return String.valueOf(randomPIN);

    }

}

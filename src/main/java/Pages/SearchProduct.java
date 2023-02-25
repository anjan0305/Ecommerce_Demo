package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchProduct extends BasePage{
    public WebDriver driver;
     SearchProduct(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    private By account_header=By.xpath("//div[@class='header-links']//li[2]/a");

    public boolean isUserLogged(){
        boolean flag=false;
        if(driver.findElement(account_header).isDisplayed()){
            String log_out_text=driver.findElement(account_header).getText();
            if (log_out_text.equalsIgnoreCase("Log out")){
                flag=true;
        }}
        return flag;

    }



}

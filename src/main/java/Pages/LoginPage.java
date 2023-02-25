package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public WebDriver driver;

    LoginPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    private By login_link=By.xpath("//a[@class='ico-login']");
    private By username_box=By.id("Email");
    private By pwd_box=By.id("Password");
    private By login_text=By.xpath("//button[text()='Log in']");
    private By register_link=By.xpath("//a[@class='ico-register']");
    private By registration_status=By.xpath("//div[@class='result']");
    //  Your registration completed



    public SearchProduct signIn(String username,String password){
        driver.findElement(login_link).click();
        driver.findElement(username_box).sendKeys(username);
        driver.findElement(pwd_box).sendKeys(password);
        driver.findElement(login_text).click();
        return getInstance(SearchProduct.class);

    }

    public Register getRegistration(){
        driver.findElement(register_link).click();
       return getInstance(Register.class);
    }

    public String getRegistrationStatus(){
       return driver.findElement(registration_status).getText().trim();
    }

}

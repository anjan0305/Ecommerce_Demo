package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register extends BasePage{

    public WebDriver driver;
    public Register(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    private By firstName=By.id("FirstName");
    private By lastName=By.id("LastName");
    private By email_id=By.id("Email");
    private By pwd_box=By.id("Password");
    private By confirm_pwd=By.id("ConfirmPassword");
    private By register_button=By.id("register-button");

public LoginPage confirm_registration(String name,String pwd){
    String finalEmail=name+returnRandomFourDigit()+"@gmail.com";
    System.out.println(finalEmail);
    driver.findElement(firstName).sendKeys(name);
    driver.findElement(lastName).sendKeys(name);
    driver.findElement(email_id).sendKeys(finalEmail);
    driver.findElement(pwd_box).sendKeys(pwd);
    driver.findElement(confirm_pwd).sendKeys(pwd);
    driver.findElement(register_button).click();
    return getInstance(LoginPage.class);
}



}

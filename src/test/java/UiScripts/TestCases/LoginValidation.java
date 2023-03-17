package UiScripts.TestCases;
import Pages.LoginPage;
import Pages.SearchProduct;
import UiScripts.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginValidation extends BaseTest {
    //public WebDriver driver;
    public BaseTest baseTest;

    @Test
    public void userRegistrationTest(){
        System.out.println("Registration test");
        pages.getInstance(LoginPage.class)
                .getRegistration()
                .confirm_registration(environment.getProperty("name"),environment.getProperty("registration_pwd") );
        Assert.assertEquals(pages.getInstance(LoginPage.class).getRegistrationStatus(),"Your registration completed","Registration is not succesful");
    }





}

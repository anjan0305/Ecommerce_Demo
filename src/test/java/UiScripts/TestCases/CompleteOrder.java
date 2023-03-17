package UiScripts.TestCases;

import Pages.LoginPage;
import UiScripts.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompleteOrder extends BaseTest {
    @Test
    public void userRegistration3rdTest(){
        System.out.println("Registration test3");
        pages.getInstance(LoginPage.class)
                .getRegistration()
                .confirm_registration(environment.getProperty("name"),environment.getProperty("registration_pwd") );
        Assert.assertEquals(pages.getInstance(LoginPage.class).getRegistrationStatus(),"Your registration completed","Registration is not succesful");
    }
}
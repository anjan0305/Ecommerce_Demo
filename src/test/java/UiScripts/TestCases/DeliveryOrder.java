package UiScripts.TestCases;

import Pages.LoginPage;
import UiScripts.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeliveryOrder extends BaseTest {


    @Test
    public void userRegistrationFourthTest(){
        System.out.println("Registration test4");
        pages.getInstance(LoginPage.class)
                .getRegistration()
                .confirm_registration(environment.getProperty("name"),environment.getProperty("registration_pwd") );
        Assert.assertEquals(pages.getInstance(LoginPage.class).getRegistrationStatus(),"Your registration completed","Registration is not succesful");
    }



}

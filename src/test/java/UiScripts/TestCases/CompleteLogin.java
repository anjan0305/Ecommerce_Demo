package UiScripts.TestCases;

import Pages.LoginPage;
import Pages.SearchProduct;
import UiScripts.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompleteLogin extends BaseTest {
    @Test
    public void loginTest(){
        System.out.println("Login test");
        pages.getInstance(LoginPage.class)
                .signIn(environment.getProperty("username"),environment.getProperty("password") );
        Assert.assertTrue(pages.getInstance(SearchProduct.class).isUserLogged(),"User is not logged on succesfully");
    }
}

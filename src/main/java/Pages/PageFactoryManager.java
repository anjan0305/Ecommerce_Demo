package Pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
    public WebDriver driver;
    public PageFactoryManager(WebDriver driver){
        this.driver=driver;
    }

    public <TPage extends BasePage> TPage getInstance(Class<TPage>pageClass){
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }




}

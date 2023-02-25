package UiScripts;

import Pages.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public abstract class BaseTest {
    public WebDriver driver;
    public Properties global;
    public Properties environment;
    public PageFactoryManager pages;

    public BaseTest() {
        try {
            FileInputStream fis = new FileInputStream("C:\\Selenium Frameworks\\OpenCartAutomation\\src\\test\\java\\Resources\\Global.properties");
            FileInputStream fis1=new FileInputStream("C:\\Selenium Frameworks\\OpenCartAutomation\\src\\test\\java\\Environments\\F-tier.properties");

            global=new Properties();
            environment=new Properties();
            global.load(fis);
            environment.load(fis1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void InitializationDriver() {
        System.out.println("Before test");

        if (global.getProperty("Run_Mode").equalsIgnoreCase("grid")) {
               //implement the grid code
            } else if (global.getProperty("Run_Mode").equalsIgnoreCase("saucelabs")){
                //implement the saucelabs code
            } else {
                switch (global.getProperty("browser")) {
                    case ("Chrome"): {
                        System.setProperty("webdriver.chrome.driver", "C:\\Selenium Frameworks\\OpenCartAutomation\\drivers\\chromedriver.exe");
                        driver=new ChromeDriver();
                        break;
                    }
                    case ("Edge"): {
                        System.setProperty("webdriver.edge.driver", "C:\\Selenium Frameworks\\OpenCartAutomation\\drivers\\msedgedriver.exe");
                        driver=new EdgeDriver();
                        break;

                    }
                    default: {

                    }
                }
            }



        driver.get(environment.getProperty("Application_url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        pages=new PageFactoryManager(driver);
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        System.out.println("After test");
        driver.quit();
    }


}

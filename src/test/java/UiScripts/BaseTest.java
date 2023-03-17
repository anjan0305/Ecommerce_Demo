package UiScripts;

import Pages.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

public abstract class BaseTest {
    public WebDriver driver;
    public Properties global;
    public Properties environment;
    public String HOST_NAME;

    public PageFactoryManager pages;

    public BaseTest() {
        HOST_NAME = System.getProperty("HOST_NAME");
        try {


            String user_location = System.getProperty("user.dir");
            if (user_location.contains("target")) {
                user_location = "C:\\Selenium Frameworks\\OpenCartAutomation";
            }

            FileInputStream fis = new FileInputStream(user_location + "//Environments//Global.properties");
            FileInputStream fis1 = new FileInputStream(user_location + "//Environments//F-tier.properties");
            System.out.println(System.getProperty("user.dir") + "////Environments//Global.properties");
            global = new Properties();
            environment = new Properties();
            global.load(fis);
            environment.load(fis1);
            System.out.println(System.getProperty("user.dir") + "////Environments//Global.properties");
            System.out.println(global.getProperty("Run_Mode"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @BeforeMethod(alwaysRun = true)
    public void InitializationDriver() throws MalformedURLException {
        System.out.println("Before test");

        if (global.getProperty("Run_Mode").equalsIgnoreCase("grid")) {
            if (HOST_NAME == null) {
                HOST_NAME = global.getProperty("HOST_NAME");
            }
            URL url = new URL("http://" + HOST_NAME + ":4444");
            switch (global.getProperty("browser")) {
                case ("Chrome"): {
                    ChromeOptions browserOptions = new ChromeOptions();

                    System.out.println("<<<<<<<<<<<<<<" + HOST_NAME);


                    driver = new RemoteWebDriver(url, browserOptions);
                    break;
                }
                case ("Edge"): {
                    EdgeOptions browserOptions = new EdgeOptions();

                    driver = new RemoteWebDriver(url, browserOptions);
                    break;
                }
                default: {
                    ChromeOptions browserOptions = new ChromeOptions();
                    driver = new RemoteWebDriver(url, browserOptions);
                    break;
                }

            }

        } else if (global.getProperty("Run_Mode").equalsIgnoreCase("saucelabs")) {
            switch (global.getProperty("browser")) {
                case ("Chrome"): {
                    System.out.println("Inside the required set");
                    ChromeOptions browserOptions = new ChromeOptions();
                    browserOptions.setPlatformName("Windows 10");
                    browserOptions.setBrowserVersion("latest");
                    Map<String, Object> sauceOptions = new HashMap<>();
                    sauceOptions.put("build", "<your build id>");
                    sauceOptions.put("name", "OpenCartAutomation");
                    browserOptions.setCapability("sauce:options", sauceOptions);
                    URL url = new URL("https://oauth-anjanmitra03-23781:97b34f61-2876-4293-8948-412bcd140347@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                    driver = new RemoteWebDriver(url, browserOptions);
                    break;
                }
                case ("Edge"): {
                    EdgeOptions browserOptions = new EdgeOptions();
                    browserOptions.setPlatformName("Windows 11");
                    browserOptions.setBrowserVersion("latest");
                    Map<String, Object> sauceOptions = new HashMap<>();
                    sauceOptions.put("build", "<your build id>");
                    sauceOptions.put("name", "<your test name>");
                    browserOptions.setCapability("sauce:options", sauceOptions);

                    URL url = new URL("https://oauth-anjanmitra03-23781:97b34f61-2876-4293-8948-412bcd140347@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                    driver = new RemoteWebDriver(url, browserOptions);
                    break;

                }
                default: {

                }
            }
        } else {
            switch (global.getProperty("browser")) {
                case ("Chrome"): {
                    System.setProperty("webdriver.chrome.driver", "C:\\Selenium Frameworks\\OpenCartAutomation\\drivers\\chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                }
                case ("Edge"): {
                    System.setProperty("webdriver.edge.driver", "C:\\Selenium Frameworks\\OpenCartAutomation\\drivers\\msedgedriver.exe");
                    driver = new EdgeDriver();
                    break;

                }
                default: {

                }
            }
        }


        driver.get(environment.getProperty("Application_url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        pages = new PageFactoryManager(driver);
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println("After test");
        if (driver != null) {
            driver.quit();
        }

    }


}

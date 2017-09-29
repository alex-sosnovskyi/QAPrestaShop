package ua.i.pl.sosnovskyi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import ua.i.pl.sosnovskyi.utils.Properties;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by A Sosnovskyi on 29.09.2017.
 */
public abstract class BaseDriver {
    private static WebDriver getDriver(){
String browser= Properties.getBrowser();
        switch (browser){
            case "chrome":{
                String key = System.getProperty("webdriver.chrome.driver");
                String path=new File(BaseDriver.class.getResource("/chromedriver.exe").getFile()).getPath();
                if (key == null) {
                    System.setProperty("webdriver.chrome.driver", path);
                }
                return new ChromeDriver();

            }
            case "gecko":{
                String key = System.getProperty("webdriver.gecko.driver");
                String path=new File(BaseDriver.class.getResource("/geckodriver.exe").getFile()).getPath();
                if (key == null) {
                    System.setProperty("webdriver.gecko.driver", path);
                }
                return new FirefoxDriver();

            }
            case "ie":{
                String key = System.getProperty("webdriver.ie.driver");
                String path= new File(BaseDriver.class.getResource("/IEDriverServer.exe").getFile()).getPath();
                if (key == null) {
                    System.setProperty("webdriver.ie.driver", path);

                }
                return new InternetExplorerDriver();
            }
            default:{
                throw  new RuntimeException("Wrong browser name");
            }
        }

    }

    public static WebDriver getConfiguredDriver(){
        WebDriver driver=getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }
    public static void quitDriver(WebDriver driver){
        driver.quit();
    }
}

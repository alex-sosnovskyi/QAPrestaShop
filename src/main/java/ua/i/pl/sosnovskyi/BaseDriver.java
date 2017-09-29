package ua.i.pl.sosnovskyi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by A Sosnovskyi on 29.09.2017.
 */
public abstract class BaseDriver {
    public WebDriver getDriver(String arg){
        WebDriver result=null;
        switch (arg){
            case "chrome":{
                result= new ChromeDriver();
                break;
            }
            case "firefox":{
                result= new FirefoxDriver();
                break;
            }
            case "ie":{
                result= new InternetExplorerDriver();
            }
        }
        return result;
    }
}

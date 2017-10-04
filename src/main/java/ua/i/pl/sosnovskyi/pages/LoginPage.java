package ua.i.pl.sosnovskyi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by A Sosnovskyi on 30.09.2017.
 */
public class LoginPage {
    private EventFiringWebDriver driver;
    private WebElement loginForm;
    private By email = By.id("email");
    private By passwrd = By.id("passwd");
    private By submit = By.name("submitLogin");

    public LoginPage(EventFiringWebDriver driver) {
        if (driver==null){
            throw new RuntimeException("Driver is not available!!!");
        }
        this.driver=driver;
    }
    public void openPage(String url){
        if(url==null){
            throw new RuntimeException("Page is null!!!");
        }
        try {
            driver.navigate().to(url);
        } catch (Exception e) {
           throw new RuntimeException("url is incorrect!!!");
        }

    }
    public void fillEmailInput(String login){
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.elementToBeSelected(By.id("login_form")));
        try {
            loginForm = driver.findElement(By.id("login_form"));
        } catch (Exception e) {
            throw new RuntimeException("login_form not found");
        }
        if (loginForm==null){
            throw new RuntimeException("login form is not available!!!");
        }
//        System.out.println(driver);
//        System.out.println(email);
        WebElement element = loginForm.findElement(email);
//        System.out.println(element);
        element.sendKeys(login);
    }
    public void fillPassInput(String password){
        if (loginForm==null){
            throw new RuntimeException("login form is not available!!!");
        }
        driver.findElement(passwrd).sendKeys(password);
    }

    public void clickLoginButton(){
        if (loginForm==null){
            throw new RuntimeException("login form is not available!!!");
        }
        driver.findElement(submit).click();
    }
}

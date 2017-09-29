package ua.i.pl.sosnovskyi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by A Sosnovskyi on 30.09.2017.
 */
public class LoginPage {
    private WebDriver driver;
    private WebElement loginForm;
    private By email = By.name("email");
    private By passwrd = By.name("passwd");
    private By submit = By.name("submitLogin");

    public LoginPage(WebDriver driver) {
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
            loginForm = driver.findElement(By.id("login_form"));
        } catch (Exception e) {
           throw new RuntimeException("url is incorrect!!!");
        }
    }
    public void fillEmailInput(String login){
        if (loginForm==null){
            throw new RuntimeException("login form is not available!!!");
        }
        loginForm.findElement(email).sendKeys(login);
    }
    public void fillPassInput(String password){
        if (loginForm==null){
            throw new RuntimeException("login form is not available!!!");
        }
        loginForm.findElement(passwrd).sendKeys(password);
    }

    public void clickLoginButton(){
        if (loginForm==null){
            throw new RuntimeException("login form is not available!!!");
        }
        loginForm.findElement(submit).click();
    }
}

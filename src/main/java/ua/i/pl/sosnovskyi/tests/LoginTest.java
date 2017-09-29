package ua.i.pl.sosnovskyi.tests;

import org.openqa.selenium.WebDriver;
import ua.i.pl.sosnovskyi.BaseDriver;
import ua.i.pl.sosnovskyi.pages.LoginPage;
import ua.i.pl.sosnovskyi.utils.Properties;

/**
 * Created by A Sosnovskyi on 30.09.2017.
 */
public class LoginTest extends BaseDriver {
    private static String login = "webinar.test@gmail.com";
    private static String password = "Xcg7299bnSmMuRLp9ITw";

    public static void main(String[] args) {
        WebDriver driver=getConfiguredDriver();
        LoginPage page=new LoginPage(driver);
        page.openPage(Properties.getBaseAdminUrl());
        page.fillEmailInput(login);
        page.fillPassInput(password);
        page.clickLoginButton();
        quitDriver(driver);
    }
}

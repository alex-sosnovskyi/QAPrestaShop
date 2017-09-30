package ua.i.pl.sosnovskyi.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.i.pl.sosnovskyi.pages.DashbordPage;
import ua.i.pl.sosnovskyi.pages.LoginPage;
import ua.i.pl.sosnovskyi.utils.Properties;
import ua.i.pl.sosnovskyi.BaseDriver;

/**
 * Created by Алена on 30.09.2017.
 */
public class LogInOutTest extends BaseDriver {
    private static String login = "webinar.test@gmail.com";
    private static String password = "Xcg7299bnSmMuRLp9ITw";
    private static WebDriver driver;

    public static void main(String[] args) {
        driver = getConfiguredDriver();
        LoginPage page = new LoginPage(driver);
        page.openPage(Properties.getBaseAdminUrl());
        page.fillEmailInput(login);
        page.fillPassInput(password);
        page.clickLoginButton();
        DashbordPage dashbordPage = new DashbordPage(driver);
        dashbordPage.adminIconClick();
        dashbordPage.logOutClick();
        quitDriver(driver);
    }
}

package ua.i.pl.sosnovskyi.tests;

import org.openqa.selenium.WebDriver;
import ua.i.pl.sosnovskyi.BaseDriver;
import ua.i.pl.sosnovskyi.pages.DashbordPage;
import ua.i.pl.sosnovskyi.pages.LoginPage;
import ua.i.pl.sosnovskyi.utils.Properties;

/**
 * Created by Алена on 30.09.2017.
 */
public class MainMenuTest extends BaseDriver {
    private static String login = "webinar.test@gmail.com";
    private static String password = "Xcg7299bnSmMuRLp9ITw";
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = getConfiguredDriver();
        LoginPage page = new LoginPage(driver);
        page.openPage(Properties.getBaseAdminUrl());
        page.fillEmailInput(login);
        page.fillPassInput(password);
        page.clickLoginButton();
        DashbordPage dashbordPage = new DashbordPage(driver);
        for(int i=0; i<3; i++){
            dashbordPage.menuItemClick();
            System.out.println(driver.getTitle());
            driver.navigate().back();
        }

        Thread.sleep(10000);

//        dashbordPage.adminIconClick();
//        dashbordPage.logOutClick();
        quitDriver(driver);
    }
}

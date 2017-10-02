package ua.i.pl.sosnovskyi.tests;

import org.openqa.selenium.WebDriver;
import ua.i.pl.sosnovskyi.BaseDriver;
import ua.i.pl.sosnovskyi.pages.DashbordPage;
import ua.i.pl.sosnovskyi.pages.LoginPage;
import ua.i.pl.sosnovskyi.utils.Properties;

/**
 * Created by  A Sosnovskyi on 30.09.2017.
 */
public class MainMenuTest extends BaseDriver {
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
        System.out.println(driver.getTitle());
        int length = dashbordPage.menuItemBuild() - 1;
        for (int i = 0; i < length; i++) {
            dashbordPage.menuItemClick(i);
            String openedPage = driver.getTitle();
            System.out.println(openedPage);
            driver.navigate().refresh();
            String refreshedPage = driver.getTitle();
            System.out.println("Is the same page? - " + openedPage.equals(refreshedPage));
            if(i!=0){
                driver.navigate().back();
            }

        }
        dashbordPage.adminIconClick();
        dashbordPage.logOutClick();
        quitDriver(driver);
    }
}

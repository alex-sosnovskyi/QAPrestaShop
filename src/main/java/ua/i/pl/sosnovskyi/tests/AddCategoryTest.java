package ua.i.pl.sosnovskyi.tests;

import org.openqa.selenium.WebDriver;
import ua.i.pl.sosnovskyi.BaseDriver;
import ua.i.pl.sosnovskyi.pages.*;
import ua.i.pl.sosnovskyi.utils.Direction;
import ua.i.pl.sosnovskyi.utils.Properties;
import ua.i.pl.sosnovskyi.utils.Sorte;

import static java.lang.System.out;

/**
 * Created by A Sosnovskyi on 01.10.2017.
 */
public class AddCategoryTest extends BaseDriver {
    private static String login = "webinar.test@gmail.com";
    private static String password = "Xcg7299bnSmMuRLp9ITw";
    private static WebDriver driver;
    private static  String newCategory="newCategoryTest2";
    public static void main(String[] args) throws InterruptedException {
        driver = getConfiguredDriver();
        LoginPage page = new LoginPage(driver);
        page.openPage(Properties.getBaseAdminUrl());
        page.fillEmailInput(login);
        page.fillPassInput(password);
        page.clickLoginButton();
        DashbordPage dashbordPage = new DashbordPage(driver);
        out.println(driver.getTitle());
        dashbordPage.menuItemBuild();
        dashbordPage.submenuItemClick(1, 2); // пункт меню -пункт субменю
        out.println(driver.getTitle());
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        categoriesPage.addcategoryClick();
        AddCategoryPage addCategoryPage = new AddCategoryPage(driver);
        addCategoryPage.fillCategoryForm(newCategory);
        addCategoryPage.categorySubmit();
        boolean isAlertPresent = categoriesPage.isCategoryCreated();
        System.out.println("Is category created? "+isAlertPresent);
        categoriesPage.categoryByNameFilter(Sorte.NAME, Direction.DOWN);
        categoriesPage.isCategoryPresent(newCategory);
        //TODO
        Thread.sleep(10000);
//        dashbordPage.adminIconClick();
//        dashbordPage.logOutClick();
        quitDriver(driver);
    }
}

package ua.i.pl.sosnovskyi.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ua.i.pl.sosnovskyi.BaseDriver;
import ua.i.pl.sosnovskyi.pages.*;
import ua.i.pl.sosnovskyi.utils.Direction;
import ua.i.pl.sosnovskyi.utils.Properties;
import ua.i.pl.sosnovskyi.utils.Sorte;

import static java.lang.System.out;

/**
 * Created by A Sosnovskyi on 01.10.2017.
 * * Лекция 3. Домашнее задание
  На основе примеров из лекции создать Maven проект и подключить к нему библиотеку Selenium.
 https://bitbucket.org/qatestlab_automation/lecture-3
  Разработать скрипт в виде обычного приложения (с использованием метода main():
 1. Войти в Админ Панель
 2. Выбрать пункт меню Каталог -> категории и дождаться загрузки страницы управления категориями.
 3. Нажать «Добавить категорию» для перехода к созданию новой категории.
 4. После загрузки страницы ввести название новой категории и сохранить изменения. На странице управления категориями должно появиться
 сообщениеоб успешном создании категории.
 5. Отфильтровать таблицу категорий по имени и дождаться там появления записи созданной категории.
 Примечания: В процессе разработки следует не забывать о том, что, возможно, потребуется описывать ожидания для корректной отработки
 скрипта (ожидание загрузки необходимой страницы и ее содержимого, ожидание видимости подпунктов главного меню после наведения курсора и т.п.)
 Для доступа в Админ Панель используйте следующие данные:
 Адрес: http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/
 Логин: webinar.test@gmail.com
 Пароль: Xcg7299bnSmMuRLp9ITw
  Дополнительно необходимо описать логгер, который будет выводить в консоль базовые действия драйвера в процессе выполнения
 скрипт (переход на страницу, поиск элементов, клики по элементам). Самый простой способ описания логгера – использовать
 свою реализацию WebDriverEventListener.
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

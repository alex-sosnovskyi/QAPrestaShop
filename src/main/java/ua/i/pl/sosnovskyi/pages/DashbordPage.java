package ua.i.pl.sosnovskyi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Алена on 30.09.2017.
 */
public class DashbordPage {
    private WebDriver driver;
    private WebElement userMenu;
    private By dropDownHref = By.tagName("a");
    private By logOutIcon = By.id("header_logout");
    private static int index = 1;
    private By menu = By.className("menu");
private List<WebElement> menuList;
    private int menuSize;
    //    private By logOut = By.id("");
    public DashbordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void adminIconClick() {
        userMenu = driver.findElement(By.id("employee_infos"));
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(dropDownHref));
        userMenu.findElement(dropDownHref).click();
    }

    public void logOutClick() {
        userMenu.findElement(logOutIcon).click();
    }

    private void menuItemBuild() {
     WebElement element=   driver.findElement(menu);
        menuList= element.findElements(By.cssSelector(".menu>li.maintab"));
        menuSize=menuList.size();
    }

    public void menuItemClick(){

            menuItemBuild();

        menuList.get(index).click();
        index++;
    }
}

package ua.i.pl.sosnovskyi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by  A Sosnovskyi on 30.09.2017.
 */
public class DashbordPage {
    private WebDriver driver;
    private WebElement userMenu;
    private By dropDownHref = By.tagName("a");
    private By logOutIcon = By.id("header_logout");
    private static int index = 1;
    private By menu = By.className("menu");
    private By hasSubMenuSelector = By.cssSelector("li.has_submenu");
    private List<WebElement> menuList;
    private List<WebElement> hasSubMenu;
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

    public int menuItemBuild() {
        WebElement element = driver.findElement(menu);
        menuList = element.findElements(By.cssSelector(".menu>li.maintab"));
        menuSize = menuList.size();
        return new Integer(menuSize);
    }

    public void menuItemClick(int index) {
        menuItemBuild();
        menuList.get(index).click();
        // index++;
    }

    public void submenuItemClick(int menuIndex, int submenuIndex) {
        if(menuIndex>menuSize-1){
            throw new RuntimeException("menuIndex>menuSize");
        }
        hasSubMenu = driver.findElements(hasSubMenuSelector);
        WebElement menuElement = hasSubMenu.get(menuIndex);
//        System.out.println("menuElement "+menuElement);
        List<WebElement> currentSubmenu = menuElement.findElements(By.cssSelector("li>a"));
        if(submenuIndex>currentSubmenu.size()-1){
            throw new RuntimeException("submenuIndex>subMenuSize");
        }
        WebElement currentSubMenuItem=currentSubmenu.get(submenuIndex);
//        System.out.println("currentMenuItem "+currentSubMenuItem.getAttribute("href"));
        JavascriptExecutor executor=(JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", currentSubMenuItem);
    }
}

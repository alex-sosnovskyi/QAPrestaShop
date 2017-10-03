package ua.i.pl.sosnovskyi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.i.pl.sosnovskyi.utils.Direction;
import ua.i.pl.sosnovskyi.utils.Sorte;

import java.util.List;

/**
 * Created by A Sosnovskyi on 01.10.2017.
 */
public class CategoriesPage {
    private WebDriver driver;
    private By addCategorySelector = By.id("page-header-desc-category-new_category");
    private By alertSelector = By.cssSelector("div.alert:first-child");

    public CategoriesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addcategoryClick() {
        WebElement addHref = driver.findElement(addCategorySelector);
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(addHref));
        addHref.click();
    }

    public boolean isCategoryCreated() {
        WebElement alert = driver.findElement(alertSelector);
        if (alert != null) {
            return true;
        }
        return false;
    }

    public void categoryByNameFilter(Sorte type, Direction direction) {
        List<WebElement> sorteOptionsElements = driver.findElements(By.cssSelector("span.title_box"));
        switch (type) {
            case ID: {
                WebElement element = sorteOptionsElements.get(0);
                //TODO
                break;
            }
            case NAME: {
                WebElement element = sorteOptionsElements.get(1);
                switch (direction) {
                    case UP: {
                        element.findElement(By.cssSelector("a:last-child")).click();
                        System.out.println("UP sorte clicked");
                        break;
                    }
                    case DOWN: {
                        element.findElement(By.cssSelector("a:first-child")).click();
                        System.out.println("DOWN sorte clicked");
                        break;
                    }
                }
            }
            case DISCRIBE: {
                WebElement element = sorteOptionsElements.get(2);
                //TODO
                break;
            }
            case POSITION: {
                WebElement element = sorteOptionsElements.get(3);
                //TODO
                break;
            }
            case SHOW: {
                WebElement element = sorteOptionsElements.get(4);
                //TODO
                break;
            }
        }

    }

    public void isCategoryPresent(String category) {
        List<WebElement> tableSells = driver.findElements(By.cssSelector("td.pointer"));
        for (WebElement element : tableSells) {
           String text= element.getText();
            if(text.equals(category)){
                System.out.println("Category present");
            }
        }

    }
}


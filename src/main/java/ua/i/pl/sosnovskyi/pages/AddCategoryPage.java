package ua.i.pl.sosnovskyi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by A Sosnovskyi on 02.10.2017.
 */
public class AddCategoryPage {
    private WebDriver driver;
    private By addFormSelector = By.id("category_form");
    private By categorynameInputSelector = By.id("name_1");
    private By saveButtonSelector = By.id("category_form_submit_btn");

    private WebElement addForm;
    private WebElement categorynameInput;

    public AddCategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillCategoryForm(String categoryName) {
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.elementSelectionStateToBe(addFormSelector, false));
        addForm = driver.findElement(addFormSelector);
        categorynameInput = addForm.findElement(categorynameInputSelector);
        categorynameInput.sendKeys(categoryName);
    }

    public void categorySubmit() {
        WebElement saveButton = addForm.findElement(saveButtonSelector);
        saveButton.click();
    }


}

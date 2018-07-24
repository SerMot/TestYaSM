package ru.Ya;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.get("https://ya.ru/");
    }

    public WebDriver driver;


    @FindBy(css = "input[id='text']")
    private WebElement weatherField;

    @FindBy(css = "button[type='submit']")
    private WebElement findButton;

    @FindBy(css = "li[data-cid=\"0\"] div[class='organic__url-text']")
    private WebElement weatherLink;

    public void navigate(String URL) {
    driver.get(URL);
    System.out.println("Переход на страницу: " + URL);
    }

    public void inputWeatherField(String text ) {
        weatherField.clear();
        weatherField.sendKeys(text);
    }

    public void clickFindButton() {
        findButton.click();
    }

    public String getWeatherLink() {
        String takeWeatherLink  = weatherLink.getText();
        return takeWeatherLink;
    }

}

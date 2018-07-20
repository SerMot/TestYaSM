package ru.Ya.Test;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class FirstTest extends ru.Ya.CreateCloseDriver {

    @Test
    public void checkTest() {

        driver.get("https://ya.ru/");
        mainPage.inputWeatherField("Погода Пенза");
        mainPage.clickFindButton();

        String actualString = mainPage.getWeatherLink();
        assertTrue(actualString.contains("Погода"));
    }
}

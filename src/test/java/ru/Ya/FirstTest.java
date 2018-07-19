package ru.Ya;     
        import org.testng.annotations.Test;
        import static org.testng.Assert.assertTrue;

public class FirstTest extends CreateCloseDriver {

    @Test
    public void checkTest() {
        mainPage.inputWeatherField("Погода Пенза");
        mainPage.clickFindButton();

        String actualString = mainPage.getWeatherLink();
        assertTrue(actualString.contains("Погода"));
    }
}

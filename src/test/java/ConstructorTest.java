import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.HomePage;

import static Api.Urls.BASE_URI;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConstructorTest {
    private DriverRule driverRule = new DriverRule();

    @Rule
    public DriverRule driver = new DriverRule();


    @Test
    @DisplayName("Переход к разделу Булки")
    @Description("Go to the bun section")
    public void GoToTheBunSectionTest() {
        WebDriver driver = driverRule.getDriver();
        driver.get(BASE_URI);

        new HomePage(driver)
                .clickFillingsTab();
        Boolean actual = new HomePage(driver)
                .clickBunsTab()
                .isBunsIsDisplayed();


        assertThat("Не перешел в раздел Булки", actual);
    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    @Description("Go to the sauces section")
    public void GoToTheSaucesSectionTest() {
        WebDriver driver = driverRule.getDriver();
        driver.get(BASE_URI);

        Boolean actual = new HomePage(driver)
                .clickSaucesTab()
                .isSaucesIsDisplayed();

        assertThat("Не перешел в раздел Соусы", actual);
    }

    @Test
    @DisplayName("Переход к разделу Начинки")
    @Description("Go to the fillings section")
    public void GoToTheFillingsSectionTest() {
        WebDriver driver = driverRule.getDriver();
        driver.get(BASE_URI);

        Boolean actual = new HomePage(driver)
                .clickFillingsTab()
                .isFillingsIsDisplayed();


        assertThat("Не перешел в раздел Начинки", actual);
    }

}

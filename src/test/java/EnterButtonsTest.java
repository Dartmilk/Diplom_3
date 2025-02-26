import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.LoginFormPage;
import pom.HomePage;

import static Api.Urls.BASE_URI;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class EnterButtonsTest extends TemplateData {

    private DriverRule driverRule = new DriverRule();

    @Rule
    public DriverRule driver = new DriverRule();


    @Test
    @DisplayName("Войти профиль по кнопке «Войти в аккаунт» на главной странице")
    @Description("Log in using the log in account button on the main page")
    public void LogInUsingLogInAccountButtonOnTheMainPageTest() {
        WebDriver driver = driverRule.getDriver();
        driver.get(BASE_URI);

        new HomePage(driver)
                .clickLogInAccountButton()
                .signInUser(user.getEmail(), user.getPassword());

        String actual = new HomePage(driver).getBasketButtonText();
        assertThat("Ожидается надпись «Оформить заказ» на кнопке в корзине", actual, equalTo("Оформить заказ"));
    }

    @Test
    @DisplayName("Войти в профиль по кнопке «Личный кабинет»")
    @Description("Sign in with button personal account")
    public void signInWithButtonPersonalAccountTest() {
        WebDriver driver = driverRule.getDriver();
        driver.get(BASE_URI);

        new HomePage(driver)
                .clickPersonalAccountButtonAuthUser();

        new LoginFormPage(driver)
                .clickSignInButton()
                .signInUser(user.getEmail(), user.getPassword());

        String actual = new HomePage(driver).getBasketButtonText();
        assertThat("Ожидается надпись «Оформить заказ» на кнопке в корзине", actual, equalTo("Оформить заказ"));
    }


    @Test
    @DisplayName("Войти в профиль по «Войти» в форме регистрации")
    @Description("Sign in with button on registration page")
    public void singInWithButtonOnRegistrationPageTest() {
        WebDriver driver = driverRule.getDriver();
        driver.get(BASE_URI);

        new HomePage(driver)
                .clickPersonalAccountButton();
        new LoginFormPage(driver)
                .clickRegistrationButton()
                .clickSignInButton()
                .signInUser(user.getEmail(), user.getPassword());

        String actual = new HomePage(driver).getBasketButtonText();
        assertThat("Ожидается надпись «Оформить заказ» на кнопке в корзине", actual, equalTo("Оформить заказ"));
    }


    @Test
    @DisplayName("Войти в профиль по «Войти» в форме восстановления пароль")
    @Description("Sing in with button on forgot password page")
    public void singInWithButtonOnForgotPasswordPageTest() {
        WebDriver driver = driverRule.getDriver();
        driver.get(BASE_URI);

        new HomePage(driver)
                .clickPersonalAccountButton();
        new LoginFormPage(driver)
                .clickForgotPasswordButton();
        new LoginFormPage(driver)
                .clickSignInButtonRememberedPassword()
                .signInUser(user.getEmail(), user.getPassword());

        String actual = new HomePage(driver).getBasketButtonText();
        assertThat("Ожидается надпись «Оформить заказ» на кнопке в корзине", actual, equalTo("Оформить заказ"));
    }

}


package pom;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@AllArgsConstructor
public class LoginFormPage {

    private String someParam;
    private  WebDriver driver;

    //Кнопка "Зарегистрироваться"
    private final By theRegistrationButton = By.xpath(".//a[(@class = 'Auth_link__1fOlj' and text()= 'Зарегистрироваться')]");

    //Кнопка "Войти"
    private final By theSignInButton = By.xpath(".//button[text()='Войти']");

    //Кнопка "Войти" в восстановлении пароля
    private final By theSignInButtonRememberedPassword = By.xpath(".//a[(@class = 'Auth_link__1fOlj' and text()= 'Войти')]");

    //Поле Email
    private final By email = By.xpath("//label[contains(text(),'Email')]/../input");

    //Поле Пароль
    private final By password = By.xpath("//label[contains(text(),'Пароль')]/../input");

    //Кнопка "Личный кабинет"
    private final By personalAccountButton = By.xpath(".//p[contains(text(),'Личный Кабинет')]");

    //Кнопка "Восстановить пароль"
    private final By forgotPasswordButton = By.xpath(".//a[(@class = 'Auth_link__1fOlj' and text()= 'Восстановить пароль')]");
    //Кнопка "Конструктора"
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");

    public LoginFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginFormPage(WebDriver driver, String someParam) {
        this.driver = driver;
        this.someParam = someParam;
    }
    @Step("нажатие на кнопку \"Зарегистрироваться\"")
    // Метод нажатия на кнопку "Зарегистрироваться"
    public RegistrationPage clickRegistrationButton() {
        driver.findElement(theRegistrationButton).click();
        return new RegistrationPage(driver);
    }

    @Step("нажатие на кнопку \"Войти\"")
    public LoginFormPage clickSignInButton() {
        driver.findElement(theSignInButton).click();
        return this;
    }
    @Step("нажатие на кнопку \"Войти\" на форме восстановления пароля")
    public LoginFormPage clickSignInButtonRememberedPassword() {
        driver.findElement(theSignInButtonRememberedPassword).click();
        return this;
    }

    @Step("ввод почты в поле")
    public void setEmail(String userEmail) {
        driver.findElement(email).sendKeys(userEmail);
    }

    @Step("ввод пароля в поле")
    public void setPassword(String userPassword) {
        driver.findElement(password).sendKeys(userPassword);
    }

    @Step("нажатие кнопки Личный кабинет")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("нажатие кнопки Восстановить пароль")
    public PasswordRecoveryPage clickForgotPasswordButton() {

        WebElement element = driver.findElement(forgotPasswordButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        driver.findElement(forgotPasswordButton).click();

        return new PasswordRecoveryPage(driver);
    }
    @Step("заполнения полей \"Email\" и \"Password\" на главной странице")
    public HomePage signInUser(String userEmail, String userPassword){

        clickPersonalAccountButton();
        setEmail(userEmail);
        setPassword(userPassword);
        clickSignInButton();

        return new HomePage(driver);
    }

    @Step("проверка доступности поля Войти")
    public boolean isSignInButtonDisplayed() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(theSignInButton));

        return driver.findElement(theSignInButton).isDisplayed();
    }

}
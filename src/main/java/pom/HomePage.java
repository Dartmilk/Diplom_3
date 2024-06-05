package pom;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
@AllArgsConstructor
public class HomePage {

    private  WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }



    //Кнопка "Войти в аккаунт"
    private By theSignInAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");

    //Кнопка "Личный кабинет"
    public static By thePersonalAccountButton = By.xpath(".//p[contains(text(),'Личный Кабинет')]");

    //Вкладка "Булки"
    private final By theBunButton = By.xpath(".//div[span[text()='Булки']]");

    //Вкладка "Соусы"
    private final By theSauceButton = By.xpath(".//div[span[text()='Соусы']]");

    //Вкладка "Начинки"
    private final By TheFillingButton = By.xpath(".//div[span[text()='Начинки']]");

    //Локатор булок
    private final By bun = By.xpath("//div[contains(span/text(),'Булки') and contains(@class,'current')]");

    //Локатор соусов
    private final By sauces = By.xpath("//div[contains(span/text(),'Соусы') and contains(@class,'current')]");

    //Локатор начинки
    private final By fillings = By.xpath("//div[contains(span/text(),'Начинки') and contains(@class,'current')]");

    //Кнопка "Оформить заказ"
    private final By orderButton = By.xpath(".//div[starts-with(@class,'BurgerConstructor_basket__container')]/button");



    @Step("Клик по кнопке Личный кабинет")
    public LoginFormPage clickPersonalAccountButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(thePersonalAccountButton));

        driver.findElement(thePersonalAccountButton).click();
        return new LoginFormPage(driver);
    }

    @Step("Клик по кнопке Войти в аккаунт")
    public LoginFormPage clickLogInAccountButton() {
        driver.findElement(theSignInAccountButton).click();
        return new LoginFormPage(driver);
    }
    @Step("Клик по кнопке Личный кабинет авторизированным пользователем")
     public ProfilePage clickPersonalAccountButtonAuthUser() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(thePersonalAccountButton));

        driver.findElement(thePersonalAccountButton).click();
        return new ProfilePage(driver);
    }

    @Step("Клик по кнопке Булки")
    public HomePage clickBunsTab() {
        driver.findElement(theBunButton).click();
        return new HomePage(driver);
    }

    @Step("Клик по кнопке Соусы")
    public HomePage clickSaucesTab() {
        driver.findElement(theSauceButton).click();
        return new HomePage(driver);
    }

    @Step("Клик по кнопке Начинки")
    public HomePage clickFillingsTab() {
        driver.findElement(TheFillingButton).click();
        return new HomePage(driver);
    }
    @Step("появления на экране вкладки \"Булки\"")
    public boolean isBunsIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bun));

        return driver.findElement(bun).isDisplayed();
    }

    @Step("появления на экране вкладки \"Соусы\"")
    public boolean isSaucesIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sauces));

        return driver.findElement(sauces).isDisplayed();
    }

    @Step("появления на экране вкладки \"Начинки\"")
    public boolean isFillingsIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fillings));

        return driver.findElement(fillings).isDisplayed();
    }
    @Step("получения текста кнопки\"Оформит заказ\"")
    public String getBasketButtonText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderButton));
        return driver.findElement(orderButton).getText();
    }


}

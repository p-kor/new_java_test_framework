package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    public static final String VALID_USER = "user";
    public static final String VALID_PASSWORD = "user";
    public static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        driver.get(BASE_URL + "login-form.html");
    }

    public void login() {
        userNameInput.sendKeys(VALID_USER);
        passwordInput.sendKeys(VALID_PASSWORD);
        loginButton.click();
    }
}

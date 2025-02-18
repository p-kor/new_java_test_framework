import org.junit.jupiter.api.Test;
import page.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class UiPomTest extends BaseUiTest {

    @Test
    void loginPomTest() {
        LoginPage loginPage = new LoginPage(driver, longWait);
        loginPage.login();

        String expectedUrl = LoginPage.BASE_URL
                .concat("login-sucess.html?username=%s&password=%s".formatted(LoginPage.VALID_USER, LoginPage.VALID_PASSWORD));

        assertNotNull(driver.getCurrentUrl());
        assertTrue(driver.getCurrentUrl().contains(expectedUrl));
    }
}

import config.TestPropertiesConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import page.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class UiPomTest extends BaseUiTest {

    TestPropertiesConfig configProperties = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());

    @Test
    void loginPomTest() {
        LoginPage loginPage = new LoginPage(driver, longWait);
        loginPage.login();

        String path = "login-sucess.html?username=%s&password=%s"
                .formatted(configProperties.getLogin(), configProperties.getPassword());
        String expectedUrl = configProperties.getUiBaseUrl() + path;

        assertNotNull(driver.getCurrentUrl());
        assertTrue(driver.getCurrentUrl().contains(expectedUrl));
    }
}

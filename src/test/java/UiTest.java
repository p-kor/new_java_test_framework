import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

import static constant.CommonConstant.UI_BASE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UiTest extends BaseUiTest{

    @Test
    void submitWebFormTest() {
        driver.get(UI_BASE_URL);
        driver.findElement(By.linkText("Web form")).click();
        driver.findElement(By.id("my-text-id")).sendKeys("Text");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement title = driver.findElement(By.className(("display-6")));

        assertEquals("Form submitted", title.getText());
    }

    @Test
    void loadingImagesImplicitWaitTest() {
        driver.get(UI_BASE_URL + "loading-images.html");

        WebElement compass = driver.findElement(By.id("compass"));
        WebElement calendar = driver.findElement(By.id("calendar"));
        WebElement award = driver.findElement(By.id("award"));
        WebElement landscape = driver.findElement(By.id("landscape"));

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(compass.getDomAttribute("src")).containsIgnoringCase("compass");
        softly.assertThat(calendar.getDomAttribute("src")).containsIgnoringCase("calendar");
        softly.assertThat(award.getDomAttribute("src")).containsIgnoringCase("award");
        softly.assertThat(landscape.getDomAttribute("src")).containsIgnoringCase("landscape");
        softly.assertAll();

    }

    @Test
    void loadingImagesExplicitWaitTest() {
        driver.get(UI_BASE_URL + "loading-images.html");

        WebElement landscape = longWait.until(ExpectedConditions.presenceOfElementLocated(By.id("landscape")));
        String src = landscape.getDomAttribute("src");
        String textToFind = "landscape";
        assertTrue(src != null && src.toLowerCase().contains(textToFind),
                "element attribute src should contain " + textToFind);
    }
}

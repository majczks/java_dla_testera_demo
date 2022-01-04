package Tests;

import Pages.ContactUsFormPage;
import Pages.TopMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.*;

public class Kontakt extends BaseTest {

    private TopMenu TopMenu;
    private ContactUsFormPage ContactUsFormPage;

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo("My Store");

        TopMenu = new TopMenu(driver);
        ContactUsFormPage = new ContactUsFormPage(driver);
    }

    @Test
    public void ShouldNotAllowToSendContactUsForm() {
        TopMenu.ClickOnContactUsLink();
        ContactUsFormPage.ClickOnSendButton();
        assertThat(ContactUsFormPage.isRedAlertBoxDisplayed()).isTrue();

    }

    @Test
    public void ShouldNotAllowToSendFormWithEmailOnly() {
        TopMenu.ClickOnContactUsLink();
        ContactUsFormPage.enterEmail("test@test.com");
        ContactUsFormPage.ClickOnSendButton();
        assertThat(ContactUsFormPage.isRedAlertBoxDisplayed()).isTrue();
    }
}

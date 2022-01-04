package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsFormPage {

    public ContactUsFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "submitMessage")
    WebElement SendButton;

    @FindBy(className = "alert-danger")
    WebElement redAlertBox;

    @FindBy(id = "email")
    WebElement emailInput;

    public void ClickOnSendButton() {
        SendButton.click();
    }

    public boolean isRedAlertBoxDisplayed() {
        boolean isDisplayed = false;
        try {
            isDisplayed = redAlertBox.isDisplayed();
        } catch (NoSuchElementException e) {
        }
        return isDisplayed;
    }

    public void enterEmail(String email) {
        emailInput.sendKeys();
    }

}

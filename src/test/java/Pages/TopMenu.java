package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenu {

   public TopMenu(WebDriver driver) {
       PageFactory.initElements(driver, this);

    }

    @FindBy(linkText = "contact us")
    WebElement contactUsLink;

    public void ClickOnContactUsLink() {
        contactUsLink.click();


    }
}

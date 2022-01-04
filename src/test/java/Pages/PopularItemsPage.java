package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class PopularItemsPage {

    public PopularItemsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = "#homefeatured .product-name")
    List<WebElement> ProductNames;

    public List<String> getProductNames(){
       return ProductNames.stream()
                .map(el -> el.getText().trim())
                .collect(Collectors.toList());
    }
}

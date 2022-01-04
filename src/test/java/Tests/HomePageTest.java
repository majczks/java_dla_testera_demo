package Tests;

import Pages.PopularItemsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class HomePageTest extends BaseTest {

    private PopularItemsPage popularItemsPage;

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo("My Store");

        popularItemsPage = new PopularItemsPage(driver);
    }
        @Test
        public void shouldSeePopularItemsOnPage() {
            List<String> productNames = popularItemsPage.getProductNames();

            List<String> ProductsWithEmptyNames = productNames.stream()
                    .filter(el -> el.isEmpty())
                    .collect(Collectors.toList());

            assertThat(ProductsWithEmptyNames).isEmpty();
        }
    }


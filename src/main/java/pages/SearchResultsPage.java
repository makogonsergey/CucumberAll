package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='PlayStation 5 Console']")
    private WebElement product;

    @FindBy(xpath = "//span[normalize-space()='Sony PULSE 3D Wireless Headset']")
    private WebElement productToCart;

    @FindBy(xpath = "//span[normalize-space()='Tails of Iron - PlayStation 5']")
    private WebElement productPreOrdered;

    public void clickOnProduct() {
        product.click();
    }

    public void clickOnProductToCart() {
        productToCart.click();
    }

    public void clickOnPreOrderedProductToCart() {
        productPreOrdered.click();
    }

}

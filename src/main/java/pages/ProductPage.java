package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//span[@id='productTitle']")
    private WebElement productTitle;

    @FindBy(xpath = "//input[@id='add-to-wishlist-button-submit']")
    private WebElement addToWishListBtn;

    @FindBy(xpath = "//h4[normalize-space()='Add to List']")
    private WebElement addToListPopUp;

    @FindBy(xpath = "//span[@id='WLHUC_result_itemCount' and contains(text(),'1')]")
    private WebElement itemCount;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//span[@id='nav-cart-count' and contains(text(),'1')]")
    private WebElement itemOnCartCount;

    @FindBy(xpath = "//a[normalize-space()='Add to List']")
    private WebElement addToWishListBtnUnregistered;

    @FindBy(xpath = "//input[@aria-labelledby='exportAlternativeTriggerButton-announce']")
    private WebElement seeSimilarBtn;

    @FindBy(xpath = "//span[normalize-space()='Similar items shipping to Ukraine']")
    private WebElement popupSimilar;

    @FindBy(xpath = "//*[@id='hlb-ptc-btn-native']")
    private WebElement checkoutBtn;

    @FindBy(xpath = "//input[@id='buy-now-button']")
    private WebElement preOrderBtn;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToWishListBtn() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToWishListBtn);
    }

    public boolean isProductTitleVisible() {
        return productTitle.isDisplayed();
    }

    public WebElement getAddToListPopUp() {
        return addToListPopUp;
    }

    public boolean isItemCountVisible() {
        return productTitle.isDisplayed();
    }

    public boolean isAddToCartBtnVisible() {
        return addToCartBtn.isDisplayed();
    }

    public void clickAddToWishListBtnUnregistered() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToWishListBtnUnregistered);
    }

    public void clickAddToCartBtn() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartBtn);
    }

    public boolean isItemOnCartCountVisible() {
        return itemOnCartCount.isDisplayed();
    }

    public WebElement getItemOnCartCount() {
        return itemOnCartCount;
    }

    public void clickSeeSimilarBtn() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", seeSimilarBtn);
    }

    public WebElement getPopupSimilar() {
        return popupSimilar;
    }

    public boolean isPopupSimilarVisible() {
        return popupSimilar.isDisplayed();
    }

    public boolean isCheckOutBtnVisible() {
        return checkoutBtn.isDisplayed();
    }

    public boolean isPreOrderButtonVisible() {
        return preOrderBtn.isDisplayed();
    }

    public void clickPreOrderBtn() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", preOrderBtn);
    }
}

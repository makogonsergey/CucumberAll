package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    private WebElement signInButton;

    @FindBy(xpath = "//span[contains(text(),'Hello, Sergii')]")
    private WebElement greeting;

    @FindBy(xpath =  "//input[@id='twotabsearchtextbox']")
    private WebElement searchField;

    @FindBy(xpath =  "//input[@id='nav-search-submit-button']")
    private WebElement searchBtn;

    @FindBy(xpath =  "//select[@id='searchDropdownBox']")
    private WebElement searchDropdown;

    @FindBy(xpath =  "//span[@id='nav-search-label-id' and contains(text(),'Books')]")
    private WebElement selectedDropdown;

    public void clickSignInButton() {
        signInButton.click();
    }

    public boolean isGreetingVisible() {
        return greeting.isDisplayed();
    }

    public boolean isSearchFieldVisible() {
        return searchField.isDisplayed();
    }

    public void enterTextToSearchField(final String text) {
        searchField.clear();
        searchField.sendKeys(text);
    }

    public void clickSearchButton() {
        searchBtn.click();
    }

    public WebElement getSearchDropdown() {
        return searchDropdown;
    }

    public void clickSearchDropdown() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", searchDropdown);
    }

    public boolean isSelectedDropdownVisible() {
        return selectedDropdown.isDisplayed();
    }
}

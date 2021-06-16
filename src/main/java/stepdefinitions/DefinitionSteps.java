package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("Click on login button")
    public void clickOnLoginButton() {
        homePage.clickSignInButton();
    }

    @And("Click on create account button")
    public void clickOnCreateButton(){
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, loginPage.getCreateBtn());
        loginPage.clickCreateBtn();
    }

    @When("User enters {string} login")
    public void userEnterValidLogin(final String keyword) {
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, loginPage.getEmailField());
        loginPage.enterTextToEmailField(keyword);
    }

    @And("User enters {string} password")
    public void userEnterValidPassword(final String keyword) {
        loginPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, loginPage.getPasswordFieldField());
        loginPage.enterTextToPasswordField(keyword);
    }

    @And("User click on 'Sign-In' button")
    public void clickSignIn() {
        loginPage.clickSignInBtn();
    }

    @And("User click on 'Continue' button")
    public void clickContinue() {
        loginPage.clickContinueButton();
    }

    @Then("User logins on the site")
    public void userLoginOnTheSite() {
        assertTrue(homePage.isGreetingVisible());
    }

    @Then("User sees empty password notification")
    public void userEmptyPassword() {
        assertTrue(loginPage.isEnterPasswordVisible());
    }

    @Then("User sees empty login notification")
    public void userEmptyEmail() {
        assertTrue(loginPage.isEnterEmailVisible());
    }

    @And("User checks search field visibility")
    public void checkSearchVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isSearchFieldVisible();
    }

    @And("User makes search by keyword {string}")
    public void enterKeywordToSearchField(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @And("User clicks search button")
    public void clickSearchButton() throws InterruptedException {
        homePage.clickSearchButton();
    }

    @And("User clicks on desired product")
    public void clickOnProduct() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.clickOnProduct();
    }

    @And("User checks that product page is opened")
    public void checkProductPage() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);
        productPage.isProductTitleVisible();
    }

    @And("User adds that product page to wishlist")
    public void clickOnWishList() {
        productPage.clickAddToWishListBtn();
    }

    @And("User checks that product added to wish list")
    public void checkProductAdded() {
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAddToListPopUp());
        assertTrue(productPage.isItemCountVisible());
    }

    @And("User clicks on product they wish to buy")
    public void clickOnProductToBuy() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.clickOnProductToCart();
    }

    @And("User adds that product to cart")
    public void clickOnToCart() {
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);
        assertTrue(productPage.isAddToCartBtnVisible());
        productPage.clickAddToCartBtn();
    }

    @And("User checks that product added to cart")
    public void isItemOnCartCountVisible() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getItemOnCartCount());
        assertTrue(productPage.isItemOnCartCountVisible());
    }

    @And("User proceeded to login page")
    public void userLogin() {
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, loginPage.getEmailField());
        assertTrue(loginPage.isEmailFieldVisible());
    }

    @And("Unregistered user adds that product page to wishlist")
    public void clickOnWishListUnregistered() {
        productPage.clickAddToWishListBtnUnregistered();
    }

    @And("User changes search category by keyword {string}")
    public void changeSearchCategory(final String keyword) {
        homePage.clickSearchDropdown();
        Select dropdown = new Select(homePage.getSearchDropdown());
        dropdown.selectByVisibleText(keyword);
    }

    @Then("User checks selected search category")
    public void checkSearchCategory() {
        assertTrue(homePage.isSelectedDropdownVisible());
    }

    @And("User presses button to see similar items")
    public void clickOnButtonSimilar() {
        productPage.clickSeeSimilarBtn();
    }

    @And("User sees similar items")
    public void isPopupSimilarVisible() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getPopupSimilar());
        assertTrue(productPage.isPopupSimilarVisible());
    }

    @Then("User checks visibility of checkout button")
    public void checkCheckoutButtonCategory() {
        assertTrue(productPage.isCheckOutBtnVisible());
    }

    @And("User clicks on pre-order product")
    public void clickOnPreOrderedProduct() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.clickOnPreOrderedProductToCart();
    }

    @And("Unregistered user pre-order that product")
    public void preorderProduct() {
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);
        assertTrue(productPage.isPreOrderButtonVisible());
        productPage.clickPreOrderBtn();
    }

    @And("User enters {string} registration name")
    public void userEnterName(final String keyword) {
        registerPage = pageFactoryManager.getRegisterPage();
        registerPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, registerPage.getNameField());
        registerPage.enterTextToNameField(keyword);
    }

    @And("User enters {string} registration login")
    public void userEnterEmail(final String keyword) {
        registerPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, registerPage.getEmailField());
        registerPage.enterTextToEmailField(keyword);
    }

    @And("User enters {string} registration password")
    public void userEnterPassword(final String keyword) {
        registerPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, registerPage.getPasswordField());
        registerPage.enterTextToPasswordField(keyword);
    }

    @And("User enters again {string} registration password")
    public void userEnterRePassword(final String keyword) {
        registerPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, registerPage.getPasswordReEnterField());
        registerPage.enterTextToReEnterPasswordField(keyword);
    }

    @And("User clicks 'Continue' button")
    public void clickOnContinueButton() {
        registerPage.clickContinueButton();;
    }

    @Then("User sees invalid password notification")
    public void userSeesInvalidPasswordNotification() {
        assertTrue(registerPage.isInvalidPasswordVisible());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}

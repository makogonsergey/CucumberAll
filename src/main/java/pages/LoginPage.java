package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueBtn;

    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    private WebElement signInBtn;

    @FindBy(xpath =  "//div[contains(text(),'Enter your password')]")
    private WebElement enterPasswordNotification;

    @FindBy(xpath =  "//div[contains(text(),'Enter your email or mobile phone number')]")
    private WebElement enterEmailNotification;

    @FindBy(xpath = "//a[normalize-space()='Create your Amazon account']")
    private WebElement createBtn;

    public WebElement getEmailField() {
        return emailField;
    }

    public void enterTextToEmailField(final String text) {
        emailField.clear();
        emailField.sendKeys(text);
    }

    public void clickContinueButton() {
        continueBtn.click();
    }

    public WebElement getPasswordFieldField() {
        return passwordField;
    }

    public void enterTextToPasswordField(final String text) {
        passwordField.clear();
        passwordField.sendKeys(text);
    }

    public void clickSignInBtn() {
        signInBtn.click();
    }

    public boolean isEnterPasswordVisible() {
        return enterPasswordNotification.isDisplayed();
    }

    public boolean isEmailFieldVisible() {
        return emailField.isDisplayed();
    }

    public boolean isEnterEmailVisible() {
        return enterEmailNotification.isDisplayed();
    }

    public WebElement getCreateBtn() {
        return createBtn;
    }

    public void clickCreateBtn() {
        createBtn.click();
    }
}

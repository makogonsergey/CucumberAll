package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//input[@id='ap_customer_name']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueBtn;

    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='ap_password_check']")
    private WebElement passwordReEnterField;

    @FindBy(xpath = "//div[@id='auth-password-invalid-password-alert']")
    private WebElement invalidPassword;


    public WebElement getEmailField() {
        return emailField;
    }

    public void enterTextToEmailField(final String text) {
        emailField.clear();
        emailField.sendKeys(text);
    }

    public void enterTextToNameField(final String text) {
        nameField.clear();
        nameField.sendKeys(text);
    }

    public void clickContinueButton() {
        continueBtn.click();
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getPasswordReEnterField() {
        return passwordReEnterField;
    }

    public void enterTextToPasswordField(final String text) {
        passwordField.clear();
        passwordField.sendKeys(text);
    }

    public void enterTextToReEnterPasswordField(final String text) {
        passwordReEnterField.clear();
        passwordReEnterField.sendKeys(text);
    }

    public WebElement getNameField() {
        return nameField;
    }

    public boolean isInvalidPasswordVisible() {
        return invalidPassword.isDisplayed();
    }



}

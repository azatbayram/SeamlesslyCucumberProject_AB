package net.seamlessly.pages;

import net.seamlessly.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "user")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "submit-form")
    public WebElement loginButton;

    @FindBy(id = "lost-password")
    public WebElement forgotPasswordLink;

    @FindBy(xpath = "//a[contains(text(),'Log in with a device')]")
    public WebElement loginWithDevice;

    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement wrongUserInfoMsg;

    @FindBy(id = "message")
    public  WebElement blankMsg;

    @FindBy(xpath = "//p[@class='warning throttledMsg']")
    public WebElement multipleInvalidLoginMsg;

    @FindBy(className = "toggle-password")
    public WebElement eyeIcon;

    @FindBy(css = "#reset-password-submit")
    public WebElement resetPasswordButton;

    public void login(String userNameStr, String passwordStr) {
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        loginButton.click();
    }


}

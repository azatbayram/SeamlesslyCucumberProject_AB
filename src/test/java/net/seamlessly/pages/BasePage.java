package net.seamlessly.pages;

import net.seamlessly.utilities.BrowserUtils;
import net.seamlessly.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    @FindBy(css = "div[class='mask icon-loading']")
    @CacheLookup
    protected WebElement loaderMask;

    @FindBy(css = "#settings")
    public WebElement accountIcon;

    @FindBy(css = "span.user-status-menu-item__header")
    public WebElement username;

    @FindBy(css = "li[data-id='logout']")
    protected WebElement logout;

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public String getUserName(){
        waitUntilLoaderScreenDisappear();
        accountIcon.click();
        BrowserUtils.waitForVisibility(username, 5);
        return username.getText();
    }
    public void logOut() {
        waitUntilLoaderScreenDisappear();
        accountIcon.click();
        BrowserUtils.waitForVisibility(logout, 5);
        logout.click();
    }
    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

package net.seamlessly.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.DashboardPage;
import net.seamlessly.pages.LoginPage;
import net.seamlessly.utilities.ConfigurationReader;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.Map;


public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);
    }


    @When("the user enters the valid credential login information")
    public void the_user_enters_the_valid_credential_login_information(Map<String, String> userInfo) {
        String userName=userInfo.get("username");
        String password=userInfo.get("password");

        new LoginPage().login(userName,password);
    }
    @Then("the user should be logged in")
    public void the_user_should_be_on_login_page(Map<String, String> URL) {
        new DashboardPage().waitUntilLoaderScreenDisappear();
        String actualURL=Driver.get().getCurrentUrl();
        String expectedURL= URL.get("url");
//        System.out.println("actualURL = " + actualURL);
//        System.out.println("expectedURL = " + expectedURL);
        //String expectedURL=ConfigurationReader.get("homePageURL");
        Assert.assertEquals(expectedURL,actualURL);
    }

    @Then("the user should see username under Account icon")
    public void the_user_should_see_username_under_Account_icon(Map<String, String> userInfo) {

        String expectedUsername=userInfo.get("username");
        String actualUsername=new DashboardPage().getUserName();

//        System.out.println("expectedUsername = " + expectedUsername);
//        System.out.println("actualUsername = " + actualUsername);
        Assert.assertEquals(expectedUsername, actualUsername);


    }

    @When("the user enters the invalid credential login information")
    public void the_user_enters_the_invalid_credential_login_information(Map<String, String> userInfo) {
//        if(new LoginPage().multipleInvalidLoginMsg.isDisplayed()){
//            WebDriverWait wait=new WebDriverWait(Driver.get(),150);
//            wait.until(ExpectedConditions.invisibilityOf(new LoginPage().multipleInvalidLoginMsg));
//        }
        //System.out.println(userInfo);
        new LoginPage().login(userInfo.get("username"), userInfo.get("password"));
    }

    @Then("the user should see {string} on screen")
    public void the_user_should_see_on_screen(String message) {

        if (new LoginPage().wrongUserInfoMsg.isDisplayed()){
            String actualMessage=new LoginPage().wrongUserInfoMsg.getText();
            String expectedMessage=message;
            Assert.assertEquals(expectedMessage, actualMessage);
        }
    }

    @Then("the user should see {string} on screen for blank username")
    public void the_user_should_see_on_screen_for_blank_username(String message) {
        JavascriptExecutor js=(JavascriptExecutor) Driver.get();
        boolean isRequiredUsername = (Boolean) js.executeScript("return arguments[0].required;",new LoginPage().userName);
        if(isRequiredUsername){
            String actualValidationMsg=(String) js.executeScript("return arguments[0].validationMessage;", new LoginPage().userName);
            String expectedValidationMsg=message;
            Assert.assertEquals(expectedValidationMsg, actualValidationMsg);
        }
    }




    @Then("the user should see {string} on screen for blank password")
    public void the_user_should_see_on_screen_for_blank_password(String message) {
        JavascriptExecutor js=(JavascriptExecutor) Driver.get();
        boolean isRequiredPassword = (Boolean) js.executeScript("return arguments[0].required;",new LoginPage().password);
        if(isRequiredPassword){
            String actualValidationMsg=(String) js.executeScript("return arguments[0].validationMessage;", new LoginPage().password);
            String expectedValidationMsg=message;
            Assert.assertEquals(expectedValidationMsg, actualValidationMsg);
        }

    }

    @When("the user entered username as blank")
    public void the_user_entered_username_as_blank(Map<String, String> userInfo) {
        new LoginPage().login("", userInfo.get("password"));
    }

    @When("the user entered password as blank")
    public void the_user_entered_password_as_blank(Map<String, String> userInfo) {
        new LoginPage().login(userInfo.get("username"), "");
    }

    @When("the user entered user info")
    public void the_user_entered_user_info(Map<String, String> userInfo)  {
        new LoginPage().userName.sendKeys(userInfo.get("username"));
        new LoginPage().password.sendKeys(userInfo.get("password"));
    }


    @Then("the user should be see password in form of dots by default")
    public void the_user_should_be_see_password_in_form_of_dots_by_default(Map<String, String> typeInfo) {
        String actualType=new LoginPage().password.getAttribute("type");
        String expectedType=typeInfo.get("type");
        Assert.assertEquals(expectedType, actualType);
    }

    @When("the user click on eye icon next to password")
    public void the_user_click_on_eye_icon_next_to_password() throws InterruptedException {
       new LoginPage().eyeIcon.click();
       //Thread.sleep(3000);
    }

    @Then("the user should see password explicitly")
    public void the_user_should_see_password_explicitly(Map<String, String> typeInfo) {
       String actualType=new LoginPage().password.getAttribute("type");
       String expectedType=typeInfo.get("type");
       Assert.assertEquals(expectedType, actualType);

    }

    @And("the user should able to see Forgot password? link on login page")
    public void the_user_should_able_to_see_link_on_login_page() {
        new LoginPage().forgotPasswordLink.isDisplayed();
    }

    @When("the user click on Forgot password? link")
    public void the_user_click_on_link() {
        new LoginPage().forgotPasswordLink.click();
    }

    @Then("the user should see {string} button on next page")
    public void the_user_should_see_button_on_next_page(String buttonValue) {
        new LoginPage().resetPasswordButton.isDisplayed();
        String actualButtonValue=new LoginPage().resetPasswordButton.getAttribute("value");
        String expectedButtonValue=buttonValue;
        Assert.assertEquals(expectedButtonValue, actualButtonValue);
    }

    @Then("the user should see {string} placeholder on Username field")
    public void the_user_should_see_placeholder_on_Username_field(String placeholderValue) {
        String expectedPlaceholder=placeholderValue;
        String actualPlaceholder=new LoginPage().userName.getAttribute("placeholder");

        Assert.assertEquals(expectedPlaceholder, actualPlaceholder);


    }

    @Then("the user should see {string} placeholder on Password field")
    public void the_user_should_see_placeholder_on_Password_field(String placeholderValue) {
        String expectedPlaceholder=placeholderValue;
        String actualPlaceholder=new LoginPage().password.getAttribute("placeholder");

        Assert.assertEquals(expectedPlaceholder, actualPlaceholder);

    }

    @When("the user enters the valid credential login information and press ENTER")
    public void the_user_enters_the_valid_credential_login_information_and_press_ENTER(Map<String, String> userInfo) {
        LoginPage loginPage=new LoginPage();
        loginPage.userName.sendKeys(userInfo.get("username"));
        loginPage.password.sendKeys(userInfo.get("password"), Keys.ENTER);

    }




}

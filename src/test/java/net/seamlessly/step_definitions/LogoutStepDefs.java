package net.seamlessly.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.DashboardPage;
import net.seamlessly.pages.LoginPage;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;

import java.util.Map;

public class LogoutStepDefs {

    @And("the user enters the below login information")
    public void the_user_enters_the_valid_credential_login_information(Map<String, String> userInfo) {
        String userName = userInfo.get("username");
        String password=userInfo.get("password");

        new LoginPage().login(userName, password);
    }
    @When("the user click on logout")
    public void the_user_click_on_logout() {
        new DashboardPage().logOut();
    }

    @Then("the user should endup on the login page")
    public void the_user_should_endup_on_the_login_page(Map<String, String> userInfo ) {
        String expectedURL=userInfo.get("loginPageURL");
        String actualURL= Driver.get().getCurrentUrl();

        Assert.assertEquals(expectedURL, actualURL);
    }
    @Then("the user should not go to home page by clicking step back button")
    public void the_user_should_not_go_to_home_page_by_clicking_step_back_button() {
        Driver.get().navigate().back();
        Boolean isLoginDisplayed=new LoginPage().loginButton.isDisplayed();
        Assert.assertTrue(isLoginDisplayed);

    }

}

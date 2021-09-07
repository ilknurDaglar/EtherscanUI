package com.Etherscan.step_definitions;

import com.Etherscan.pages.LoginPage;
import com.Etherscan.utilities.BrowserUtils;
import com.Etherscan.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef {

    LoginPage loginPage = new LoginPage();

    @When("the user who already has an account clicks Signin button")
    public void the_user_who_already_has_an_account_clicks_Signin_button() {
        loginPage.signInBtn.click();
        BrowserUtils.waitFor(3);
    }

    @And("the Login page should display")
    public void theLoginPageShouldDisplay() {

        Assert.assertEquals("Etherscan Login Page", Driver.get().getTitle());

    }

    @And("the user enters {string} to username box")
    public void theUserEntersToUsernameBox(String username) {

        loginPage.usernameBox.sendKeys(username);
    }

    @And("the user enters {string} to password box")
    public void theUserEntersToPasswordBox(String password) {

        loginPage.passwordBox.sendKeys(password);

    }

    @When("the user clicks captca")
    public void the_user_clicks_captca() {

        loginPage.clickCaptcha();
        BrowserUtils.waitFor(15);

    }

    @And("the user clicks Login button")
    public void theUserClicksLoginButton() {

        loginPage.clickLoginBtn();
        BrowserUtils.waitFor(5);

    }

    @Then("Client portal and services page should open")
    public void client_portal_and_services_page_should_open() {

        Assert.assertEquals("Etherscan Client Portal and Services", Driver.get().getTitle());
    }

    @When("the user on the login page")
    public void theUserOnTheLoginPage() {

        Driver.get().get("https://etherscan.io/login");
    }

    @When("the users click Sign up link")
    public void the_users_click_Sign_up_link() {

        BrowserUtils.clickWithJS(loginPage.clickSignUpLink);
    }

    @Then("the registration page should display")
    public void the_registration_page_should_display() {

        loginPage.signUpLink();
    }

    @When("the user clicks Forgot your password? link")
    public void the_user_clicks_Forgot_your_password_link() {
        loginPage.forgotPasswordBtn.click();
    }

    @When("Etherscan lost password page should open")
    public void etherscan_lost_password_page_should_open() {
        LoginPage loginPage=new LoginPage();
        loginPage.lostPasswordPage();

    }


}

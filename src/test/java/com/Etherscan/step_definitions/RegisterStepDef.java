package com.Etherscan.step_definitions;

import com.Etherscan.pages.RegisterPage;
import com.Etherscan.utilities.BrowserUtils;
import com.Etherscan.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;


public class RegisterStepDef {
    RegisterPage registerPage = new RegisterPage();

    @Given("the user on the Registration Page")
    public void the_user_on_the_Registration_Page() {

        registerPage.goToRegisterPage();
    }

    @When("the user enters valid username")
    public void the_user_enters_valid_username() {

        registerPage.fakeUserName();
        BrowserUtils.waitFor(1);
    }

    @When("the user enters valid email")
    public void the_user_enters_valid_email() {

        registerPage.fakeEmail();
        BrowserUtils.waitFor(1);
    }

    @When("the user enters valid password")
    public void the_user_enters_valid_password() {

        registerPage.passwordBox.sendKeys("123456");
    }

    @When("the user enters same password to Confirm password box")
    public void the_user_enters_same_password_to_Confirm_password_box() throws InterruptedException {

        registerPage.confirmPasswordBox.sendKeys("123456");
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,60)");
        }
    }

    @When("the user clicks the Agree to the Terms button")
    public void the_user_clicks_the_Agree_to_the_Terms_button() {

        registerPage.agreeBtn.click();
        BrowserUtils.waitFor(1);
    }


    @When("the user clicks I\"m not a Robot captcha")
    public void the_user_clicks_I_m_not_a_Robot_captcha() {

        registerPage.clickCaptcha();
        BrowserUtils.waitFor(20);

    }


    @When("the user the clicks create account box")
    public void the_user_the_clicks_create_account_box() {

        registerPage.clickCreateAccountBtn();

    }

    @Then("Successfully registered and pending for email verification page should display")
    public void successfullyRegisteredAndPendingForEmailVerificationPageShouldDisplay() {

        RegisterPage registerPage = new RegisterPage();
        registerPage.succesfullText();
    }

    @When("the user enters invalid {string}")
    public void the_user_enters_invalid(String username) {

        registerPage.usernameBox.sendKeys(username);
    }

    @Then("Username is invalid message should display")
    public void username_is_invalid_message_should_display() {

        registerPage.invalidUsernameMsj();

    }

    @When("the user enters invalid email address{string}")
    public void theUserEntersInvalidEmailAddress(String email) {

        registerPage.emailBox.sendKeys(email);
    }

    @Then("please enter a valid mail is should display")
    public void pleaseEnterAValidMailIsShouldDisplay() {

        registerPage.invailEmailMsj();

    }

    @When("the user enters invalid password {string}")
    public void the_user_enters_invalid_password(String password) {

        registerPage.passwordBox.sendKeys(password);
    }

    @Then("Please choose a stronger password message should display")
    public void please_choose_a_stronger_password_message_should_display() {

        Assert.assertEquals("Please choose a stronger password", " ");
    }

    @Then("the user enters different password to confirm password box")
    public void the_user_enters_different_password_to_confirm_password_box() {

        registerPage.passwordBox.sendKeys("12345");
        registerPage.confirmPasswordBox.sendKeys("67890");
    }

    @Then("Password does not match, please check again message should appear")
    public void password_does_not_match_please_check_again_message_should_appear() {

        registerPage.notMatchPassword();
    }
    @When("the user enters weak password")
    public void the_user_enters_weak_password() {

       registerPage.passwordBox.sendKeys("123456");
    }

    @Then("Strength: Weak! message should display")
    public void strength_Weak_message_should_display() {

     registerPage.passwordStrengthWeak();
    }

    @Then("the user enters medium strength password")
    public void the_user_enters_medium_strength_password() {

        registerPage.passwordBox.sendKeys("asfd12%$");
    }

    @Then("Strength: Medium! message should display")
    public void strength_Medium_message_should_display() {

        registerPage.passwordStrengthMedium();
    }
    @Then("the user enters strong password")
    public void the_user_enters_strong_password()
    {
        registerPage.passwordBox.sendKeys("asad346()sa@E");
    }

    @Then("Strength: Strong! message should display")
    public void strength_Strong_message_should_display() {

        registerPage.passwordStrengthStrong();
    }


    @Then("Please accept our Terms and Conditions. message should display")
    public void please_accept_our_Terms_and_Conditions_message_should_display() {

        registerPage.pleaseAcceptMsj();
    }

    @When("the user enters two characters in the password box")
    public void theUserEntersTwoCharactersInThePasswordBox() {

        registerPage.passwordBox.sendKeys("12");

    }

    @Then("Your password must be at least five characters long. message should display")
    public void yourPasswordMustBeAtLeastFiveCharactersLongMessageShouldDisplay() {

        registerPage.passwordMin5message();
    }

    @And("User enters five character password")
    public void userEntersFiveCharacterPassword() {

        registerPage.passwordBox.clear();
        registerPage.passwordBox.sendKeys("12345");
    }

    @And("the user enters same five character password to Confirm password box")
    public void theUserEntersSameFiveCharacterPasswordToConfirmPasswordBox() throws InterruptedException {

        registerPage.confirmPasswordBox.sendKeys("12345");
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,60)");

        }
    }

    @And("Password too short. Minimum of six characters required, message should display")
    public void passwordTooShortMinimumOfSixCharactersRequiredMessageShouldDisplay() {

        RegisterPage registerPage = new RegisterPage();
        registerPage.passwordMin6message();
    }

    @Then("two messages should have same number")
    public void two_messages_should_have_same_number() {


        registerPage.twoMessage();
    }

    @When("the users click Sign in link")
    public void the_users_click_Sign_in_link() {

        BrowserUtils.clickWithJS(registerPage.clickSignInLink);

    }

    @Then("login page should display")
    public void login_page_should_display() {

        registerPage.signInLink();
    }

}

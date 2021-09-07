package com.Etherscan.step_definitions;

import com.Etherscan.pages.LostPasswordPage;
import com.Etherscan.utilities.BrowserUtils;
import com.Etherscan.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LostPasswordStepDef {
    LostPasswordPage lostPasswordPage = new LostPasswordPage();

    @When("the user is on the lostpassword page")
    public void the_user_is_on_the_lostpassword_page() {
        Driver.get().get("https://etherscan.io/lostpassword");
    }

    @And("the user enters {string} to emailbox")
    public void theUserEntersToEmailbox(String email) {

        lostPasswordPage.forgatPageEmail.sendKeys(email);

    }

    @When("the user clicks the captcha")
    public void the_user_clicks_the_captcha() {

        lostPasswordPage.clickCaptcha();
        BrowserUtils.waitFor(15);

    }

    @When("the user clicks the Reset Password button")
    public void the_user_clicks_the_Reset_Password_button() {

        lostPasswordPage.resetPassword();
    }

    @Then("You've successfully requested a forgot password. message should display")
    public void you_ve_successfully_requested_a_forgot_password_message_should_display() {

        lostPasswordPage.successfulRequestMessage();

    }

    @When("the user clicks Back to sign in link")
    public void the_user_clicks_Back_to_sign_in_link() {

        lostPasswordPage.backToSignIn.click();
    }

    @Then("the user turns back Login page")
    public void the_user_turns_back_Login_page() {
        lostPasswordPage.turnToSignIn();
    }

}

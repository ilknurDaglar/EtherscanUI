package com.Etherscan.pages;

import com.Etherscan.utilities.BrowserUtils;
import com.Etherscan.utilities.ConfigurationReader;
import com.Etherscan.utilities.Driver;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class RegisterPage extends BasePage {

    Faker faker = new Faker();
    Random randomNumber = new Random();

    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_txtUserName\"]")
    public WebElement usernameBox;

    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_txtEmail\"]")
    public WebElement emailBox;

    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_txtPassword\"]")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_txtPassword2\"]")
    public WebElement confirmPasswordBox;

    @FindBy(xpath = "//*[text()='I agree to the ']")
    public WebElement agreeBtn;

    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_maindiv\"]/div[5]/div/label/span")
    public WebElement agreeToReceiveBtn;

    @FindBy(css = "#recaptcha-anchor")
    public WebElement captcha;

    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_btnRegister\"]")
    public WebElement createAccountBtn;

    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_maindiv\"]/div[7]/div[1]/a")
    public WebElement clickSignInLink;

    @FindBy(xpath = "//*[@id=\"passstrength\"]/span")
    public WebElement passwordStrengthMessage;

    public void goToRegisterPage() {

        Driver.get().get(ConfigurationReader.get("url"));
    }

    public void fakeUserName() {
        String username = faker.name().firstName().concat(faker.name().lastName());
        usernameBox.sendKeys(username);

    }

    public void fakeEmail() {
        String email;
        int number = randomNumber.nextInt();
        email = "abc" + number + "@hotmail.com";
        emailBox.sendKeys(email);
    }

    public void clickCaptcha() {
        WebElement iframeSwitch = Driver.get().findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_maindiv\"]/div[6]/div/div/div/iframe"));
        Driver.get().switchTo().frame(iframeSwitch);
        Driver.get().findElement(By.cssSelector("#recaptcha-anchor")).click();
    }

    public void clickCreateAccountBtn() {

        Driver.get().switchTo().defaultContent();
        BrowserUtils.waitFor(3);
        BrowserUtils.clickWithJS(createAccountBtn);
    }

    public void succesfullText() {
        String actualResult = Driver.get().findElement(By.xpath("//*[@id=\"ctl00\"]/div[4]")).getText();

        Assert.assertEquals("Your account has been successfully registered and pending for email verification.", actualResult);
    }

    public void invalidUsernameMsj() {
        String actualMsj = Driver.get().findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtUserName-error\"]")).getText();
        Assert.assertEquals("Username is invalid.", actualMsj);

    }

    public void invailEmailMsj() {
        String actualMsj = Driver.get().findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtEmail-error\"]")).getText();
        Assert.assertEquals("Please enter a valid email address.", actualMsj);

    }

    public void notMatchPassword() {
        String actualMsj = Driver.get().findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtPassword2-error\"]")).getText();
        Assert.assertEquals("Password does not match, please check again.", actualMsj);
    }

    public void passwordMin5message() {
        String actualText = Driver.get().findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtPassword-error\"]")).getText();
        Assert.assertEquals("Your password must be at least 5 characters long.", actualText);
    }

    public void passwordMin6message() {
        String actualText = Driver.get().findElement(By.xpath("//*[@id=\"ctl00\"]/div[4]")).getText();
        Assert.assertEquals("Password too short. Minimum of 6 characters required", actualText);
    }

    public void twoMessage() {
        String messageOne = "Your password must be at least 5 characters long.";
        String messageTwo = "Password too short. Minimum of 6 characters required";
        String[] numberOne = messageOne.split(" ");
        int number1 = Integer.parseInt(numberOne[6]);

        String[] numberTwo = messageTwo.split(" ");
        int number2 = Integer.parseInt(numberTwo[5]);

        Assert.assertEquals(number1, number2);
        BrowserUtils.waitFor(5);
    }

    public void pleaseAcceptMsj() {
        String actualMsj = Driver.get().findElement(By.xpath("//*[@id=\"ctl00$ContentPlaceHolder1$MyCheckBox-error\"]")).getText();
        Assert.assertEquals("Please accept our Terms and Conditions.", actualMsj);
    }

    public void signInLink() {
        Assert.assertEquals("Etherscan Login Page", Driver.get().getTitle());
    }

    public void passwordStrengthWeak() {
        Assert.assertEquals("Strength: Weak!", Driver.get().findElement(By.xpath("//*[@id=\"passstrength\"]/span")).getText());

    }

    public void passwordStrengthMedium() {
        Assert.assertEquals("Strength: Medium!", Driver.get().findElement(By.xpath("//*[@id=\"passstrength\"]/span")).getText());

    }

    public void passwordStrengthStrong() {
        Assert.assertEquals("Strength: Strong!", Driver.get().findElement(By.xpath("//*[@id=\"passstrength\"]/span")).getText());


    }

}


package com.Etherscan.pages;

import com.Etherscan.utilities.BrowserUtils;
import com.Etherscan.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"navBar\"]/ul/li[7]/a")
    public WebElement signInBtn;

    @FindBy(css = "#ContentPlaceHolder1_txtUserName")
    public WebElement usernameBox;

    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_txtPassword\"]")
    public WebElement passwordBox;

    @FindBy(css= "#ContentPlaceHolder1_btnLogin")
    public WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"form1\"]/div[8]/div[1]/a")
    public WebElement clickSignUpLink;

    @FindBy(xpath = "//*[@id=\"form1\"]/div[5]/label/span/a")
    public WebElement forgotPasswordBtn;


    public void clickCaptcha() {
        WebElement iframeSwitch = Driver.get().findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_captchaDiv\"]/div/div/div/iframe"));
        Driver.get().switchTo().frame(iframeSwitch);
        Driver.get().findElement(By.cssSelector("#recaptcha-anchor-label")).click();
    }

    public void clickLoginBtn() {
        Driver.get().switchTo().defaultContent();
        BrowserUtils.waitFor(3);
        BrowserUtils.clickWithJS(loginBtn);

    }
    public void signUpLink(){
        Assert.assertEquals("Etherscan Registration Page",Driver.get().getTitle());
    }
    public void lostPasswordPage(){
       Assert.assertEquals("Etherscan Lost Password Page",Driver.get().getTitle());

    }

}

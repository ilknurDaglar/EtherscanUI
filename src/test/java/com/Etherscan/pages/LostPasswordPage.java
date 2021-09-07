package com.Etherscan.pages;

import com.Etherscan.utilities.BrowserUtils;
import com.Etherscan.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LostPasswordPage extends BasePage {

    @FindBy(css = "#ContentPlaceHolder1_TextBox1")
    public WebElement forgatPageEmail;


    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_btnLogin\"]")
    public WebElement resetPasswordBtn;

    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_div3\"]/div[1]/a")
    public WebElement backToSignIn;


    public void clickCaptcha() {
        WebElement iframeSwitch = Driver.get().findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_div4\"]/div/div/div/iframe"));
        Driver.get().switchTo().frame(iframeSwitch);
        Driver.get().findElement(By.cssSelector("#recaptcha-anchor-label")).click();
    }

    public void resetPassword() {
        Driver.get().switchTo().defaultContent();
        BrowserUtils.waitFor(3);
        BrowserUtils.clickWithJS(resetPasswordBtn);

    }

    public void successfulRequestMessage() {
        String actualMessage = Driver.get().findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_divReponseMsg\"]/h4")).getText();
        Assert.assertEquals("You've successfully requested a forgot password.", actualMessage);
    }

    public void turnToSignIn() {

        Assert.assertEquals(Driver.get().getTitle(),"Etherscan Login Page");
    }

}
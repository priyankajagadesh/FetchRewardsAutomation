package com.fetchrewards.pom;

import com.fetchrewards.utils.WaitUtility;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    AndroidDriver<?> driver;
    WaitUtility waitUtility;

    @AndroidFindBy(accessibility = "Username")
    AndroidElement username;
    @AndroidFindBy(accessibility = "Password")
    AndroidElement password;
    @AndroidFindBy(accessibility = "Log In")
    AndroidElement submit;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[1]")
    AndroidElement notNow;
    @AndroidFindBy(accessibility = "Skip")
    AndroidElement skip;



    public LoginPage(AndroidDriver<?> driver) {
        this.driver = driver;
        this.waitUtility = new WaitUtility();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void login(String user, String pass){

        waitUtility.checkIfAvailable(driver,username);
        username.sendKeys(user);

        waitUtility.checkIfAvailable(driver,password);
        password.sendKeys(pass);

        waitUtility.checkIfAvailable(driver,submit);
        submit.click();
    }

    public void clickNotNow(){
        waitUtility.checkIfAvailable(driver,notNow);
        notNow.click();
    }

    public void clickSkip(){
        waitUtility.checkIfAvailable(driver,skip);
        skip.click();
    }

    public AndroidElement getUsername() {
        return username;
    }

    public void setUsername(AndroidElement username) {
        this.username = username;
    }

    public AndroidElement getPassword() {
        return password;
    }

    public void setPassword(AndroidElement password) {
        this.password = password;
    }

    public AndroidElement getSubmit() {
        return submit;
    }

    public void setSubmit(AndroidElement submit) {
        this.submit = submit;
    }
}

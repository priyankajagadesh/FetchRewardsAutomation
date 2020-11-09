package com.fetchrewards.pom;

import com.fetchrewards.utils.WaitUtility;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    AndroidDriver<?> driver;
    public WebDriverWait wait;
    WaitUtility waitUtility;


    @AndroidFindBy(accessibility = "Deny")
    AndroidElement denyBtn;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Search Facebook\"]")
    AndroidElement searchBtn;


    public HomePage(AndroidDriver<?> driver) throws InterruptedException {
        this.driver = driver;
        this.waitUtility = new WaitUtility();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    public void clickSearch(){
        waitUtility.checkIfAvailable(driver,searchBtn);
        searchBtn.click();
    }

    public void clickDeny(){
        waitUtility.checkIfAvailable(driver,denyBtn);
        denyBtn.click();
    }


    public AndroidElement getDenyBtn() {
        return denyBtn;
    }

    public void setDenyBtn(AndroidElement denyBtn) {
        this.denyBtn = denyBtn;
    }

    public AndroidElement getSearchBtn() {
        return searchBtn;
    }

    public void setSearchBtn(AndroidElement searchBtn) {
        this.searchBtn = searchBtn;
    }

}

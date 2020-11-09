package com.fetchrewards.pom;

import com.fetchrewards.utils.WaitUtility;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FetchRewardsPage {
    AndroidDriver<?> driver;
    public WebDriverWait wait;
    WaitUtility waitUtility;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"like button\"]/android.view.ViewGroup/android.view.ViewGroup")
    AndroidElement likebtn;

    public FetchRewardsPage(AndroidDriver<?> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.waitUtility = new WaitUtility();
    }

    public void like() {

        waitUtility.checkIfAvailable(driver,likebtn);
        likebtn.click();
    }

    public AndroidElement getLikebtn() {
        return likebtn;
    }

    public void setLikebtn(AndroidElement likebtn) {
        this.likebtn = likebtn;
    }
}

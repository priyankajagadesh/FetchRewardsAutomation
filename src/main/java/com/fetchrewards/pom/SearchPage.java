package com.fetchrewards.pom;

import com.fetchrewards.utils.WaitUtility;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {
    AndroidDriver<?> driver;
    public WebDriverWait wait;
    WaitUtility waitUtility;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.EditText")
    AndroidElement searchbox;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView")
    AndroidElement panel;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Pages\"]")
    AndroidElement pages;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup")
    AndroidElement searchFetch;


    public SearchPage(AndroidDriver<?> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.waitUtility = new WaitUtility();
        //sss
    }

    public void search() {

        waitUtility.checkIfAvailable(driver,searchbox);
        searchbox.sendKeys("Fetch Rewards");
    }

    public void selectPanel() {

        waitUtility.checkIfAvailable(driver,panel);

        Rectangle rect = panel.getRect();
        PointOption pointOptionStart, pointOptionEnd;
        int edgeBorder =50;

        pointOptionStart = PointOption.point(rect.x + rect.width - rect.height,rect.y + rect.height -edgeBorder);
        pointOptionEnd = PointOption.point(rect.x + rect.width/2,rect.y + rect.height-edgeBorder);

        new TouchAction(driver)
                .press(pointOptionStart)
                // a bit more reliable when we add small wait
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(pointOptionEnd)
                .release().perform();
    }

    public void clickPages() {

        waitUtility.checkIfAvailable(driver,pages);
        pages.click();
    }

    public void searchFetchRewards() {

        waitUtility.checkIfAvailable(driver,searchFetch);
        searchFetch.click();
    }

    public AndroidElement getSearchbox() {
        return searchbox;
    }

    public void setSearchbox(AndroidElement searchbox) {
        this.searchbox = searchbox;
    }

    public AndroidElement getPanel() {
        return panel;
    }

    public void setPanel(AndroidElement panel) {
        this.panel = panel;
    }

    public AndroidElement getPages() {
        return pages;
    }

    public void setPages(AndroidElement pages) {
        this.pages = pages;
    }

    public AndroidElement getSearchFetch() {
        return searchFetch;
    }

    public void setSearchFetch(AndroidElement searchFetch) {
        this.searchFetch = searchFetch;
    }
}

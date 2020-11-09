package com.fetchrewards.test;


import com.fetchrewards.pom.FetchRewardsPage;
import com.fetchrewards.pom.HomePage;
import com.fetchrewards.pom.LoginPage;
import com.fetchrewards.pom.SearchPage;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class TestScript {

    private static AndroidDriver driver;

    @BeforeTest
            public void initialize() throws MalformedURLException {

        final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
        URL url = new URL(URL_STRING);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("deviceName", "emulator-5554");
       // capabilities.setCapability("platformName", "android");
        capabilities.setCapability("appPackage", "com.facebook.katana");
        capabilities.setCapability("appActivity", ".LoginActivity");
        capabilities.setCapability("automationName","uiautomator2");
        driver = new AndroidDriver<MobileElement>(url, capabilities);
    }

    @Test
    @Parameters({"user","pass"})
    public void login(String user,String pass) throws MalformedURLException, InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 50);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user,pass);
        loginPage.clickNotNow();
        loginPage.clickSkip();

        HomePage homePage = new HomePage(driver);
        homePage.clickDeny();
        homePage.clickSearch();

        SearchPage searchPage = new SearchPage(driver);
        searchPage.search();
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        searchPage.selectPanel();
        searchPage.clickPages();
        searchPage.searchFetchRewards();

        FetchRewardsPage fetchRewardsPage = new FetchRewardsPage(driver);
        fetchRewardsPage.like();
    }


}

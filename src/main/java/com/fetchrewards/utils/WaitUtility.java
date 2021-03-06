package com.fetchrewards.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

    public WebDriverWait wait;

    public void checkIfAvailable(AndroidDriver<?> driver, AndroidElement androidElement){

        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(androidElement));

    }
}

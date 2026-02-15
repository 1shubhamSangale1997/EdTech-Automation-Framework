package com.edtech.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExamResultPage {

    WebDriver driver;

    // User dropdown (appears only after successful login)
    By userProfile = By.className("oxd-userdropdown-name");

    public ExamResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isResultDisplayed() {
        try {
            return driver.findElement(userProfile).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

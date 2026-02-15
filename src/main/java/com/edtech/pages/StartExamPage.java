package com.edtech.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartExamPage {

    WebDriver driver;
    WebDriverWait wait;

    public StartExamPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isExamPageOpened() {
        // Verify exam page using URL
        wait.until(ExpectedConditions.urlContains("time"));
        return driver.getCurrentUrl().contains("time");
    }
}

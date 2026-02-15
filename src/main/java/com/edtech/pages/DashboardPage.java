package com.edtech.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

    WebDriver driver;
    WebDriverWait wait;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Locators
    By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
    By userProfileName = By.className("oxd-userdropdown-name");

    public boolean isDashboardDisplayed() {
        // Ensure we are on dashboard page first
        wait.until(ExpectedConditions.urlContains("dashboard"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader));
        return driver.findElement(dashboardHeader).isDisplayed();
    }

    public boolean isUserProfileVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userProfileName));
        return driver.findElement(userProfileName).isDisplayed();
    }
}

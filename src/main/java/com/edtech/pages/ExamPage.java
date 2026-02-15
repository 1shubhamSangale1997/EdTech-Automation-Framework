package com.edtech.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExamPage {

    WebDriver driver;
    WebDriverWait wait;

    // Using Time menu as Exam module
    By timeMenu = By.xpath("//span[text()='Time']");

    public ExamPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openExamSection() {
        wait.until(ExpectedConditions.elementToBeClickable(timeMenu));
        driver.findElement(timeMenu).click();
    }

    public boolean isExamSectionVisible() {
        // Stable validation
        wait.until(ExpectedConditions.urlContains("time"));
        return driver.getCurrentUrl().contains("time");
    }
}

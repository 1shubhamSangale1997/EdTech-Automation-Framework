package com.edtech.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExamListPage {

    WebDriver driver;
    WebDriverWait wait;

    // Attendance table rows (treated as Exam List)
    By tableRows = By.xpath("//div[@role='row' and .//div[@role='cell']]");

    public ExamListPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isExamListPageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableRows));
        return driver.findElements(tableRows).size() > 0;
    }

    public int getExamCount() {
        return driver.findElements(tableRows).size();
    }

    public boolean isAtLeastOneExamPresent() {
        return getExamCount() > 0;
    }

    public void printExamNames() {
        List<WebElement> rows = driver.findElements(tableRows);
        for (WebElement row : rows) {
            System.out.println("Exam Row Found");
        }
    }
}

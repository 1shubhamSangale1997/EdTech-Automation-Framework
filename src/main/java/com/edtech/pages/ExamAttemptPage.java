package com.edtech.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExamAttemptPage {

    WebDriver driver;
    WebDriverWait wait;

    // Simulated question options (checkboxes)
    By answerOptions = By.xpath("//input[@type='checkbox']");

    // Simulated submit (using Save / navigation)
    By submitButton = By.xpath("//button[contains(@class,'oxd-button')]");

    public ExamAttemptPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Attempt questions
    public void attemptQuestions() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(answerOptions));

        List<WebElement> options = driver.findElements(answerOptions);

        // Select first 2 options (simulation)
        for (int i = 0; i < options.size() && i < 2; i++) {
            if (!options.get(i).isSelected()) {
                options.get(i).click();
            }
        }
    }

    // Submit exam
    public void submitExam() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        driver.findElement(submitButton).click();
    }

    // Verify submission
    public boolean isExamSubmitted() {
        return driver.getCurrentUrl().contains("time");
    }
}

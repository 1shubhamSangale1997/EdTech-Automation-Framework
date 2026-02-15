package com.edtech.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.edtech.base.BaseTest;
import com.edtech.pages.DashboardPage;
import com.edtech.pages.ExamAttemptPage;
import com.edtech.pages.ExamListPage;
import com.edtech.pages.ExamPage;
import com.edtech.pages.ExamResultPage;
import com.edtech.pages.LoginPage;
import com.edtech.pages.StartExamPage;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            {"Admin", "admin123"}
        };
    }

    @Test(dataProvider = "loginData")
    public void completeOnlineExamFlow(String username, String password) {

        System.out.println("Login test started");

        // Login
        LoginPage login = new LoginPage(getDriver());
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickLogin();

        // Dashboard
        DashboardPage dashboard = new DashboardPage(getDriver());
        Assert.assertTrue(dashboard.isDashboardDisplayed(),
                "Dashboard not displayed");

        // Navigate to Exam
        ExamPage examPage = new ExamPage(getDriver());
        examPage.openExamSection();
        Assert.assertTrue(examPage.isExamSectionVisible(),
                "Exam section not visible");

        // Exam list
        ExamListPage examList = new ExamListPage(getDriver());
        Assert.assertTrue(examList.isExamListPageDisplayed(),
                "Exam list not visible");

        int examCount = examList.getExamCount();
        Assert.assertTrue(examCount > 0,
                "No exams available");

        System.out.println("Exam Count Validation Passed: " + examCount);

        // Start Exam
        StartExamPage startExam = new StartExamPage(getDriver());
        Assert.assertTrue(startExam.isExamPageOpened(),
                "Exam page not opened");

        // Attempt Exam
        ExamAttemptPage attempt = new ExamAttemptPage(getDriver());
        attempt.attemptQuestions();
        attempt.submitExam();

        Assert.assertTrue(attempt.isExamSubmitted(),
                "Exam submission failed");

        System.out.println("Online exam flow completed successfully");

        // Validate Exam Result / Submission
        ExamResultPage resultPage = new ExamResultPage(getDriver());
        Assert.assertTrue(resultPage.isResultDisplayed(),
                "Exam result / submission confirmation not displayed");
    }
}

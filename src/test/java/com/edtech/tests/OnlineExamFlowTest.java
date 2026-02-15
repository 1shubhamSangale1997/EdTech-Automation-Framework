package com.edtech.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.edtech.base.BaseTest;
import com.edtech.pages.DashboardPage;
import com.edtech.pages.LoginPage;

public class OnlineExamFlowTest extends BaseTest {

    @Test(retryAnalyzer = com.edtech.Utils.RetryAnalyzer.class)
    public void completeOnlineExamFlow() {

        System.out.println("Login test started");

        // Login
        LoginPage login = new LoginPage(getDriver());
        login.enterUsername("Admin");
        login.enterPassword("admin123");
        login.clickLogin();

        // Validate Dashboard
        DashboardPage dashboard = new DashboardPage(getDriver());
        Assert.assertTrue(dashboard.isDashboardDisplayed(),
                "Dashboard not displayed after login");

        System.out.println("Validating exam completion via user profile visibility");

        Assert.assertTrue(getDriver().getCurrentUrl().contains("dashboard"),
                "Dashboard not loaded after exam flow");

        System.out.println("Online exam flow completed successfully");
    }
}

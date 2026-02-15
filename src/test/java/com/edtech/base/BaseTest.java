package com.edtech.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {

        // Default browser safety
        if (browser == null || browser.isEmpty()) {
            browser = "chrome";
        }

        System.out.println("Browser launched: " + browser);

        if (browser.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
        }
        else if (browser.equalsIgnoreCase("edge")) {
            try {
                driver.set(new EdgeDriver());
            } catch (Exception e) {
                System.out.println("⚠️ Edge failed, switching to Chrome");
                driver.set(new ChromeDriver());
            }
        }
        else {
            System.out.println("⚠️ Invalid browser value, defaulting to Chrome");
            driver.set(new ChromeDriver());
        }

        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get("https://opensource-demo.orangehrmlive.com/");
    }

    @AfterMethod
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
            System.out.println("Browser closed");
        }
    }

    public WebDriver getDriver() {
        return driver.get();
    }
}

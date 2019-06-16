package com.framework.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.framework.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class TestUtil {

    protected WebDriver driver;
    protected LoginPage loginPage;
    ConfigUtil configUtil;
    ExcelUtil excelUtil;
    protected ExtentReports report;
    protected ExtentTest logger;

    @BeforeSuite
    public void suiteSetUp() {
        configUtil = new ConfigUtil();
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(new File("./reports/extent_"+GenericUtil.getCurrentDateTime()+".html"));
        report = new ExtentReports();
        report.attachReporter(extentHtmlReporter);

    }

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setup(String browser) {
        driver = BrowserUtil.startBrowser(driver, browser, configUtil.get("testUrl"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void methodTearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                String screenshotPath = "." + GenericUtil.takeScreenShot(driver, result.getMethod().getMethodName());
                logger.fail("Screenshot at test failure ", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } catch (IOException e) {
                System.out.println("Error While taking screenshot : " + e.getMessage());
            }
        }
        report.flush();
    }
}

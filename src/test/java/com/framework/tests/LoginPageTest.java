package com.framework.tests;

import com.framework.pages.LoginPage;
import com.framework.utils.TestUtil;
import org.testng.annotations.Test;

public class LoginPageTest extends TestUtil {

    @Test
    public void LoginTest(){
        logger = report.createTest("Login to CRM");
        loginPage = new LoginPage(driver);
        logger.info("Starting Test");
        loginPage.loginToApplication("Selenium_50","Abcd@123456");
        loginPage.getTitle();
        logger.pass("Test Passed");
    }
}

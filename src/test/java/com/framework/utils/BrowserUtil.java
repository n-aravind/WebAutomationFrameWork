package com.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class BrowserUtil {

    public static WebDriver startBrowser(WebDriver driver, String browser, String url) {
       if(browser.equalsIgnoreCase("chrome")){
           System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
           ChromeOptions chromeOptions = new ChromeOptions();
           chromeOptions.addArguments("window-size=1366,613");
           chromeOptions.addArguments("--headless");
           driver = new ChromeDriver(chromeOptions);
       }else if (browser.equalsIgnoreCase("firefox")){
           System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
           driver = new FirefoxDriver();
       }else if (browser.equalsIgnoreCase("ie")){
           System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
           driver = new InternetExplorerDriver();
       }else{
           System.out.println("Invalid Browser");
       }
       driver.manage().window().maximize();
       driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
       driver.get(url);
       driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
       return driver;
    }


}

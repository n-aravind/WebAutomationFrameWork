package com.framework.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class GenericUtil {

    public static String takeScreenShot(WebDriver driver, String name) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String filePath = ".\\screenshots\\" + name + "_" + getCurrentDateTime() + ".png";
        FileHandler.copy(screenshot, new File(filePath));
        return filePath;
    }

    public static String getCurrentDateTime() {
        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    }

}

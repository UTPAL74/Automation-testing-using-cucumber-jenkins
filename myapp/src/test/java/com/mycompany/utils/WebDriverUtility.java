package com.mycompany.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverUtility {

    private static WebDriver driver;
    static int timeout = 3000;

    public WebDriver getDriver(){
        return driver;
    }

    public static void setBrowser() {
        String pathToDriver = "F:\\MY java workspace\\MyMavenProject\\app";
        System.setProperty("webdriver.chrome.driver", pathToDriver+"/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void openUrl(String url) {
        if(driver == null)
            WebDriverUtility.setBrowser();

        if (!(url.contains("http")))
            url = "http://" + url;

        driver.get(url);
    }

    public  static void closeBrowser() {
        driver.quit();
        driver = null;
    }

    public static void waitFor(int... sec) {
        if (sec.length != 0)
            timeout = sec[0]*1000;
        try {
            Thread.sleep(timeout);
        } catch (Exception e) {

        }
    }

}

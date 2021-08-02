package org.canan.yemeksepeti.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Collections;
import java.util.Locale;

public class LocalBrowserExec {


    private static WebDriver driver;


    public static WebDriver LocalDriver(String browser){

        DesiredCapabilities desiredCapabilities;

        switch (browser.toLowerCase(Locale.ENGLISH)) {

            case "chrome" :
                desiredCapabilities = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("useAutomationExtension", false);
                options.setExperimentalOption("excludeSwitches",
                        Collections.singletonList("enable-automation"));
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                options.merge(desiredCapabilities);
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                desiredCapabilities = DesiredCapabilities.firefox();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                FirefoxProfile firefoxProfile = new FirefoxProfile();
                firefoxProfile.setPreference("dom.webnotifications.enable",false);
                firefoxOptions.setProfile(firefoxProfile);
                firefoxOptions.merge(desiredCapabilities);
                driver = new FirefoxDriver(firefoxOptions);
                break;
        }
        return driver;
    }



}

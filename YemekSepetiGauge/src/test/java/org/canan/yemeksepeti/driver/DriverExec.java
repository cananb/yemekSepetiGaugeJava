package org.canan.yemeksepeti.driver;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.canan.yemeksepeti.methods.Methods;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class DriverExec {

    public static WebDriver driver;

    private String baseUrl = "https://www.yemeksepeti.com/";
    private String browser = "chrome";



    @BeforeScenario
    public void setUp() throws Exception {
        driver = LocalBrowserExec.LocalDriver(browser);
        driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS).implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }


    @AfterScenario
    public void tearDown()  {
       // driver.quit();
    }

}

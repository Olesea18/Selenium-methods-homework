package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TestMakeScreenshot {
    WebDriver driver;

    @BeforeMethod
    public void driver(){
        // open browser
        driver = new EdgeDriver();

        // set fullscreen
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        if(driver!=null){
            // close all tabs and windows
            driver.quit();
            // close current tab
            // driver.close()
        }
    }

    @Test
    public void makeScreenshot() throws IOException, InterruptedException {

        driver.get("https://www.orange.md/");

        Thread.sleep(3000);

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(scrFile, new File("C:\\Academy\\TestRunners\\testSelenium\\screenshoot.png"));

    }
}

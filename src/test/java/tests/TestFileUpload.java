package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestFileUpload {
    WebDriver driver;
    // Executed before each test method
    @BeforeMethod
    public void setUpDriver(){
        // open the browser
        driver = new ChromeDriver();

    }

    // Executes after each test method
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        if(driver != null){
            // close current tabs
            // driver.close();
            // close all tabs
            driver.quit();
        }
    }

    @Test
    public void fileUpload() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        Thread.sleep(5000);

        WebElement uploadBtn = driver.findElement(By.id("picture"));

        uploadBtn.sendKeys("C:\\Academy\\TestRunners\\seleniumDraft\\screenshot.png");

        Thread.sleep(3000);

    }
}

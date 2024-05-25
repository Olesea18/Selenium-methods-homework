package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestJs {

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
    public void clickWithJS() throws InterruptedException {
        driver.get("https://www.orange.md/");
        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement element = driver.findElement(By.className("contact-orange"));
        js.executeScript("arguments[0].click();", element);
    }

    @Test
    public void scrollDown() throws InterruptedException {
        driver.get("https://www.orange.md/");
        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}

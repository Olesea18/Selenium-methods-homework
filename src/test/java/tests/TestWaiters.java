package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestWaiters {

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
    public void sleep() throws InterruptedException {
        System.out.println("Application started...");
        // sleep 3 seconds
        Thread.sleep(3000);
        System.out.println("Application  closed...");
    }

    @Test
    public void implicitlyWait(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//form/input[1]"));

    }

    @Test
    public void waitElementIsPresent(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        // wait element appear on the page
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        // wait until element will be present on the page with timeout of 5 seconds
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form/input[1]"))).click();

    }

    @Test
    public void elementIsClickable(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        // wait until element will be clickable with timeout of 5 seconds
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/input[1]"))).click();
    }
}

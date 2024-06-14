package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HomeworkTests {
    WebDriver driver;

    @BeforeMethod
    public void driver() {
        // open browser
        driver = new EdgeDriver();

        // set fullscreen
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        if (driver != null) {
            // close all tabs and windows
            driver.quit();
            // close current tab
            // driver.close()
        }
    }

    @Test
    public void submitForm() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");
        Thread.sleep(3000);

        // init action object
        WebElement fullNameField = driver.findElement(By.xpath("//*[@id=\"fullname\"]"));
        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        WebElement addressField = driver.findElement(By.xpath("//*[@id=\"address\"]"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        Actions action =  new Actions(driver);

        fullNameField.sendKeys("Olesea Gamurari");
        emailField.sendKeys("email@orange.com");
        addressField.sendKeys("Calea Iesilor 8");
        passwordField.sendKeys("Test123!");
        submitButton.click();
    }

    @Test
    public void checkLastLevel8() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/check-box.php");
        Thread.sleep(3000);

        // init action object
        WebElement expandMainLevelOne = driver.findElement(By.xpath("//*[@id=\"bs_1\"]/span[1]"));
        WebElement expandSubLevelTwo = driver.findElement(By.xpath("//*[@id=\"bf_2\"]/span[1]"));
        WebElement checkLastLevelEight = driver.findElement(By.xpath("//*[@id=\"c_io_8\"]"));

        Actions action =  new Actions(driver);

        expandMainLevelOne.click();
        expandSubLevelTwo.click();
        checkLastLevelEight.click();
    }

}


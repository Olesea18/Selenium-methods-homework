package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestActions {

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
    public void hover() throws InterruptedException {

        driver.get("https://www.orange.md/");
        Thread.sleep(3000);
        // init action object
        Actions actions = new Actions(driver);

        WebElement lang = driver.findElement(By.xpath("//li[@class='btn-group lng_switch_group']"));
        // perform hover
        actions.moveToElement(lang).pause(Duration.ofSeconds(5)).perform();
    }

    @Test
    public void doubleClick() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/buttons.php");
        Thread.sleep(3000);

        // init action object
        WebElement btn = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
        Actions action =  new Actions(driver);
        // perform doubleClick
        action.doubleClick(btn).pause(Duration.ofSeconds(5)).perform();
    }

    @Test
    public void keyboardActions() throws InterruptedException {
        driver.get("https://www.google.com/");

        Thread.sleep(3000);

        new Actions(driver).keyDown(Keys.SHIFT).sendKeys("selenium").keyUp(Keys.SHIFT).sendKeys("lowerkeys").perform();


    }

}

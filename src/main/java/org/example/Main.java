package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // init driver or browser
        WebDriver driver = new EdgeDriver();

        // open URL
        driver.get("https://www.google.com/");

        Thread.sleep(2000);

        //close browser
        driver.quit();
    }
}
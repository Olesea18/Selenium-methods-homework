package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestSeleniumDriver {

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
    public void driverProperties() throws InterruptedException {
        // open URL
        driver.get("https://www.google.com/");

        Thread.sleep(2000);

        // get current url
        String url = driver.getCurrentUrl();
        System.out.println("Current url: " + url);

        // get current title
        String title = driver.getTitle();
        System.out.println("Current title: " + title);

    }

    @Test
  public void testNewWindows() throws InterruptedException {
    driver.get("https://www.google.com/");

        // open new tab
        driver.switchTo().newWindow(WindowType.TAB);

        // open URL
        driver.navigate().to("https://github.com/DKilchik");

        // open new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        Thread.sleep(2000);

        // open URL
        driver.navigate().to("https://www.google.com/");

    }

    @Test
    public void tabHandles() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(2000);

        System.out.println(driver.getTitle());
        driver.switchTo().newWindow(WindowType.TAB);
        // get current window id
        String window = driver.getWindowHandle();
        System.out.println(window);

        driver.navigate().to("https://github.com/DKilchik");


        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        // switch to tab by index

        driver.switchTo().window(tabs.get(0));
        System.out.println(driver.getTitle());
        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getTitle());


    }

    @Test
    public void navigation() throws InterruptedException {
        driver.get("https://www.google.com/");

        Thread.sleep(2000);

        // find an element
        WebElement searchFld = driver.findElement(By.name("q"));

        // enter some data to field
        searchFld.sendKeys("Selenium");

        Thread.sleep(3000);
        // searching for element
        WebElement searchBtn = driver.findElement(By.name("btnK"));

        // click to element
        searchBtn.click();


        // back navigation
        driver.navigate().back();

        Thread.sleep(2000);

        // forward navigation
        driver.navigate().forward();

        Thread.sleep(2000);

        // refresh the page
        driver.navigate().refresh();
    }

    @Test
    public void findElement() throws InterruptedException {

        driver.get("https://www.google.com/");

        Thread.sleep(2000);

        // find an element
        WebElement searchFld = driver.findElement(By.name("q"));
        System.out.println("Element: " + searchFld);

    }

    @Test
    public void findElements() throws InterruptedException {
        driver.get("https://googlechromelabs.github.io/chrome-for-testing/");

        Thread.sleep(3000);
        // Find list of elements
        List<WebElement> elements = driver.findElements(By.xpath("//*[@class='status-ok']"));
        System.out.println(elements.size());
        System.out.println(elements);
    }

    @Test
    public void elementProps() throws InterruptedException {

        driver.get("https://www.google.com/");

        Thread.sleep(2000);

        // find an element
        WebElement searchBtn = driver.findElement(By.name("btnK"));
        // get coordinates of element
        int x = searchBtn.getLocation().getX();
        int y = searchBtn.getLocation().getY();

        System.out.println("Coord x: " + x + "Coord y: " + y);

        // get text of element
        String text = searchBtn.getText();
        System.out.println(text);

        // get attribute value
        String attr = searchBtn.getAttribute("role");
        System.out.println(attr);

    }

    @Test
    public void click() throws InterruptedException {

        driver.get("https://www.google.com/");

        Thread.sleep(2000);

        driver.findElement(By.name("q")).sendKeys("Selenium");

        Thread.sleep(2000);

        WebElement searchBtn = driver.findElement(By.name("btnK"));
        // click to element
        searchBtn.click();

    }
    @Test
    public void handleForms() throws InterruptedException {
        driver.get("https://www.google.com/");

        Thread.sleep(2000);

        WebElement fld = driver.findElement(By.name("q"));
        // enter some data to forms
        fld.sendKeys("Selenium");

        Thread.sleep(2000);
        // clean the form
        fld.clear();
    }

    @Test
    public void elementProps2() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/checkboxes");
        Thread.sleep(3000);
        WebElement checkbox = driver.findElement(By.xpath("//form/input[1]"));

        // check if element is visible (for all elements)
        System.out.println(checkbox.isDisplayed());

        // check if element is enabled
        System.out.println(checkbox.isEnabled());

        // check if element is selected (for checkboxes and radiobuttons)
        System.out.println(checkbox.isSelected());

    }

    @Test
    public void handleDropdown() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select select = new Select(driver.findElement(By.id("dropdown")));
        // select Option 2
        select.selectByValue("2");

        Thread.sleep(3000);
        // select bu text
        select.selectByVisibleText("Option 1");

        Thread.sleep(3000);
        // select by index
        select.selectByIndex(2);

    }

    @Test
    public void handleAlerts() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        Thread.sleep(2000);

        List<WebElement> buttons = driver.findElements(By.xpath("//button"));


        buttons.get(0).click();

        Thread.sleep(2000);
        // information alert
        driver.switchTo().alert().accept();

        Thread.sleep(1000);
        // dismiss alert
        buttons.get(1).click();

        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();

        Thread.sleep(2000);
        // text alert

        buttons.get(2).click();
        Thread.sleep(2000);

        driver.switchTo().alert().sendKeys("Hello alert");

        driver.switchTo().alert().accept();

    }

    @Test
    public void handleFrames() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");

        Thread.sleep(3000);

        // switch to frame
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));

        System.out.println(driver.findElement(By.xpath("//p")).getText());
    }


}

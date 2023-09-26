package org.example;

import org.junit.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AppTest {

    static WebDriver driver;
    public Testclass testclass;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "E:\\Java_QA_proj\\Test_task\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("file:///D:/%D0%97%D0%B0%D0%B3%D1%80%D1%83%D0%B7%D0%BA%D0%B8/QE-index.html");
        testclass = new Testclass(driver);
    }

    @Test
    public void test1() {

        assertTrue("Email field not displayed", testclass.isEmailfielddisplayed());
        assertTrue("Password field not displayed", testclass.isPasswordfielddisplayed());
        assertTrue("Sign in button not displayed", testclass.isSigninbuttondisplayed());
        testclass.login("testuser1@gmail.com", "qwerty");

    }

    @Test
    public void test2() {

        assertTrue("Value 1 not displayed", testclass.isValue1displayed());
        assertTrue("Value 2 not displayed", testclass.isValue2displayed());
        assertTrue("Value 3 not displayed", testclass.isValue3displayed());

        String secondListItemText = testclass.get_List2();
        Assert.assertEquals("List Item 2 6", secondListItemText);

        String secondListValue2 = testclass.get_Value2();
        Assert.assertEquals("6", secondListValue2);

    }

    @Test
    public void test3() {

        WebElement elementToScrollTo = driver.findElement(By.xpath("//h1[text()=\"Test 3\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", elementToScrollTo);

        String option = testclass.get_actualOption();
        if ("Option 1".equals(option)) {
            System.out.println("Success.Option 1 is present");
            Assert.assertEquals("Option 1", option);
        } else {
            Assert.fail("Fail.Option 1 isn't present");
        }
    }

    @Test
    public void test4() {

        WebElement button1 = testclass.get_button1();
        WebElement button2 = testclass.get_button2();

        assertTrue("Button 1 is not enabled", button1.isEnabled());
        assertFalse("Button 2 is not disabled", button2.isEnabled());

    }

    @Test
    public void test5() {

        WebElement elementToScrollTo = driver.findElement(By.xpath("//h1[text()=\"Test 5\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", elementToScrollTo);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("test5-button")));

        testclass.click_button();
        String success_message = testclass.get_success_message();
        Assert.assertEquals("You clicked a button!", success_message);

        WebElement button = testclass.get_button();
        assertFalse("Button is not disabled", button.isEnabled());

    }


    @Test
    public void test6(){
        WebElement elementToScrollTo = driver.findElement(By.xpath("//h1[text()=\"Test 6\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", elementToScrollTo);

        String cellValue = testclass.getCellValue(2, 2);
        System.out.println("Value at (2, 2): " + cellValue);

        Assert.assertEquals("Ventosanzap", cellValue);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}

package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Testclass {
    private WebDriver driver;

    public By test1_email_adress = By.xpath("//input [@type='email']");
    public By test1_password = By.xpath("//input [@type='password']");
    public By test1_sign_in = By.xpath("//button [@type='submit']");
    public By test2_value1 = By.xpath("//span[text()='3']");
    public By test2_value2 = By.xpath("//span[text()='6']");
    public By test2_value3 = By.xpath("//span[text()='9']");
    public By test2_list2 =By.xpath("//span[text()='6']/parent::li");
    public By test3_dropdown = By.id("dropdownMenuButton");
    public By test4_activebutton = By.cssSelector("button.btn-primary");
    public By test4_disabledbutton = By.cssSelector("button.btn-secondary[disabled]");
    public By test5_button = By.id("test5-button");
    public By test5_success_message = By.id("test5-alert");

    public Testclass(WebDriver driver) {
        this.driver = driver;
    }

    public Testclass click_test1_sign_in(){
        driver.findElement(test1_sign_in).click();
        return new Testclass(driver);
    }
    public Testclass type_test1_email_adress(String email) {
        driver.findElement(test1_email_adress).click();
        driver.findElement(test1_email_adress).sendKeys(email);
        return this;
    }

    public Testclass type_test1_password(String password) {
        driver.findElement(test1_password).click();
        driver.findElement(test1_password).sendKeys(password);
        return this;
    }
    public Testclass login (String email,String password){
        this.type_test1_email_adress(email);
        this.type_test1_password(password);
        this.click_test1_sign_in();
        return this;
    }
    public boolean isEmailfielddisplayed(){
        return driver.findElement(test1_email_adress).isDisplayed();
    }
    public boolean isPasswordfielddisplayed(){
        return driver.findElement(test1_password).isDisplayed();
    }
    public boolean isSigninbuttondisplayed(){
        return driver.findElement(test1_sign_in).isDisplayed();
    }
    public boolean isValue1displayed(){
        return driver.findElement(test2_value1).isDisplayed();
    }
    public boolean isValue2displayed(){
        return driver.findElement(test2_value2).isDisplayed();
    }
    public boolean isValue3displayed(){
        return driver.findElement(test2_value3).isDisplayed();
    }
    public String get_List2() {
        return driver.findElement(test2_list2).getText();
    }
    public String get_Value2(){
        return driver.findElement(test2_value2).getText();
    }
    public String get_actualOption(){
        return driver.findElement(test3_dropdown).getText();
    }
    public WebElement get_button1(){
        return driver.findElement(test4_activebutton);
    }
    public WebElement get_button2(){
        return driver.findElement(test4_disabledbutton);
    }
    public Testclass click_button(){
        driver.findElement(test5_button).click();
        return this;
    }
    public String get_success_message(){
        return driver.findElement(test5_success_message).getText();
    }
    public WebElement get_button(){
        return driver.findElement(test5_button);
    }
    public String getCellValue(int rowIndex, int columnIndex) {

        String locator = "//table[@class='table table-bordered table-dark']/tbody/tr[" + (rowIndex + 0) + "]/td[" + (columnIndex + 0) + "]";
        WebElement cellElement = driver.findElement(By.xpath(locator));
        return cellElement.getText();
    }
}

package com.nextbasecrm.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class US14_DesktopOptions {

        WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login1.nextbasecrm.com/");

        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("hr43@cydeo.com");

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("UserUser");

        driver.findElement(By.xpath("//input[@value='Log In']")).click();

    }

    @Test
    public void desktopOptions() {


    }
}

package com.nextbasecrm.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class US14_DesktopOption {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");

        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk43@cydeo.com");

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("UserUser");

        driver.findElement(By.xpath("//input[@value='Log In']")).click();

    }

    @Test
    public void testName() {

        // Confirm the amount of elements is 3
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='b24-app-block b24-app-desktop']//span[2]"));


        int expectedListSize = 3;
        int actualListSize = list.size();

        Assert.assertEquals(actualListSize, expectedListSize);

        for (WebElement element : list) {
            Assert.assertTrue(element.isDisplayed());
            System.out.println("element.getText() = " + element.getText());
        }




    }
}

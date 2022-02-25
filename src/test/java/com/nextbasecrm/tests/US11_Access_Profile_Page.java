package com.nextbasecrm.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class US11_Access_Profile_Page {

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
    public void accessProfilePage() {

        WebElement clickUserProfile = driver.findElement(By.xpath("//span[@class='user-img user-default-avatar']"));
        clickUserProfile.click();

        WebElement clickMyProfile = driver.findElement(By.linkText("My Profile"));
        clickMyProfile.click();

        List<WebElement> myProfileOptions = driver.findElements(By.xpath("//div[@id='profile-menu-filter']//a"));


        List<String> expectedList = Arrays.asList("General", "Drive", "Tasks", "Calendar", "Conversations");

        Assert.assertEquals(myProfileOptions.size(), expectedList.size());

        for (int i = 0; i < myProfileOptions.size() ; i++) {
            Assert.assertEquals(myProfileOptions.get(i).getText(), expectedList.get(i));
        }


    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}

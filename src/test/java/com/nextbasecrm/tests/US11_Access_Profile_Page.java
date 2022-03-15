package com.nextbasecrm.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class US11_Access_Profile_Page {

    public WebDriver driver;

    @BeforeMethod

    public void setUp() throws IOException {

        Properties properties = new Properties();
        FileInputStream file = new FileInputStream("configuration.properties");
        properties.load(file);

        driver = WebDriverFactory.getDriver(properties.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(properties.getProperty("env"));

        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys(properties.getProperty("username"));

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(properties.getProperty("password"));

        driver.findElement(By.xpath("//input[@value='Log In']")).click();

    }

    @Test
    public void accessProfilePage() {

        WebElement clickUserProfile = driver.findElement(By.xpath("//span[@class='user-img user-default-avatar']"));
        clickUserProfile.click();

        WebElement clickProfileBtn = driver.findElement(By.linkText("My Profile"));
        clickProfileBtn.click();

        List<WebElement> actualList = driver.findElements(By.xpath("//div[@id='profile-menu-filter']//a"));


        List<String> expectedList = Arrays.asList("General", "Drive", "Tasks", "Calendar", "Conversations");

        Assert.assertEquals(actualList.size(), expectedList.size());

        for (int i = 0; i < actualList.size() ; i++) {
            Assert.assertEquals(actualList.get(i).getText(), expectedList.get(i));

        }




    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
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
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class US3_LogOutOption {

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

    public void logOut_option() {


        WebElement ProfileMenu = driver.findElement(By.xpath("//span[@id='user-name']"));

        ProfileMenu.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement logOutOption = driver.findElement(By.xpath("//span[.='Log out']"));

        //1. The “Log out” option should be displayed when the user clicks the user profile from the homepage.

        Assert.assertTrue(logOutOption.isDisplayed());

        //2. After clicking the logout button, the user should navigate back to the login page.

        logOutOption.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        String expectedPageTitle = "Authorization";

        String actualPageTitle = driver.getTitle();

        Assert.assertEquals(expectedPageTitle, actualPageTitle);


    }

    @AfterMethod

    public void closeMethod() {
        driver.close();
    }

}

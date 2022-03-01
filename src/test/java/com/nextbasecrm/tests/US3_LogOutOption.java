package com.nextbasecrm.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.CRM_Utilities;
import utilities.ConfigurationReader;
import utilities.WebDriverFactory;
import java.util.concurrent.TimeUnit;


public class US3_LogOutOption {

    public WebDriver driver;

    @BeforeMethod

    public void setUp() {

        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env"));
        CRM_Utilities.crm_login(driver, ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));

    }

    @Test

    public void logOut_option_test() {


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

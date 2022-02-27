package com.nextbasecrm.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.WebDriverFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class US6_optionsUnderMoreModule {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env"));

        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys(ConfigurationReader.getProperty("username"));
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(ConfigurationReader.getProperty("password"));

        driver.findElement(By.xpath("//input[@value='Log In']")).click();

    }


    @Test
    public void optionsUnderMoreModule() {
        //user should be on the home page
        driver.get("https://login1.nextbasecrm.com/stream/");
        //user should click the more module
        WebElement clickMoreModule = driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']"));
        clickMoreModule.click();

        //verify all four options listed
        String moreTabxpath = "//span[@class='menu-popup-item-text']";
        List<WebElement> webElementList = driver.findElements(By.xpath(moreTabxpath));

        ArrayList<String> expectedResults = new ArrayList<>(Arrays.asList("File", "Appreciation", "Announcement", "Workflow"));

        for (int i = 0; i < webElementList.size(); i++) {

            String actualText = webElementList.get(i).getText();
            String expectedText = expectedResults.get(i);

            Assert.assertEquals(actualText, expectedText);



        }

    }

    @AfterMethod
    public void closeMethod() {
        driver.close();
    }
}
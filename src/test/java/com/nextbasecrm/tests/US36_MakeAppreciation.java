package com.nextbasecrm.tests;

import com.google.common.base.Verify;
import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebdriverFactory;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US36_MakeAppreciation {

     WebDriver driver;

    //user is on the login page;
    @BeforeMethod
    public void setupMethod(){

        String browserType = ConfigurationReader.getProperty("browser");

        driver=WebdriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(ConfigurationReader.getProperty("env1"));

        CRM_Utilities.crm_login(driver);
    }
    @Test
    public void sendingAppreciationMessage() {
        //   User is on the home page
        //User click MORE tab and select APPRECIATION tab
        driver.findElement(By.cssSelector("#feed-add-post-from-link-text")).click();
        driver.findElement(By.xpath("//span[.=Appreciation]")).click();

        //User write an Appreciation message
        driver.switchTo().frame(driver.findElement(By.cssSelector(".bx-editor-iframe")));
        driver.findElement(By.tagName("body")).sendKeys("Meeting starts!");

        //User click the SEND button
        driver.switchTo().defaultContent();
        driver.findElement(By.id("blog-submit-button-save")).click();

        //Verify the Appreciation is displayed on the feed
        WebElement feedMessage = driver.findElement(By.id("blog_post_body))"));
        String expectedMessage = "Meeting starts!";
        String actualText = feedMessage.getText();
        Assert.assertEquals(actualText, expectedMessage);
    }

        @Test

        public void sendingEmptyAppreciationMessage() {
            //   User is on the home page
            //User click MORE tab and select APPRECIATION tab
            driver.findElement(By.cssSelector("#feed-add-post-from-link-text")).click();
            driver.findElement(By.xpath("//span[.=Appreciation]")).click();

            //User click the SEND button
            driver.switchTo().defaultContent();
            driver.findElement(By.id("blog-submit-button-save")).click();


//        Verify “The message title is not specified” warning message is displayed on the page
            WebElement warningMessage = driver.findElement(By.xpath("//span[.='The message title is not specified']"));
            String expectedText = "The message title is not specified";
            String actualText2 = warningMessage.getText();
            Assert.assertEquals(actualText2, expectedText,"The message title is not specified");

        }


    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(5);
        driver.quit();
    }

}

/*
//    Test cases #1
//    Description:  Users make Appreciation successfully
//    Environment:  https://login2.nextbasecrm.com/
//    Steps:: Users are on the homepage
//    Users click MORE tab and select APPRECIATION
//    Users write an Appreciation message
//    Users click the SEND button
//    Verify the Appreciation is displayed on the feed
 */

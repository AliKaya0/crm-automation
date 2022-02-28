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

public class US2_CheckVCredential {

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

    }

    @Test


     public void Check_credential() {
        WebElement check_label = driver.findElement(By.className("login-item-checkbox-label"));
        Assert.assertTrue(check_label.isDisplayed());

        String actual_name_chkBox = check_label.getText();
        String expected_name_chkBox = "Remember me on this computer";
        Assert.assertEquals(actual_name_chkBox, expected_name_chkBox);


        WebElement checks = driver.findElement(By.xpath("//*[@id=\"USER_REMEMBER\"]"));
        checks.click();
        Assert.assertTrue(checks.isSelected());


    }


    @AfterMethod

    public void Closed(){
        driver.close();
    }







}

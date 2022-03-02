package com.nextbasecrm.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class US1_LoginCredentials {

    public WebDriver driver;

    @BeforeMethod
    public void setUp() {

        // getting the browserType dynamically from our configuration.properties file
        String browserType = ConfigurationReader.getProperty("browser");
        driver = WebDriverFactory.getDriver(browserType);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env"));


    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.close();
    }


    @Test
    public void TC1() {

        // verify the tile is as expected:
        String expectedInTitle = "Authorization";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedInTitle);
        System.out.println(actualTitle);

    }

    @Test                  // positive login test (hr user login validation)
    public void LoginValidationHrUser() {

        // enter username
        WebElement username_InputBox = driver.findElement(By.name("USER_LOGIN"));
        username_InputBox.sendKeys("hr43@cydeo.com");

        // enter password
        WebElement password_InputBox = driver.findElement(By.name("USER_PASSWORD"));
        password_InputBox.sendKeys("UserUser");

        // verify "Remember me on this computer" is displayed
        WebElement rememberMe_checkbox = driver.findElement(By.className("login-item-checkbox-label"));
        System.out.println("rememberMe_checkbox.isDisplayed() = " + rememberMe_checkbox.isDisplayed());

        // click login button
        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        loginBtn.click();

    }


    @Test                  // helpdesk user login validation
    public void LoginValidationHelpDesk() {

        // helpdesk user login validation
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk43@cydeo.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

    }



    @Test                    // marketing user login validation
    public void LoginValidationMarketingUser() {

        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("marketing43@cydeo.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

    }

    @Test                   // negative login test
    public void TC3() {

        // user enters incorrect credentials
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("user@cydeo.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Qde!low");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        // user is able to see "Incorrect username or password"
        WebElement LogInErrorMsg = driver.findElement(By.xpath("//div[@class='errortext']"));

        String expectedErrorMdg = "Incorrect username or password";
        String actualErrorMsg = LogInErrorMsg.getText();

        Assert.assertEquals(actualErrorMsg, expectedErrorMdg, "Expected and actual login error message do not match!");

    }
}

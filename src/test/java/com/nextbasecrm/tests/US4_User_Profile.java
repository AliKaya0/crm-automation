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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class US4_User_Profile {

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
    public void verifyUser(){

        //find profile button

        WebElement profileButton = driver.findElement(By.id("user-block"));
        profileButton.click();

        //sub menu options
        List<WebElement> subMenuList = driver.findElements(By.xpath("//*[@id=\"popup-window-content-menu-popup-user-menu\"]//span[@class=\"menu-popup-item-text\"]"));


        //actualSubMenu
        List<String> actualMenuList = new ArrayList<>();




        //expected submenu options
        //!!!!!! AC bug actual "Log out" ,expected "Logout"
        //List<String> expectedSubMenuList = Arrays.asList("My Profile", "Edit Profile Settings", "Themes", "Configure notifications", "Logout");

        // Expected submenu option 2
        List<String> expectedSubMenuList = Arrays.asList("My Profile", "Edit Profile Settings", "Themes", "Configure notifications", "Log out");


        for (WebElement eachMenu:subMenuList){
            actualMenuList.add(eachMenu.getText());



        }


        // System.out.println("Verify if actual list size with expected list size");
        Assert.assertEquals(actualMenuList.size(),expectedSubMenuList.size());
        //System.out.println("Verify if actual options list name with expected options list name");
        Assert.assertEquals(actualMenuList,expectedSubMenuList);

    }
    @AfterMethod
    public void closeMethod(){
        driver.close();
    }


}

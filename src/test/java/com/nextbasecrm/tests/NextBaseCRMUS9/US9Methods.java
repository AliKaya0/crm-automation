package com.nextbasecrm.tests.NextBaseCRMUS9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class US9Methods {
    public static void moduleTitleVerification(WebDriver driver, String username, String moduleName, String expectedTitle){
        //3. Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys(username);

        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        //5. Click to Log In button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        WebElement module=driver.findElement(By.xpath("//a[@title='"+moduleName+"']"));
        module.click();


        String actualTitle=driver.getTitle();


        Assert.assertEquals(actualTitle,expectedTitle);

//
    }
}

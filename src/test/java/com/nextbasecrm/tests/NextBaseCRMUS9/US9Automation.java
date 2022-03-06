package com.nextbasecrm.tests.NextBaseCRMUS9;

import com.nextbasecrm.tests.Utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US9Automation {
    public WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        // 1. Create new test and make set ups
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test_ActivityStream() {
        //2. Go to : https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        US9Methods.moduleTitleVerification(driver,"hr44@cydeo.com","Activity Stream","Portal");

    }
//.
    @Test
    public void test_Tasks() {
        //2. Go to : https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        US9Methods.moduleTitleVerification(driver,"hr44@cydeo.com","Tasks","Site map");

    }
    @Test
    public void test_ChatAndCalls() {
        //2. Go to : https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        US9Methods.moduleTitleVerification(driver,"hr43@cydeo.com","Chat and Calls","Chat and Calls");
    }
    @Test
    public void test_Workgroups() {
        //2. Go to : https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        US9Methods.moduleTitleVerification(driver,"hr43@cydeo.com","Workgroups","Workgroups and projects");
    }
    @Test
    public void test_Drive() {
        //2. Go to : https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        US9Methods.moduleTitleVerification(driver,"hr44@cydeo.com","Drive","Site map");
    }

    @Test
    public void test_Calendar() {
        //2. Go to : https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        US9Methods.moduleTitleVerification(driver,"hr43@cydeo.com","Calendar","Site map");
    }
    @Test
    public void test_ContactCenter() {
        //2. Go to : https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        US9Methods.moduleTitleVerification(driver,"hr44@cydeo.com","Contact Center","Contact Center");
    }

    @Test
    public void test_TimeandReports() {
        //2. Go to : https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        US9Methods.moduleTitleVerification(driver,"hr45@cydeo.com","Time and Reports","Absence Chart");
    }

    @Test
    public void test_Employees() {
        //2. Go to : https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        US9Methods.moduleTitleVerification(driver,"hr45@cydeo.com","Employees","Company Structure");
    }

    @Test
    public void test_Services() {
        //2. Go to : https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        US9Methods.moduleTitleVerification(driver,"hr45@cydeo.com","Services","Meeting Rooms");
    }

    @Test
    public void test_Company() {
        //2. Go to : https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        US9Methods.moduleTitleVerification(driver,"hr45@cydeo.com","Company","Company");
    }

    @AfterMethod
    public void PageClose(){

        driver.close();
    }
}

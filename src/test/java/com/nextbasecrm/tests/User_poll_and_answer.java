package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class User_poll_and_answer {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        String browserType = ConfigurationReader.getProperty("browser");

        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get(ConfigurationReader.getProperty("env1"));

        CRM_Utilities.crm_login(driver);
    }




        @Test
    public void  Vote(){
        //Writing "Programming language" in the search box and finding existing poll
        WebElement pollBtn = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-vote']//span"));
        pollBtn.click();
        BrowserUtils.sleep(2);


        //create a poll manually is -> click the POLL tab -> write a message ->
        // write poll question & 2 answers -> click SEND button
            WebElement iframe = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
            driver.switchTo().frame(iframe);
       WebElement textBox = driver.findElement(By.xpath("//body[contains(@style,'min-height: ')]"));

        BrowserUtils.sleep(2);
        textBox.sendKeys("programming language?");
        driver.switchTo().defaultContent();

         WebElement writePOLLQuestion = driver.findElement(By.xpath("//div[@class='vote-block-title-wrap']//input"));
        writePOLLQuestion.sendKeys("Which language to select");

        WebElement answers1 = driver.findElement(By.xpath("//input[@class='vote-block-inp adda']"));
         answers1.sendKeys("Java");

        WebElement answers2 = driver.findElement(By.xpath("(//li[@class='vote-block-inp-wrap'][2]//input)[1]"));
        answers2.sendKeys("python");

        WebElement clickSENDButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
       clickSENDButton.click();




       WebElement voteButton = driver.findElement(By.xpath("//label[@for='vote_radio_1206_2696'][1]"));
        voteButton.click();


       BrowserUtils.sleep(2);

      //  WebElement resultText= driver.findElement(By.cssSelector("Vote again"));
            //check if "Vote again" is displayed
            System.out.println(driver.findElement(By.xpath("(//form[@class='vote-form'])[1]//div[@class='bx-vote-buttons']//button[@data-bx-vote-button='showVoteForm']")).isDisplayed());
            BrowserUtils.sleep(2);

            System.out.println(driver.findElement(By.xpath("(//form[@class='vote-form'])[1]//div[@class='bx-vote-buttons']//button[@data-bx-vote-button='showVoteForm']")).getText());



    //String expectedText = "Vote again";
      //  String actualText = resultText.getText();

          //  Assert.assertEquals(actualText,expectedText);
////bx-vote-block-inp-substitute
//
//


    }
}
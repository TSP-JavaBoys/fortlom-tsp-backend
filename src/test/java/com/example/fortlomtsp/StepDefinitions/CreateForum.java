package com.example.fortlomtsp.StepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Random;
import io.cucumber.java.en.*;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class CreateForum {
    WebDriver driver = null;
    Random r = new Random();

    @Given("the fanatic is in the Fanatic Forum section")
    public void thatTheArtistIsOnForumSection() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        System.out.println("Inside Step - browser is open");
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/Drivers/chromedriver.exe");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("fanatic");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("pass123");
        driver.findElement(By.id("enter")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Fanatic forum")).click();

    }
    @And("press the button to create forum")
    public void pressTheButtonCreateForum() {
        driver.findElement(By.id("add")).click();
    }

    @When("complete the data correctly")
    public void fillTheForumDataCorrectly() throws InterruptedException {
        driver.findElement(By.id("forumname")).clear();
        driver.findElement(By.id("forumdescription")).clear();
        driver.findElement(By.id("forumname")).sendKeys(UUID.randomUUID().toString().replace("-", "").substring(0,10));
        driver.findElement(By.id("forumdescription")).sendKeys("Un nuevo foro se ha creado");
        Thread.sleep(2000);
    }
    @And("press on Create")
    public void pressTheButtonCreate() {
        driver.findElement(By.id("createforum")).click();
    }

    @Then("message from your forum created successfully will appear")
    public void anForumWillBeCreatedSuccessfully() throws InterruptedException {
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        driver.close();
        driver.quit();
    }



}
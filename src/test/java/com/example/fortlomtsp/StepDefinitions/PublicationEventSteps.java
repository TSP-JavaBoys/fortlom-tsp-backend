package com.example.fortlomtsp.StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import java.util.Random;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.UUID;
public class PublicationEventSteps {
    WebDriver driver = null;
    Random r = new Random();

    @Given("that the artist is on Event section")
    public void thatTheArtistIsOnEventSection() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        System.out.println("Inside Step - browser is open");
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/Drivers/chromedriver.exe");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.get("http://localhost:4200/login");
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("artist");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("nueva");
        driver.findElement(By.id("enter")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Event")).click();
    }
    @When("press the button Post Event")
    public void pressTheButtonPostEvent() {
        driver.findElement(By.id("add")).click();
    }
    @And("fill in the data correctly")
    public void fillInTheDataCorrectly() throws InterruptedException {
        driver.findElement(By.id("seteventname")).clear();
        driver.findElement(By.id("seteventdescription")).clear();
        driver.findElement(By.id("setdate")).clear();
        driver.findElement(By.id("seteventname")).sendKeys(UUID.randomUUID().toString().replace("-", "").substring(0,10));
        driver.findElement(By.id("seteventdescription")).sendKeys("eu facilisis magna. Nam convallis diam vitae sem fermentum, vitae suscipit nibh feugiat. Aenean Nulla facilisi. Aliquam quam urna, maximus eget tincidunt tempor, efficitur a dui.");
        driver.findElement(By.id("setdate")).sendKeys("25/05/2022");
        driver.findElement(By.id("seteventticketlink")).sendKeys("https://teleticket.com.pe");
        Thread.sleep(2000);
    }
    @And("press the button Create and Post")
    public void pressTheButtonCreateAndPost() {
        driver.findElement(By.id("buttonCreateAndPost")).click();
    }
    @Then("an event will be created successfully")
    public void anEventWillBeCreatedSuccessfully() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
        driver.quit();
    }
    @And("do not fill in the form")
    public void doNotFillInTheForm() {
        driver.findElement(By.id("seteventname")).clear();
        driver.findElement(By.id("seteventdescription")).clear();
        driver.findElement(By.id("setdate")).clear();
    }
    @Then("the event will not be created")
    public void theEventWillNotBeCreated() throws InterruptedException {
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        driver.close();
        driver.quit();
    }
}

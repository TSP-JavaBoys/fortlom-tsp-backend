package com.example.fortlomtsp.StepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ManageEventsSteps {
    WebDriver driver = null;
    @Given("the artist is in the “Events” section")
    public void the_artist_is_in_the_events_section() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.out.println("Inside Step - browser is open");
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project path is : "+projectPath);
        System.out.println("Project path is : "+projectPath+"/src/test/resources/Drivers/chromedriver.exe ");
        System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/Drivers/chromedriver.exe ");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.navigate().to("http://localhost:4200/");

        driver.findElement(By.id("exampleInputEmail1")).sendKeys("artist");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("contraseña");
        driver.findElement(By.id("enter")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Event")).click();
        Thread.sleep(2000);
    }

    @Given("click on the button with the “pencil” icon")
    public void click_on_the_button_with_the_pencil_icon() {
        driver.findElement(By.id("edit")).click();
    }
    @When("you correctly complete the new data")
    public void you_correctly_complete_the_new_data() {
        driver.findElement(By.id("seteventname")).sendKeys("enventoprubea");
        driver.findElement(By.id("seteventdescription")).sendKeys("descrip");
        driver.findElement(By.id("seteventticketlink")).sendKeys("https://teleticket.com.pe");
    }
    @When("click “Save”")
    public void click_save() {
        driver.findElement(By.id("saveevent")).click();
    }
    @Then("a message of your successful event will appear.")
    public void a_message_of_your_successful_event_will_appear() throws InterruptedException {
        Thread.sleep(2000);
    }
    @Given("a artist is in the “Events” section")
    public void a_artist_is_in_the_events_section() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.out.println("Inside Step - browser is open");
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project path is : "+projectPath);
        System.out.println("Project path is : "+projectPath+"/src/test/resources/Drivers/chromedriver.exe ");
        System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/Drivers/chromedriver.exe ");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.navigate().to("http://localhost:4200/");

        driver.findElement(By.id("exampleInputEmail1")).sendKeys("artist");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("contraseña");
        driver.findElement(By.id("enter")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Event")).click();
        Thread.sleep(2000);
    }

    @Given("click on the button with the “trash can” icon")
    public void click_on_the_button_with_the_trash_can_icon() {
        driver.findElement(By.id("delete")).click();
    }
    @When("to check the “Events” section again")
    public void to_check_the_events_section_again() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Event")).click();
    }
    @Then("the event you deleted will not appear.")
    public void the_event_you_deleted_will_not_appear() throws InterruptedException {
        Thread.sleep(2000);
    }





}

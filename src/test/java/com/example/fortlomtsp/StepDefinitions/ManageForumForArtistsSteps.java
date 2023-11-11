package com.example.fortlomtsp.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ManageForumForArtistsSteps {
    WebDriver driver = null;
    String[] listName = new String[]{"forum1", "forum2", "forum3", "forum4", "forum5", "forum6", "forum7"};
    Random r = new Random();
    int indice;

    @Given("the artist is in the Fanatic Forum section")
    public void the_artist_is_in_the_Fanatic_Forum_section() throws InterruptedException {
        System.out.println("Inside Step - browser is open");
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project path is : " + projectPath);
        System.out.println("Project path is : " + projectPath + "/src/test/resources/Drivers/chromedriver.exe ");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/Drivers/chromedriver.exe ");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.navigate().to("http://localhost:4200/");

        driver.findElement(By.id("exampleInputEmail1")).sendKeys("alianza");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("nueva");
        driver.findElement(By.id("enter")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Forum")).click();
        Thread.sleep(2000);
    }

    @Given("clicks on the View Your Forums button")
    public void clicks_on_the_View_Your_Forums_button() {
        throw new io.cucumber.java.PendingException();
    }

    @Given("clicks on the button with the pencil icon")
    public void clicks_on_the_button_with_the_pencil_icon() {
        throw new io.cucumber.java.PendingException();
    }

    @When("completes the new data")
    public void completes_the_new_data() throws InterruptedException {
        indice = r.nextInt(7);
        driver.findElement(By.id("forumname")).sendKeys(listName[indice]);
        driver.findElement(By.id("forumdescription")).sendKeys("forumdescription");
        Thread.sleep(2000);
    }

    @When("clicks on Save")
    public void clicks_on_Save() {
        throw new io.cucumber.java.PendingException();
    }

    @Then("a message will appear indicating that their forum has been saved.")
    public void a_message_will_appear_indicating_that_their_forum_has_been_saved() throws InterruptedException {
        throw new io.cucumber.java.PendingException();
    }
}

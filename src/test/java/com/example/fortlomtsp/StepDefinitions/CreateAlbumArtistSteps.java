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

public class CreateAlbumArtistSteps {
    WebDriver driver = null;
    String[] listName = new String[]{"album1","album2","album3","album4","album5","album6","album7"};
    Random r = new Random();
    int indice;

    @Given("that the artist is on Event section")
    public void that_the_artist_is_on_the_Album_section() throws InterruptedException{
        System.out.println("Inside Step - browser is open");
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project path is : "+projectPath);
        System.out.println("Project path is : "+projectPath+"/src/test/resources/Drivers/chromedriver.exe ");
        System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/Drivers/chromedriver.exe ");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.navigate().to("http://localhost:4200/");

        driver.findElement(By.id("exampleInputEmail1")).sendKeys("alianza");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("nueva");
        driver.findElement(By.id("enter")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Album")).click();
        Thread.sleep(2000);
    }

    @When("click the Add Album button")
    public void click_on_the_plus_button(){
        driver.findElement(By.id("add")).click();
    }

    @When("correctly fill in the data")
    public void correctly_fill_in_the_data() throws InterruptedException{
        indice = r.nextInt(7);
        driver.findElement(By.id("albumname")).sendKeys(listName[indice]);
        driver.findElement(By.id("albumdescription")).sendKeys("albumdescription");
        Thread.sleep(2000);
    }

    @When("fill in the details")
    public void fill_in_the_details() throws InterruptedException{
        driver.findElement(By.id("albumdescription")).sendKeys("a description test");
        Thread.sleep(2000);
    }

    @When("the album name is used")
    public void the_album_name_is_used()throws InterruptedException{
        driver.findElement(By.id("albumname")).sendKeys("albumtest");
        Thread.sleep(2000);
    }

    @When("you have successfully created a album")
    public void you_have_successfully_created_a_album() throws InterruptedException{
        Thread.sleep(2000);
    }

    @When("click on Create")
    public void click_on_Create(){
        driver.findElement(By.id("createalbum")).click();
    }

    @Then("the album will be created correctly")
    public void message_of_your_forum_created_successfully_will_appear() throws InterruptedException{
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }

    @Then("a message will appear, your album already exists")
    public void a_message_will_appear_your_album_already_exists() throws InterruptedException{
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }

    @Then("your forum will appear in the list")
    public void your_forum_will_appear_in_the_list() throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }
}

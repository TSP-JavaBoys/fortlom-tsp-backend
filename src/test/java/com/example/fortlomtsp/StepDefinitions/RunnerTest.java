package com.example.fortlomtsp.StepDefinitions;

import com.example.fortlomtsp.FortlomTspApplication;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
@RunWith(Cucumber.class)
@SpringBootTest(classes = {FortlomTspApplication.class,RunnerTest.class},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberOptions(
        features="src/test/resources",
        glue="classpath:com.example.fortlomtsp.StepDefinitions",
        monochrome= true,
        plugin = {"pretty", "junit:target/JUnitReports/report.xml",
                "json:target/JSONReports/report.json",
                "html:target/HtmlReports"}

)
public class RunnerTest {
}

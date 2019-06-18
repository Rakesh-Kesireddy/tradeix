package com.tradeix.techinical_assement;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources")
public class RunCukesTest {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RestAssured.registerParser("text/html", Parser.JSON);
    }
}

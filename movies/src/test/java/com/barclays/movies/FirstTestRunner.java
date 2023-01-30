package com.barclays.movies;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/java/com/barclays/movies/features",
            glue = "com/barclays/movies/stepdefinitions"
    )


    public class FirstTestRunner {

}

package com.barclays.movies.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v107.input.Input;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertTrue;

public class WebNavigationStepDefinitions {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        System.out.println("setting up");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("tearing down");
        driver.close();
    }

    @Given("I have the browser open")
    public void i_have_the_browser_open() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @When("I navigate to {string}")
    public void i_navigate_to(String url) {
        driver.get(url);
    }

    @Then("I am on the {string} page")
    public void i_am_on_the_page(String title) {
        String pageTitle = driver.getTitle();
        assertTrue(pageTitle.contains(title));
    }

    @When("I enter {string} in the ISBN box")
    public void i_enter_in_the_isbn_box(String isbn) {
        WebElement isbnBox = driver.findElement(By.id("isbn"));
        isbnBox.clear();
        isbnBox.sendKeys(isbn);
    }

    @When("I enter {string} in the Title box")
    public void i_enter_in_the_title_box(String title) {
        WebElement titleBox = driver.findElement(By.id("title"));
        titleBox.clear();
        titleBox.sendKeys(title);
    }

    @When("I Select {string} from the dropdown")
    public void i_select_from_the_dropdown(String type) {
        Select movieType = new Select(driver.findElement(By.id("movieType")));
        movieType.selectByVisibleText(type);
    }

    @When("I click the submit button")
    public void i_click_the_submit_button() {
        driver.findElement(By.id("submit")).click();
    }

    @Then("I see that {string} was successfully added")
    public void i_see_that_was_successfully_added(String title) {
        WebElement success = driver.findElement(By.id("success"));
        String message = success.getText();
        assertTrue(message.contains(title));
    }

    @Then("I see that {string} appeared in error message")
    public void i_see_that_appeared_in_error_message(String error) {
        WebElement success = driver.findElement(By.id("movie.errors"));
        String message = success.getText();
        assertTrue(message.contains(error));
    }

}

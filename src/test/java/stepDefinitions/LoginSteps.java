package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class LoginSteps {
    private WebDriver driver;

    @Before("@login")
    public void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL); //this will make selenium webDriver to wait for the entire page is loaded (until the load event fire is returned).
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After("@login")
    public void tearDown() {
        driver.quit();
    }

    @Given("user accesses the webdriver university login page")
    public void user_accesses_the_webdriver_university_login_page() {
        driver.get("https://www.webdriveruniversity.com/Login-Portal/index.html");
    }

    @When("user enters a username {string}")
    public void user_enters_a_username(String username) {
        driver.findElement(By.id("text")).sendKeys(username);
    }

    @And("user enters a password {}")
    public void user_enters_a_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user should be presented with a successful login message {string}")
    public void user_should_be_presented_with_a_successful_login_message(String message) {
        String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message,message);
//        Assert.assertEquals(login_Message,"validation succeeded");
    }

    @Then("user should be presented with a unsuccessful login message {string}")
    public void user_should_be_presented_with_a_unsuccessful_login_message(String message) {
        String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message,message);
//        Assert.assertEquals(login_Message,"validation succeeded");
    }
}

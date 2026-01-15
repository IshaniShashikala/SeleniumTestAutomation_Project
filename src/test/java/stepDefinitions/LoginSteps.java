package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.Base_PO;

public class LoginSteps extends Base_PO {
    private WebDriver driver = getDriver();

    @Given("user accesses the webdriver university login page")
    public void user_accesses_the_webdriver_university_login_page() {
        navigateTo_URL("https://www.webdriveruniversity.com/Login-Portal/index.html");
    }

//    @When("user enters a username {string}")
//    public void user_enters_a_username(String username) {
//        driver.findElement(By.id("text")).sendKeys(username);
//    }
//
//    @When("user enters a username {word}")
//    public void user_enters_a_outline_username(String username) {
//        driver.findElement(By.id("text")).sendKeys(username);
//    }

    @When("user enters a username {}")
    public void user_enters_a_username(String username) {
//        driver.findElement(By.id("text")).sendKeys(username);
        sendkeys(By.id("text"), username);
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

    @Then("user should be presented with a unsuccessful login message {}")
    public void user_should_be_presented_with_a_unsuccessful_outline_login_message(String expectedMessage) {
        String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message,expectedMessage);
    }
}

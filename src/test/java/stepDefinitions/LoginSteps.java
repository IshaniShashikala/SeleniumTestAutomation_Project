package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Base_PO;
import pageObjects.Login_PO;

public class LoginSteps extends Base_PO {
//    private WebDriver driver = getDriver();

    private Login_PO login_po;

    public LoginSteps(Login_PO login_po){
        this.login_po = login_po;
    }

    @Given("user accesses the webdriver university login page")
    public void user_accesses_the_webdriver_university_login_page() {
//        navigateTo_URL("https://www.webdriveruniversity.com/Login-Portal/index.html");
        login_po.navigateTo_Web_Login_page();
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
//        sendkeys(By.id("text"), username);
        login_po.setUsername(username);
    }

    @And("user enters a password {}")
    public void user_enters_a_password(String password) {
//        driver.findElement(By.id("password")).sendKeys(password);
        login_po.setPassword(password);
    }

    @And("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
//        driver.findElement(By.id("login-button")).click();
        login_po.clickOn_Login_Button();
    }

    @Then("user should be presented with a successful login message {string}")
    public void user_should_be_presented_with_a_successful_login_message(String message) {
//        String login_Message = driver.switchTo().alert().getText();
//        Assert.assertEquals(login_Message,message);
////        Assert.assertEquals(login_Message,"validation succeeded");
        login_po.validate_SuccessfulLogin_Message(message);
    }

    @Then("user should be presented with a unsuccessful login message {string}")
    public void user_should_be_presented_with_a_unsuccessful_login_message(String message) {
//        String login_Message = driver.switchTo().alert().getText();
//        Assert.assertEquals(login_Message,message);
////        Assert.assertEquals(login_Message,"validation succeeded");
        login_po.validate_UnsuccessfulLogin_Message(message);
    }

    @Then("user should be presented with a unsuccessful login message {}")
    public void user_should_be_presented_with_a_unsuccessful_outline_login_message(String expectedMessage) {
//        String login_Message = driver.switchTo().alert().getText();
//        Assert.assertEquals(login_Message,expectedMessage);
        waitFor_Alert_And_ValidateText(expectedMessage);
    }
}

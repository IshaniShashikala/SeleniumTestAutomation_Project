package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class ContactUsSteps {
    private WebDriver driver;

//    @Before // execute for all Testcases
    @Before("@contact-us") // execute for contact-us Tcs
    public void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL); //this will make selenium webDriver to wait for the entire page is loaded (until the load event fire is returned).
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

//    @After // execute for all Testcases
    @After("@contact-us") // execute for contact-us Tcs
    public void tearDown() {
        driver.quit();
    }

    public String generateRandomNumber(int length){
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomString(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }

    @Given("user accesses the webdriver university contact us page")
    public void user_accesses_the_webdriver_university_contact_us_page() {
        driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @When("user enters a unique first name")
    public void user_enter_a_unique_first_name() {
        //        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Joe");
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("AutoFN" + generateRandomNumber(5));
    }

    @And("user enters a unique last name")
    public void user_enter_a_unique_last_name() {
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("AutoLN" + generateRandomNumber(5));
    }

    @And("user enters a unique email address")
    public void user_enter_a_unique_email_address() {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("AutoEmail" + generateRandomNumber(5) + "@gmail.com");
    }

    @And("user enters a unique comment")
    public void user_enter_a_unique_comment() {
        driver.findElement(By.xpath("//textarea[@name=\"message\"]")).sendKeys("AutoMessage" + generateRandomString(20));
    }

    @And("user clicks on the submit button")
    public void user_click_on_the_submit_button() {
        driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
  }

    @When("user enters a specific first name {word}")
    public void user_enters_a_specific_first_name(String firstName) {
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstName);
    }

    @When("user enters a specific last name {word}")
    public void user_enters_a_specific_last_name(String lastName) {
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastName);
    }

    @When("user enters a specific email address {word}")
    public void user_enters_a_specific_email_address(String email) {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
    }

    @When("user enters a specific comment {string}")
    public void user_enters_a_specific_comment(String comment) {
        driver.findElement(By.xpath("//textarea[@name=\"message\"]")).sendKeys(comment);
    }

    @Then("user should be presented with a successful contact us submission message {string}")
    public void user_should_be_presented_with_a_successful_contact_us_submission_message(String message) {
        WebElement contactUs_Submission_Messgae = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(contactUs_Submission_Messgae.getText(),message);
//        Assert.assertEquals(contactUs_Submission_Messgae.getText(),"Thank You for your Message!");
    }
}

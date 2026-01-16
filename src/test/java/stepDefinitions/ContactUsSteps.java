package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Base_PO;
import pageObjects.Contact_Us_PO;

public class ContactUsSteps extends Base_PO {
//    private WebDriver driver = getDriver();

    private Contact_Us_PO contact_us_po;

    public ContactUsSteps(Contact_Us_PO contact_us_po){
        this.contact_us_po = contact_us_po;
    }

    @Given("user accesses the webdriver university contact us page")
    public void user_accesses_the_webdriver_university_contact_us_page() {
//        driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
//        navigateTo_URL("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
        contact_us_po.navigateTo_Web_Contact_Us_page();
    }

    @When("user enters a unique first name")
    public void user_enter_a_unique_first_name() {
//        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Joe");
//        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("AutoFN" + generateRandomNumber(5));
//        sendkeys(By.xpath("//input[@name='first_name']"),"AutoFN" + generateRandomNumber(5));
        contact_us_po.setUnique_FirstName();
    }

    @And("user enters a unique last name")
    public void user_enter_a_unique_last_name() {
//        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("AutoLN" + generateRandomNumber(5));
        contact_us_po.setUnique_LastName();
    }

    @And("user enters a unique email address")
    public void user_enter_a_unique_email_address() {
//        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("AutoEmail" + generateRandomNumber(5) + "@gmail.com");
        contact_us_po.setUnique_EmailAddress();
    }

    @And("user enters a unique comment")
    public void user_enter_a_unique_comment() {
//        driver.findElement(By.xpath("//textarea[@name=\"message\"]")).sendKeys("AutoMessage" + generateRandomString(20));
        contact_us_po.setUnique_Comment();
    }

    @And("user clicks on the submit button")
    public void user_click_on_the_submit_button() {
//        driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
//        waitForWebElementAndClick(By.xpath("//input[@value='SUBMIT']"));
        contact_us_po.sclickOn_Submit_Button();
  }

    @When("user enters a specific first name {word}")
    public void user_enters_a_specific_first_name(String firstName) {
//        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstName);
        contact_us_po.setSpecific_FirstName(firstName);
    }

    @When("user enters a specific last name {word}")
    public void user_enters_a_specific_last_name(String lastName) {
//        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastName);
        contact_us_po.setSpecific_LastName(lastName);
    }

    @When("user enters a specific email address {word}")
    public void user_enters_a_specific_email_address(String email) {
//        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        contact_us_po.setSpecific_EmailAddress(email);
    }

    @When("user enters a specific comment {string}")
    public void user_enters_a_specific_comment(String comment) {
//        driver.findElement(By.xpath("//textarea[@name=\"message\"]")).sendKeys(comment);
        contact_us_po.setSpecific_Comment(comment);
    }

    @Then("user should be presented with a successful contact us submission message {string}")
    public void user_should_be_presented_with_a_successful_contact_us_submission_message(String message) {
        contact_us_po.validate_Successful_SubmissionMessage_Text(message);
//        WebElement contactUs_Submission_Messgae = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
//        Assert.assertEquals(contactUs_Submission_Messgae.getText(),message);
//        Assert.assertEquals(contactUs_Submission_Messgae.getText(),"Thank You for your Message!");
    }
}

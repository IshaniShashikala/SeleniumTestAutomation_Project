package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class Contact_Us_PO extends Base_PO{
    private @FindBy(how = How.XPATH, using = "//input[@name='first_name']")
    WebElement firstName_TextField;

    private @FindBy(xpath = "//input[@name='last_name']")
    WebElement lastName_TextField;

    private @FindBy(xpath = "//input[@name='email']")
    WebElement emailAddress_TextField;

    private @FindBy(xpath = "//textarea[@name=\"message\"]")
    WebElement comment_TextField;

    private @FindBy(xpath = "//input[@value='SUBMIT']")
    WebElement submit_Button;

    private @FindBy(xpath = "//div[@id='contact_reply']/h1")
    WebElement successfulSubmission_Message_Text;

    public Contact_Us_PO(){
        super();
    }

    public void navigateTo_Web_Contact_Us_page(){
        navigateTo_URL("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }

    public void setUnique_FirstName(){
        sendkeys(firstName_TextField,"AutoFN" + generateRandomNumber(5));
    }

    public void setUnique_LastName(){
        sendkeys(lastName_TextField,"AutoLN" + generateRandomNumber(5));
    }

    public void setUnique_EmailAddress(){
        sendkeys(emailAddress_TextField,"AutoEmail" + generateRandomNumber(5) + "@gmail.com");
    }

    public void setUnique_Comment(){
        sendkeys(comment_TextField,"AutoMessage" + generateRandomString(20));
    }

    public void setSpecific_FirstName(String firstName){
        sendkeys(firstName_TextField,firstName);
    }

    public void setSpecific_LastName(String lastName){
        sendkeys(lastName_TextField,lastName);
    }

    public void setSpecific_EmailAddress(String emailAddress){
        sendkeys(emailAddress_TextField,emailAddress);
    }

    public void setSpecific_Comment(String comment){
        sendkeys(comment_TextField,comment);
    }

    public void sclickOn_Submit_Button(){
//        submit_Button.click();
        waitForWebElementAndClick(submit_Button);
    }

    public void validate_Successful_SubmissionMessage_Text(String message){
        waitFor(successfulSubmission_Message_Text);
        Assert.assertEquals(successfulSubmission_Message_Text, message);
//        Assert.assertEquals(successfulSubmission_Message_Text, "Thank You for your Message!");
    }

}

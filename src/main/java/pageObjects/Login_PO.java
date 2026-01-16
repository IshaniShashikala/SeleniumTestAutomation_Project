package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Global_Vars;

public class Login_PO extends Base_PO{
    private @FindBy(id = "text")
    WebElement username_textField;

    private @FindBy(id = "password")
    WebElement password_textField;

    private @FindBy(id = "login-button")
    WebElement login_Button;

    public  Login_PO() {
        super();
    }

    public void navigateTo_Web_Login_page(){
        navigateTo_URL(Global_Vars.WEB_HOMEPAGE_URL + "/Login-Portal/index.html");
    }

    public void setUsername(String username){
        sendkeys(username_textField, username);
    }

    public void setPassword(String password){
        sendkeys(password_textField, password);
    }

    public void clickOn_Login_Button(){
        waitForWebElementAndClick(login_Button);
    }

    public  void validate_SuccessfulLogin_Message(String message){
        waitFor_Alert_And_ValidateText(message);
//        waitFor_Alert_And_ValidateText("validation succeeded");
    }

    public  void validate_UnsuccessfulLogin_Message(String message){
        waitFor_Alert_And_ValidateText(message);
//        waitFor_Alert_And_ValidateText("validation failed");
    }
}

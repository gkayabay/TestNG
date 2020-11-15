package SelfTestNG;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.BaseClass;

public class LoginPageElement {
	
	@FindBy(id="ctl00_MainContent_username")
	public WebElement username;
	
	@FindBy(id="ctl00_MainContent_password")
	public WebElement password;
	
	@FindBy(id="ctl00_MainContent_login_button")
	public WebElement loginBtn;
	
	@FindBy(id="ctl00_MainContent_status")
	public WebElement errorMessage;
	
	
	public LoginPageElement() {
		PageFactory.initElements(BaseClass.driver, this); 
	
	}

}

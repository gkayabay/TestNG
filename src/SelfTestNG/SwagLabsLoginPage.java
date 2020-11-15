package SelfTestNG;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.BaseClass;

public class SwagLabsLoginPage {
	
	@FindBy(id="user-name")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(xpath="//input[@class='btn_action']")
	public WebElement loginBtn;
	
	//inventory page elements
	@FindBy(xpath="//div[@class='product_label']")
	public WebElement productLable;
	
	@FindBy(xpath="//select[@class='product_sort_container']/option[3]")
	public WebElement lowToHIgh;
	
	public SwagLabsLoginPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
}

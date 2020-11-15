package SelfTestNG;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.BaseClass;

public class WebOrdersPage {
	
	@FindBy(xpath="//div[@class='login_info']")
	public WebElement wMessage;
	

	//initaize the elements
	
	public WebOrdersPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}

package SelfTestNG;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class LoginPageTest extends CommonMethods {

	// smartbear website

	@BeforeMethod
	public void openBrowser() {
		setUp();
	}

	@AfterMethod
	public void quitBrowser() {
    tearDown();
	}
	
	@Test (enabled=true)  //if valid login verify the text message 
    public void validLogin () {
		LoginPageElement login = new LoginPageElement();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
		
		//webordersPage  elements
		WebOrdersPage orderPage = new WebOrdersPage();
		
		boolean textMesagge = orderPage.wMessage.isDisplayed();
		
		Assert.assertEquals(textMesagge, true, "Welcome message is NOT displayed");
		

		TakesScreenshot ts = (TakesScreenshot) driver; //downcasting driver
		File LoginTestFile = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(LoginTestFile, new File("screenshots/SMARTBEAR/sbLogin.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Screenshot is taken");
		}
	
	}
	
	@Test 
	public void invalidLogin () {
		LoginPageElement login = new LoginPageElement();
		sendText(login.username, ConfigsReader.getProperty("username"));
		click(login.loginBtn);
		
		boolean actualError = login.errorMessage.isDisplayed();
		
		String expectedError = "Invalid Login or Password.";
		
		Assert.assertEquals(actualError, expectedError);
		
		//wait(5000);	
	}
}


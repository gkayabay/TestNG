package com.class02;
import org.testng.Assert;
import org.testng.annotations.*;
import com.pages.DashboardPageElements;
import com.pages.LoginPageElements;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class HWSecondWAyWIthAssert extends CommonMethods {
	
	@BeforeMethod 
	public void openBrowser () {
		setUp();
		
	}
	
	@AfterMethod
	public void quitBrowser () {
		tearDown();
	}
	
	@Test
	public void validLogin () {
		//Enter username and pasword
		LoginPageElements login = new LoginPageElements();
		
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
		DashboardPageElements dashboard = new DashboardPageElements();
		
		boolean display = dashboard.logo.isDisplayed(); //is logo is displayed in dashboardpage
		
		//verify with assertion
		//Assert.assertTrue(display,"Logo is NOT displayed"); //if true, else print the message
	    Assert.assertEquals(display, true, "Logo is not displayed");
	}
	
	@Test
	 public void invalidLogin() {
	    LoginPageElements login = new LoginPageElements();
		
		sendText(login.username, ConfigsReader.getProperty("username"));
		click(login.loginBtn);
		
		String expectedText = "Password cannot be empty";
		String actualText = login.errorMsg.getText();
		
		Assert.assertEquals(actualText, expectedText, "Error message does NOT matches");
		
	 }

	}


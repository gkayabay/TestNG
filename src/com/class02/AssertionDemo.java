package com.class02;

import org.testng.Assert;
import org.testng.annotations.*;

import com.pages.LoginPageElements;
import com.utils.CommonMethods;;

public class AssertionDemo extends CommonMethods {
//Note: we already extends comonmethods we do not need beforeand after method here
//	// This is also called Hard Assertion
//	@BeforeMethod
//	public void openBrowserAndNavigate() {
//		setUp();
//	}
//
//	@AfterMethod
//	public void quitBrowser() { // test ten sonra browser i quit yap
//		tearDown();
//	}

	// Assertion error is handled within TestNG
	// Even if one Test Case fails, the others will executed

	@Test
	public void titleValidation() { // test ten sonra browser i quit yap
		String expectedTitle = "Human Management System";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		// 1st way
		Assert.assertEquals(actualTitle, expectedTitle);
		
		// 2nd way, You are giving a msg
		Assert.assertEquals(actualTitle, expectedTitle, "Title does NOT match");
		
		// if the (hard) assertion fails
		// the statements after assertion will not be executed
		System.out.println("Text after assertion");
	}

	@Test(priority = 2, dependsOnMethods = { "titleValidation" })
	public void logoValidation() {
		LoginPageElements login = new LoginPageElements();
		boolean logoDisplayed = login.logo.isDisplayed();
		
		// 1st way //if boolean, true, "message" ---> 2 boolean
		// Assert.assertEquals(logoDisplayed, true, "Logo is NOT displayed");

		// 2nd way //true, "msg"
		Assert.assertEquals(logoDisplayed, "Logo is NOT displayed");

	}

}

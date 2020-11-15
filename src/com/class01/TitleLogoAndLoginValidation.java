package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

//before: open browser, navigate to the website
//1. Test Case: Title Validation
//after: quit the browser
//before: open browser, navigate to the website
//2. Test Case: Logo Validation
//after: quit the browser
//before: open browser, navigate to the website
//3. Test Case Valid Login
//after: quit the browser
//4.Test Case Valid WelcomeAdminText
//after:quit the browser

public class TitleLogoAndLoginValidation extends CommonMethods {

	@BeforeMethod
	public void openAndNavigate()  {
		setUp();
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
	

	@Test
	public void titleValidation() throws Exception {
		String expectedTitle = "Human Management System";
		String actualTitle = driver.getTitle();
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("titleValidation  passed");
		} else {
			System.out.println("titleValidation failed");
			throw new Exception(); // if somethong happens or this test fails throw exception
		}
		Thread.sleep(2000);
	}
	
	

	@Test
	public void logoValidation() throws Exception {
		String logoPath = "//div[@id='divLogo']/img";
		WebElement logo = driver.findElement(By.xpath(logoPath));
		boolean isDisplayed = logo.isDisplayed();
		if (isDisplayed) {
			System.out.println("logoValidation Test passed");
		} else {
			System.out.println("logoValidation failed");
			throw new Exception();
		}
		Thread.sleep(2000);
	}

	@Test
	public void validLogin() throws InterruptedException {

		WebElement username = driver.findElement(By.id("txtUsername"));
//		sendText(username, "Admin");  //we should NOT hard coding
		sendText(username, ConfigsReader.getProperty("username"));

		WebElement password = driver.findElement(By.id("txtPassword"));
		sendText(password, ConfigsReader.getProperty("password"));

		click(driver.findElement(By.id("btnLogin")));

		Thread.sleep(2000);
	}

	//HW Validate that Welcome Admin is Displayed
	//Check reports in test-output folder
	@Test      
	public void validWelcomeAdminText() throws Exception {
		
		WebElement welcome = driver.findElement(By.id("welcome"));
		String text = welcome.getText();
		boolean isDisplay = welcome.isDisplayed();

		if (isDisplay) {
			System.out.println("validWelcomeAdminText Test is Passed "+text+" is displayed.");
		} else {
			System.out.println("validWelcomeAdminText Test is Failed "+text+" is NOT displayed.");
            throw new Exception();
		}

	}

}

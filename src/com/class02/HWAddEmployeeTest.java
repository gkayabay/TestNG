package com.class02;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import com.pages.AddEmployeePageElements;
import com.pages.DashboardPageElements;
import com.pages.LoginPageElements;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

import SelfTestNG.LoginPageElement;

//HW Syntax HRMS website
//Open Browser
// go to website HRSM
//Login into Application
//Click on Add Employee
//Verify Labels: Full Name, Employee ID, Photograf, are displayed
//provide employee first name and last name
//add a picture to the profile
//verify employee has been added successfully
//close browser

public class HWAddEmployeeTest extends CommonMethods {

	@BeforeMethod
	public void openBrowser() {
		setUp();
		LoginPageElements login = new LoginPageElements();
		boolean isDisplay = login.loginBtn.isDisplayed();
		//Assert.assertTrue(isDisplay,"Login is NOT displayed");  //hard assertion
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(isDisplay, "Login is NOT displayed");
		
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		soft.assertAll();
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
	
	@Test 
	public void verifyEmployeeLabels() {
		DashboardPageElements dashPage = new DashboardPageElements();
		click(dashPage.PIM);
		wait(2);
		AddEmployeePageElements addEmp = new AddEmployeePageElements();
		click(addEmp.addEmployee);
		wait(5);
		SoftAssert soft = new SoftAssert();
		boolean isDisplayfullName = addEmp.firstName.isDisplayed() && addEmp.lastName.isDisplayed() &&addEmp.employeeId.isDisplayed();
		soft.assertTrue(isDisplayfullName);
		
	}
	
	@Test(priority = 1)
	public void addEmployee() throws IOException {
		
		
		DashboardPageElements dashPage = new DashboardPageElements();
		click(dashPage.PIM);
		wait(5);
	
		AddEmployeePageElements addEmp = new AddEmployeePageElements();
		click(addEmp.addEmployee);
		//Assert.assertTrue(addEmp.firstN.isDisplayed()); 
		sendText(addEmp.firstName, ConfigsReader.getProperty("firstname"));
		sendText(addEmp.lastName, ConfigsReader.getProperty("lastname"));
		sendText(addEmp.employeeId, ConfigsReader.getProperty("empId"));
		sendText(addEmp.choosePhoto, ConfigsReader.getProperty("filePath"));
		click(addEmp.saveBtn);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File("screenshotsTestNG/HRMS/AddEmp.png"));
		wait(5);
	

		
		
	}

}

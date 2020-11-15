package com.class04;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;
import com.utils.ExcelUtility;

public class HW extends CommonMethods {
	
	@Test(dataProvider="userDataFromExcel", groups= {"homework", "addEmp","regression"})
	public void test(String firstName, String lastName, String username, String password) { //these 4 parameters has to match with data provider parameters
		//System.out.println(firstName+" "+lastName+" "+username+" "+password);
		
		//1. login to HRMS
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		//2. navigate to AddEmployee Page
		dashboard.navigateToAddEmployee();
		
		//3.add Employee information
		sendText(addEmp.firstName,firstName); //brown comes from the parameter lines 14
		sendText(addEmp.lastName, lastName);
		//get EmployeeID
		String expectedEmpId=addEmp.employeeId.getAttribute("value"); //get the empid
	
		
		//4.click on Create Login Details
		click(addEmp.checkboxLoginDetails);
		wait(1);
		
		//send info
		sendText(addEmp.username, username); //brown username comes from the parameter line 15 
		sendText(addEmp.password, password);   
		sendText(addEmp.confirmPassword, password);
		wait(1);
		jsClick(addEmp.saveBtn);
		wait(5);
		
		//validation
		waitForVisibility(pdetails.lblPersonalDetails);
		String actualEmpId = pdetails.employeeId.getAttribute("value");//personalDetails sayfasinda check edilmeli
		Assert.assertEquals(actualEmpId, expectedEmpId, "Employee ID did NOT match");
		
		//take screenshot
		takesScreenshot(firstName+"_"+lastName); //It will take the screenshot for each row of (or each employee)
	
	}
	
	@DataProvider(name="userData")
	public Object [][] getData() {
		Object[][] data = { { "Raj","Capoor", "raj123", "AmirKhan@123"}, 
	                      { "John", "Smith", "john123", "AmirKhan@123" },
	                      { "Mary", "Ann", "mary123","AmirKhan@123"},
	                      {"Rohani", "Sakhi","rohani123","AmirKhan@123"}
	                      };
				
		return data;
	}
	
	//get data from excel
	@DataProvider(name= "userDataFromExcel")
	public Object [][] getData2() {
		return ExcelUtility.excelIntoArray(System.getProperty("user.dir")+ "/testdata/Excel.xlsx","Employee");
	} 

}

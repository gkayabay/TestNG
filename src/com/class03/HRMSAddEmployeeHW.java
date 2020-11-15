package com.class03;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class HRMSAddEmployeeHW extends CommonMethods {
	
	@Test(dataProvider="getData")
	public void addEmployee(String firstName, String lastName,String userName, String password, String repassword) {
	login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	dashboard.navigateToAddEmployee();
	addEmp.addEmployeeDetails(firstName, lastName);
	addEmp.createLoginDetails();
	
	String actual= driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getText();
	String expected = firstName+" "+lastName;
	Assert.assertEquals(actual, expected, "Name DOES NOT match");
	
	}
	@DataProvider
	public Object [][] getData() {
		Object [][] data= {{"Ayse", "Ozden","ayoz","ayoz123","ayoz123"},
				{"Ahmet","Osman", "Aos", "Aos789","Aos789"},
				{"Tugba", "Nur","Tunur","Tunur123", "Tunur123"},
				{"Servet","Abi","Ser", "Ser123","Ser123"},
				{"Gulen", "Gul", "Gul","Gul123", "Gul123"}
				
		}; 
		return data;
	}
		
	}
	

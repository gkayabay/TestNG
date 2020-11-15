package com.class01;

import org.testng.annotations.*;

public class TaskTwo {
	//Notes
//	@BeforeMethod – Pre-condition for every Test case in a Class/Program
//	@AfterMethod Post-condition for every Test case in a Class/Program
//	@BeforeClass -Pre-condition for All Test cases in a Class/Program
//	@AfterClasee -Post-condition for All Test cases in a Class/Program
//	
	
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("This is before class");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("This is after class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is before Method");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("This is after Method");
	}
	
	@Test
	public void test1() {
		System.out.println("This is test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("This is test 2");
	}
	@Test
	public void test3() {
		System.out.println("This is test 3");
	}
}

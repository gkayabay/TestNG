package com.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerDemo implements ITestListener {  //to keep track of execution. To create listener we need to implements ITestListeners (interface)
	
//	* Steps:
//		1. Create a Listener class that will be implementing ITestListener Interface
//		2. Provide logic for methods we need (on passing, on failure, before starting)
//		3. Specify listener in configurations (xml file)

	//these listeners will keep track of my test execution of all my classes.
	public void onTestStart(ITestResult result) {
		System.out.println("Test case started "+result.getName()); //get the test of result with the name
	}
	
	//if my test successfull
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case passed "+result.getName()); 
	}
	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failed "+result.getName()); 
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case skipped "+result.getName()); 
	}

}

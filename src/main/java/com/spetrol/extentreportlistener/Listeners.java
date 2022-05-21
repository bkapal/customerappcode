package com.spetrol.extentreportlistener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
//import org.testng.log4testng.Logger;

public class Listeners implements ITestListener {
	public static Logger log = LogManager.getLogger(com.spetrol.extentreportlistener.Listeners.class);

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		log.info("=== Execution Completed Successfully ===");
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		log.info("=== Test Execution Started ===");

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("Failed Testcase Name :- " + result.getName());
		String testMethodName = result.getMethod().getMethodName();
	
		// TestUtil.takeScreenShot(testMethodName);
		System.out.println("TestCase Failed");

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("Testcase Passed :- " + result.getName());
	}

}

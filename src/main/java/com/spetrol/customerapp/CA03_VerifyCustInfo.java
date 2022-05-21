package com.spetrol.customerapp;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.spetrol.base.TestBase;
import com.spetrol.utils.Constants;

public class CA03_VerifyCustInfo extends TestBase {

	@Test
	public void testCustomerInformation() throws InterruptedException, IOException {
		wait.until(buildExpectedConditions(Constants.SIGN_IN)).click();
		wait.until(buildExpectedConditions(Constants.TxtBox_MobileNumber)).sendKeys(prop.getProperty("CustAppMobNum"));
		// Click on Next after Entering Mobile Number
		wait.until(buildExpectedConditions(Constants.Btn_NextAfterMobNum)).click();
		Thread.sleep(3000);
		String otp = prop.getProperty("CustAppOtp");
		char[] otpchar = otp.toCharArray();
		// Enter the 4 digit OTP
		for (int i = 0; i < otpchar.length; i++) {
			wait.until(buildExpectedConditions(String.format(Constants.TxtBox_OTP, i + 1)))
					.sendKeys(Character.toString(otpchar[i]));
		}
		Runtime.getRuntime().exec(prop.getProperty("keyEnter"));
		// verify otp
		wait.until(buildExpectedConditions(Constants.Btn_VerifyOTP)).click();
		Thread.sleep(2000);
		// Click on Hamburger Icon and Logout
		wait.until(buildExpectedConditions(Constants.Btn_Hamburger)).click();

		String custname = wait.until(buildExpectedConditions(Constants.Cust_Name)).getText();
		System.out.println(custname);
		String custnum = wait.until(buildExpectedConditions(Constants.Cust_Num)).getText();
		System.out.println(custnum);
		Assert.assertEquals(custname, "vasavi a");
		Assert.assertEquals(custnum, "+91 9999912345");
		
		Thread.sleep(2000);
	}
}

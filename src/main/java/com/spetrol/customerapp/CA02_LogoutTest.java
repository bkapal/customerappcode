package com.spetrol.customerapp;

import java.io.IOException;
import org.testng.annotations.Test;
import com.spetrol.base.TestBase;
import com.spetrol.utils.Constants;

public class CA02_LogoutTest extends TestBase {

	@Test
	public void testLogout() throws InterruptedException, IOException {
		wait.until(buildExpectedConditions(Constants.SIGN_IN)).click();
		wait.until(buildExpectedConditions(Constants.TxtBox_MobileNumber)).sendKeys(prop.getProperty("CustAppMobNum"));

		// Click on Next after Entering Mobile Number
		wait.until(buildExpectedConditions(Constants.Btn_NextAfterMobNum)).click();
		Thread.sleep(5000);
		String otp = prop.getProperty("CustAppOtp");
		char[] otpchar = otp.toCharArray();
		// Enter the 4 digit OTP
		for (int i = 0; i < otpchar.length; i++) {
			wait.until(buildExpectedConditions(String.format(Constants.TxtBox_OTP, i + 1)))
					.sendKeys(Character.toString(otpchar[i]));
		}
		Runtime.getRuntime().exec(prop.getProperty("keyEnter"));
		// verify
		wait.until(buildExpectedConditions(Constants.Btn_VerifyOTP)).click();
		// Click on Hamburger Icon and Logout
		wait.until(buildExpectedConditions(Constants.Btn_Hamburger)).click();
		wait.until(buildExpectedConditions(Constants.Lnk_Logout)).click();
		wait.until(buildExpectedConditions(Constants.Btn_Yes)).click();
		Thread.sleep(2000);
	}
}

package com.spetrol.customerapp;

import java.io.IOException;
import org.testng.annotations.Test;
import com.spetrol.base.TestBase;
import com.spetrol.utils.Constants;

/**
 *
 * adb install path to install in virtual devices
 */
public class CA01_LoginTest extends TestBase {

	@Test
	public void testLogin() throws InterruptedException, IOException {

		wait.until(buildExpectedConditions(Constants.SIGN_IN)).click();

		// Enter mobile number
		wait.until(buildExpectedConditions(Constants.TxtBox_MobileNumber)).sendKeys(prop.getProperty("CustAppMobNum"));

		// Click on Next after Entering Mobile Number
		wait.until(buildExpectedConditions(Constants.Btn_NextAfterMobNum)).click();
		Thread.sleep(5000);

		// driver.openNotifications(); //Use it when random OTP is displaying.
		// driver.findElementByXPath("//*[contains(@text,'Your OTP
		// is')]").getText().split(" ")[3];
		// String otpr=otp.split("\n")[0];
		// prop.getProperty("CustAppOtp");

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
		Thread.sleep(2000);

	}
}

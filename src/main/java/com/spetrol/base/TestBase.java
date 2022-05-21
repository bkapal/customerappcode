package com.spetrol.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {
	protected AndroidDriver<WebElement> driver;
	protected WebDriverWait wait;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			// FileInputStream ip = new
			// FileInputStream(".\\src\\main\\resources\\config.properties");
			InputStream ip = this.getClass().getClassLoader().getResourceAsStream("config.properties");

			prop.load(ip);
			System.out.println(prop);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public void initializeApp() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		dc.setCapability("autoGrantPermissions", "true");
		dc.setCapability("appPackage", "com.spetrol");
		dc.setCapability("appActivity", "com.spetrol.MainActivity");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<WebElement>(url, dc);
		wait = new WebDriverWait(driver, 60);
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

	protected ExpectedCondition<WebElement> buildExpectedConditions(String xpath) {
		return ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath));
	}

}

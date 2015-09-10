package com.ebay.appium.utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

public class Driver {
	
	public static WebDriver driver  = null;;
	
	@BeforeSuite
	public void  setUp() throws Exception {
		File classpathRoot = new File(System.getProperty("user.dir"));
		System.out.println(classpathRoot);
        File appDir = new File(classpathRoot, "src/main/resources");
	    File app = new File(appDir, "com.ebay.mobile-2.9.0.25-70-minAPI17.apk");
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
	    capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	    driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}
}
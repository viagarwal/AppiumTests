package com.ebay.appium.page_object.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.ebay.appium.utils.Driver;

public class EbayHomePage extends Driver {

	@AndroidFindBy(className="android.widget.Button") public List<WebElement> acceptButton;
	@AndroidFindBy(xpath="//android.widget.Button[@text='Sign in']") public WebElement signInButton;
	
	public EbayHomePage() throws Exception {
		PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
	}


	

}

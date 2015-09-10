package com.ebay.appium.page_object.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.ebay.appium.utils.Driver;
import com.ebay.appium.utils.WebDriverWaitUtils;

public class EbaySignInPage extends Driver {

	@AndroidFindBy(className="android.widget.EditText") public List<WebElement> editText;
	@AndroidFindBy(xpath ="//android.widget.Button[@text='Sign in']") public WebElement signInButton;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='REGISTER']") public WebElement registerLink;
	@AndroidFindBy(xpath="//android.widget.Button[@text='Get started']") public WebElement getStartedButton;
	public EbaySignInPage() throws Exception {
		PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
	}
	
	public void signIn() {
		editText.get(0).sendKeys("vipul");
		editText.get(1).sendKeys("pasword");
		signInButton.click();
	}
	public void registerUser(){
		WebDriverWaitUtils.waitElementToBeVisible(driver, registerLink);
		registerLink.click();
		WebDriverWaitUtils.waitElementToBeVisible(driver, getStartedButton);
		getStartedButton.click();
	}
}

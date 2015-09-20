package com.ebay.appium.page_object.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.ebay.appium.utils.Driver;
import com.ebay.appium.utils.WebDriverWaitUtils;

public class EbayHomePage extends Driver {

	@AndroidFindBy(className="android.widget.Button") public List<WebElement> acceptButton;
	@AndroidFindBy(xpath="//android.widget.Button[@text='Sign in']") public WebElement signInButton;
	@AndroidFindBy(className="android.widget.TextView") public WebElement searchBox;
	@AndroidFindBy(className="android.widget.EditText") public WebElement searchInput;
	@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc='Submit query']") public WebElement searchButton;
	@AndroidFindBy(xpath="//android.widget.Button[@text='Register']") public WebElement registerButton;
	@AndroidFindBy(id="progress_layout") public WebElement progressLayOut;
	
	public EbayHomePage() throws Exception {
		PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
	}

	public void searchInfo() {
		WebDriverWaitUtils.waitElementToBeVisible(searchBox);
		searchBox.click();
		searchInput.sendKeys("Ebay");
		searchButton.click();
		WebDriverWaitUtils.waitForElementToBeInVisible(searchButton);
		WebDriverWaitUtils.waitForElementToBeInVisible(progressLayOut);
	}
	public void navigateToRegisterAccount() {
		WebDriverWaitUtils.waitElementToBeVisible(registerButton);
		registerButton.click();
		WebDriverWaitUtils.waitForElementToBeInVisible(registerButton);
	}
	

}

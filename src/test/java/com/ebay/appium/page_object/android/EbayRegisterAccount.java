package com.ebay.appium.page_object.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.ebay.appium.utils.Driver;
import com.ebay.appium.utils.WebDriverWaitUtils;

public class EbayRegisterAccount extends Driver {

	@AndroidFindBy(className ="android.webkit.WebView") public WebElement webView;
	@AndroidFindBy(className="android.widget.LinearLayout") public List<WebElement> frameList; 
	@AndroidFindBy(id="progress_layout") public WebElement progressLayOut;
	@AndroidFindBy(className="android.widget.ProgressBar") public WebElement progressBar;
	@AndroidFindBy(xpath="//android.widget.TextView[@text ='First name']") public WebElement firstName;
	@AndroidFindBy(id="lastname") public WebElement lastNameInput;
	@AndroidFindBy(id="rpass") public WebElement passwordInput;
	@AndroidFindBy(xpath="//*[@DESCRIPTION ='Email']") public WebElement emailInput;
	@AndroidFindBy(id="remail") public WebElement confirmEmailInput;
	@AndroidFindBy(className="android.widget.Button[@text='Register']") public WebElement registerButton;
	
	public EbayRegisterAccount() throws Exception {
		PageFactory.initElements(new AppiumFieldDecorator(driver, 10,
				TimeUnit.SECONDS), this);
	}

	public void registerNewAccount() {
		WebDriverWaitUtils.waitElementToBeVisible(webView);
		Set<String> availableContexts = driver.getContextHandles();
		System.out.println("Total No of Context Found = "
				+ availableContexts.size());
		
		for (String contextName : availableContexts) {
			System.out.println(contextName);
			driver.context(contextName);
		}
		WebDriverWaitUtils.waitForElementToBeInVisible(progressLayOut);
		WebDriverWaitUtils.waitForElementToBeInVisible(progressBar);
	}
	
	public void registerAccount() {
		
		emailInput.click();
		emailInput.sendKeys("iet.vipul@gmail.com");
		confirmEmailInput.click();
		confirmEmailInput.sendKeys("iet.vipul@gmail.com");
//		firstName.click();
//		firstName.sendKeys("vipul");
//		registerButton.click();
	}

}

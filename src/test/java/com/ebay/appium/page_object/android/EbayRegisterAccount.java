package com.ebay.appium.page_object.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ebay.appium.utils.Driver;

public class EbayRegisterAccount extends Driver {

	@AndroidFindBy(className ="android.webkit.WebView") public WebElement webView;
	@AndroidFindBy(className="android.widget.LinearLayout") public List<WebElement> frameList; 
	public EbayRegisterAccount() throws Exception {
		PageFactory.initElements(new AppiumFieldDecorator(driver, 10,
				TimeUnit.SECONDS), this);
	}

	public void registerNewAccount() {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(webView));
//		Set<String> availableContexts = driver.getContextHandles();
//		System.out.println("Total No of Context Found = "
//				+ availableContexts.size());
//		for (String contextName : availableContexts) {
//			if (contextName.contains("WEBVIEW")) {
//				System.out.println("Context : " + contextName);
//				driver.context(contextName);
//				break;
//			}
//		}
//		
//		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("progress_layout")));
	}

}

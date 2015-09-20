package com.ebay.appium.page_object.android;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.ebay.appium.utils.Driver;
import com.ebay.appium.utils.WebDriverWaitUtils;

public class EbayProductDetails extends Driver {
	
	public EbayProductDetails() throws Exception {
		PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
	}
	
	@AndroidFindBy(className="android.support.v4.view.ViewPager") public WebElement imageElm;
	@AndroidFindBy(id="progress_layout") public WebElement progressLayOut;
	@AndroidFindBy(className="android.widget.FrameLayout") public WebElement frameLayout;
	
	public void navigateToProductInfo(){
		
		WebDriverWaitUtils.waitForElementToBeInVisible(progressLayOut);
		imageElm.click();
		WebDriverWaitUtils.waitElementToBeVisible(frameLayout);
//		WebElement el = driver.findElement(By.xpath("//android.view.View[@class='android.widget.ImageView']"));
//	    Dimension dimensions = el.getSize();
//	    Point upperLeft = el.getLocation();		
//	    System.out.println(upperLeft.getX());
//	    System.out.println(upperLeft.getY());
//		Point center = new Point(upperLeft.getX() + dimensions.getWidth() / 2, upperLeft.getY() + dimensions.getHeight() / 2);
//		driver.pinch(driver.findElement(By.xpath("//android.view.View[@class='android.widget.ImageView']")));
	}

}

package com.ebay.appium.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ebay.appium.page_object.android.EbayHomePage;
import com.ebay.appium.page_object.android.EbayProductDetails;
import com.ebay.appium.utils.Driver;
import com.ebay.appium.utils.WebDriverWaitUtils;

public class AndroidSearchTest extends Driver {
	
	private EbayHomePage ebayHome;
	private EbayProductDetails ebayProductDetails;
	
	public AndroidSearchTest() throws Exception {

	}

	@BeforeClass
	public void beforeClass() throws Exception {
		ebayHome = new EbayHomePage();
		ebayProductDetails = new EbayProductDetails();
	}
	
	@Test
	public void goToSignInPage(){

		WebDriverWaitUtils.waitElementToBeVisible(ebayHome.signInButton);
		ebayHome.searchInfo();
		WebElement listViewToScroll = driver.findElement(By.className("android.widget.RelativeLayout")); 
        Point center = getCenter(listViewToScroll);
        //perform swipe gesture
        driver.swipe(center.getY(), center.getX(), center.getY(), center.getX()-250, 10000);
		System.out.println(driver.findElements(By.className("android.widget.RelativeLayout")).size());
		List<WebElement> relativeLayouts = driver.findElements(By.className("android.widget.RelativeLayout"));
		for (WebElement webElement : relativeLayouts) {
			List<WebElement> textViews = webElement.findElements(By.className("android.widget.TextView"));
			for (WebElement webElement2 : textViews) {
				System.out.println(webElement2.getText());
				if(webElement2.getText().contains("Sony  Xperia M dual"))
				{
					webElement2.click();
					break;
				}
			}
		}
		ebayProductDetails.navigateToProductInfo();
	}	
	
    private Point getCenter(WebElement element) {
        Point upperLeft = element.getLocation();
        Dimension dimensions = element.getSize();
        return new Point(upperLeft.getX() + dimensions.getWidth()/2, upperLeft.getY() + dimensions.getHeight()/2);
    }
	
}

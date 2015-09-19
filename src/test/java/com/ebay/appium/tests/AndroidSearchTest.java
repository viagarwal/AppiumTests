package com.ebay.appium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ebay.appium.page_object.android.EbayHomePage;
import com.ebay.appium.utils.Driver;
import com.ebay.appium.utils.WebDriverWaitUtils;

public class AndroidSearchTest extends Driver {
	
	private EbayHomePage ebayHome;
	public AndroidSearchTest() throws Exception {

	}

	@BeforeClass
	public void beforeClass() throws Exception {
		ebayHome = new EbayHomePage();
	}
	
	@Test
	public void goToSignInPage(){

		WebDriverWaitUtils.waitElementToBeVisible(driver, ebayHome.signInButton);
		ebayHome.searchInfo();
//		System.out.println(driver.findElements(By.className("android.widget.RelativeLayout")).size());
//		List<WebElement> x = driver.findElements(By.className("android.widget.RelativeLayout"));
//		for (WebElement webElement : x) {
//			List<WebElement> vv = webElement.findElements(By.className("android.widget.TextView"));
//			for (WebElement webElement2 : vv) {
//				System.out.println(webElement2.getText());
//			}
//		}
		WebElement listViewToScroll = driver.findElement(By.className("android.widget.RelativeLayout")); 
        Point center = getCenter(listViewToScroll);
        //perform swipe gesture
        driver.swipe(center.getY(), center.getX(), center.getY(), center.getX()-500, 1000);
	}	
	
    private Point getCenter(WebElement element) {

        Point upperLeft = element.getLocation();
        Dimension dimensions = element.getSize();
        return new Point(upperLeft.getX() + dimensions.getWidth()/2, upperLeft.getY() + dimensions.getHeight()/2);
      }
	
}

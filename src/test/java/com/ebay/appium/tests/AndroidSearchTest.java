package com.ebay.appium.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ebay.appium.page_object.android.EbayHomePage;
import com.ebay.appium.page_object.android.EbaySignInPage;
import com.ebay.appium.utils.Driver;
import com.ebay.appium.utils.WebDriverWaitUtils;

public class AndroidSearchTest extends Driver {
	
	private EbayHomePage ebayHome;
	private EbaySignInPage ebaySignInPage;
	public AndroidSearchTest() throws Exception {

	}

	@BeforeClass
	public void beforeClass() throws Exception {
		ebayHome = new EbayHomePage();
		ebaySignInPage = new EbaySignInPage();
	}
	
	@Test
	public void goToSignInPage(){

		WebDriverWaitUtils.waitElementToBeVisible(driver, ebayHome.signInButton);
		ebayHome.signInButton.click();
		ebaySignInPage.registerUser();
	}	
	
}

package com.ebay.appium.tests;

import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ebay.appium.page_object.android.EbayHomePage;
import com.ebay.appium.page_object.android.EbayRegisterAccount;
import com.ebay.appium.page_object.android.EbaySignInPage;
import com.ebay.appium.utils.Driver;
import com.ebay.appium.utils.WebDriverWaitUtils;

public class AndroidRegisterAccount extends Driver {
	
	private EbayHomePage ebayHome;
	private EbaySignInPage ebaySignInPage;
	private EbayRegisterAccount ebayRegisterAccount;
	public AndroidRegisterAccount() throws Exception {

	}

	@BeforeClass
	public void beforeClass() throws Exception {
		ebayHome = new EbayHomePage();
		ebaySignInPage = new EbaySignInPage();
		ebayRegisterAccount = new EbayRegisterAccount();
	}
	
	@Test
	public void goToSignInPage(){

		WebDriverWaitUtils.waitElementToBeVisible(ebayHome.signInButton);
		ebayHome.navigateToRegisterAccount();
		ebaySignInPage.registerUser();
		ebayRegisterAccount.registerNewAccount();
		ebayRegisterAccount.registerAccount();
		((Rotatable)driver).rotate(ScreenOrientation.LANDSCAPE);

	}	
	
}

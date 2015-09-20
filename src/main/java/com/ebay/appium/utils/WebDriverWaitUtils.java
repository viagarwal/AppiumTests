package com.ebay.appium.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class WebDriverWaitUtils  extends Driver {

	/**
	 * @param driver
	 */
	void waitForLoad() {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);
	}

	/**
	 * @param driver
	 * @param locator
	 * @param timeoutSeconds
	 * @return
	 */
	private static WebElement findElement(final By locator, final int timeoutSeconds) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(timeoutSeconds, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);

		return wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
	}


	/**
	 * @param driver
	 * @param by
	 * @return
	 */
	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * @param driver
	 * @param by
	 * @return
	 * @throws InterruptedException
	 */
	public static boolean isElementVisible(final By by)
			throws InterruptedException {
		boolean value = false;

		if (driver.findElements(by).size() > 0) {
			value = true;
		}
		return value;
	}
	
	/**
	 * @param driver
	 * @param elm
	 */
	public static void waitElementToBeVisible(WebElement elm){
		WebDriverWait wait  = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(elm));
	}
	
	/**
	 * @param driver
	 * @param elm
	 */
	public static void waitForElementToBeInVisible(WebElement elm){
		WebDriverWait wait  = new WebDriverWait(driver, 20);
		wait.until(invisibilityOfElementLocated(elm));
	}

	  public static  ExpectedCondition<Boolean> invisibilityOfElementLocated(
		       final WebElement elm) {
		    return new ExpectedCondition<Boolean>() {
		      public Boolean apply(WebDriver driver) {
		        try {
		          return !elm.isDisplayed();
		        } catch (NoSuchElementException e) {
		          // Returns true because the element is not present in DOM. The
		          // try block checks if the element is present but is invisible.
		          return true;
		        } catch (StaleElementReferenceException e) {
		          // Returns true because stale element reference implies that element
		          // is no longer visible.
		          return true;
		        }
		      }

		      @Override
		      public String toString() {
		        return "element to no longer be visible: " + elm;
		      }
		    };
		  }
}
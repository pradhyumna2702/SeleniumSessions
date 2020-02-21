package com.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.PropertyPage;
import com.pages.SearchPage;

public class PropertyPageTest extends TestBase {
	
	
	
	
	SearchPage searchpage;
	PropertyPage propertypage;
	
	public PropertyPageTest() {
		super();
	}
	
	

	@BeforeMethod
	public void setUp() {
		initialization();
		searchpage = new SearchPage();
		propertypage=new PropertyPage();
		propertypage=searchpage.enterCountryName();
		
		}

	@Test(priority = 1)
	public void validateTitleTest() {
		String title = propertypage.validateTitle();
		Assert.assertEquals(title, "Property for Sale in London - Buy Properties in London - Zoopla");

	}

	@Test(priority = 2)
	public void printPriceMoneyInDescendingTest() {
		propertypage.printPriceMoneyInDescending();
	}
	
	
	@Test
	public void clickOn5thElementTest() {
		propertypage.clickOn5thElement();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
	
	
	

}

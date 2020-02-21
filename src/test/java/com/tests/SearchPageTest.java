package com.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.PropertyPage;
import com.pages.SearchPage;

public class SearchPageTest extends TestBase {

	SearchPage searchpage;
	PropertyPage propertypage;

	public SearchPageTest() {

		super();

	}

	@BeforeMethod
	public void setUp() {
		initialization();
		searchpage = new SearchPage();
	}

	@Test(priority = 1)
	public void validateTitleTest() {
		String title = searchpage.validateTitle();
		Assert.assertEquals(title, "Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents");

	}

	@Test(priority = 2)
	public void enterCountryNameTest() {
		propertypage = searchpage.enterCountryName();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

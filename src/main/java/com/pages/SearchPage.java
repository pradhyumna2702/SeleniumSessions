package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class SearchPage extends TestBase {

	@FindBy(xpath = "//input[@id='search-input-location']")
	WebElement searchBox;

	@FindBy(xpath = "//button[@id='search-submit']")
	WebElement searchBtn;

	public SearchPage() {

		PageFactory.initElements(driver, this);
	}

	public String validateTitle() {

		return driver.getTitle();

	}

	public PropertyPage enterCountryName() {

		searchBox.sendKeys(prop.getProperty("countryName"));
		searchBtn.click();
		return new PropertyPage();
	}

}

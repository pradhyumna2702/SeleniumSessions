package com.pages;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class PropertyPage extends TestBase {

	@FindBy(xpath = "//ul[@class='listing-results clearfix js-gtm-list']/li/descendant::a[@class='listing-results-price text-price']")
	List<WebElement> price;

	public PropertyPage() {

		PageFactory.initElements(driver, this);
	}

	public String validateTitle() {
		return driver.getTitle();
	}

	public void printPriceMoneyInDescending() {

		int PriceListCount = price.size();
		System.out.println(PriceListCount);

		System.out.println("*********************");
		
		

		for (int i = 0; i <= PriceListCount; i++) {
			String pricevalue = price.get(i).getText();

			pricevalue.replaceAll("[^0-9]", "");
			
			
			System.out.println(pricevalue);
			

			// System.out.println("*********************");

			// System.out.println(price);

		}

	}

	public AgentPage clickOn5thElement() {

		price.get(4).click();

		return new AgentPage();

	}

}

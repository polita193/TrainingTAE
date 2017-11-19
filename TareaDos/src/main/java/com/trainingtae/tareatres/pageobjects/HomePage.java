package com.trainingtae.tareatres.pageobjects;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	public HomePage(WebDriver pDriver) {
		super(pDriver);
		pDriver.get("http://www.travelocity.com");
	}

}

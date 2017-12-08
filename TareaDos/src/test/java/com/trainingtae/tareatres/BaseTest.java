package com.trainingtae.tareatres;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.trainingtae.tareatres.pageobjects.HomePage;
import com.trainingtae.tareatres.pageobjects.MyDriver;
import com.trainingtae.tareatres.pageobjects.MyDriver.Browser;

public class BaseTest {

	private MyDriver myDriver;
	private HomePage homePage;
	public Browser browserType = Browser.FIREFOX;

	@BeforeMethod
	public void beforeMethod() {
		myDriver = new MyDriver(browserType);
		homePage = new HomePage(myDriver.getDriver());
	}

	@AfterMethod
	public void afterMethod() {
		homePage.dispose();
	}

	public HomePage getHomePage() {
		return homePage;
	}
}

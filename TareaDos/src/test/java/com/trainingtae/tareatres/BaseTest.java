package com.trainingtae.tareatres;

import org.testng.annotations.BeforeSuite;

import com.trainingtae.tareatres.pageobjects.HomePage;
import com.trainingtae.tareatres.pageobjects.MyDriver;
import com.trainingtae.tareatres.pageobjects.MyDriver.Browser;

public class BaseTest {
	
	MyDriver myDriver;
	private HomePage homePage;
	Browser browserType = Browser.FIREFOX;

	@BeforeSuite
	public void beforeSuite(){
		myDriver = new MyDriver(browserType);
		homePage = new HomePage(myDriver.getDriver());
	}
	
	public void afterSuite(){
		homePage.dispose();
	}

	public HomePage getHomePage() {
		return homePage;
	}

}

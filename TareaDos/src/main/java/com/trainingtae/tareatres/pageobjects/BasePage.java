package com.trainingtae.tareatres.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	public WebDriver driver;
	
	public BasePage(){
		if(driver == null){
			driver = new FirefoxDriver();
		}
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver(){
		return driver;
	}
	
	private void goToPage(final String url) {
        driver.get(url);
    }
	
}

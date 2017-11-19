package com.trainingtae.tareatres.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	private WebDriver driver;
	
	public BasePage(WebDriver pDriver){
		PageFactory.initElements(pDriver, this);
		driver = pDriver;
	}
	
	public WebDriver getDriver(){
		return driver;
	}

	public void dispose(){
		if (driver != null){
			driver.quit();
		}
	}
	
}

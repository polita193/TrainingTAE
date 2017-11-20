package com.trainingtae.tareatres.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	private WebDriver driver;
	
	public BasePage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public WebDriver getDriver(){
		return this.driver;
	}

	public void dispose(){
		if (this.driver != null){
			this.driver.quit();
		}
	}	
}

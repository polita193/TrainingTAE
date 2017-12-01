package com.trainingtae.tareatres.pageobjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	private WebDriver driver;
	private WebDriverWait wait;
	private int TIME_TO_WAIT = 15;
	
	public BasePage(final WebDriver driver){
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, TIME_TO_WAIT);
		this.driver = driver;
	}
	
	public WebDriver getDriver(){
		return this.driver;
	}

	public WebDriverWait getWait(){
		return this.wait;
	}
	
	public void dispose(){
		if (this.driver != null){
			this.driver.quit();
		}
	}	

	public void closePopUpWindow() {
		String parentWindowHandler = driver.getWindowHandle(); 
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler); 
		driver.close();
		driver.switchTo().window(parentWindowHandler);
	}
	
	public void changeToNewTab() {
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}
}

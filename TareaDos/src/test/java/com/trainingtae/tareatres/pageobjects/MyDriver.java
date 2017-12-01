package com.trainingtae.tareatres.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriver {

	private WebDriver driver;
	public enum Browser{
		FIREFOX, CHROME;
	}
	
	public MyDriver(Browser type){
		switch(type){
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", "/Users/polit/Documents/TAE Training/geckodriver.exe");
			this.driver = new FirefoxDriver();
			break;
		case CHROME:
			System.setProperty("webdriver.chrome.driver", "/Users/polit/Documents/TAE Training/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("test-type");
            options.addArguments("--disable-web-security");
            options.addArguments("--allow-running-insecure-content");
			this.driver = new ChromeDriver(options);
			this.driver = new ChromeDriver();
			break;
		default:
			break;
		}
	}
	
	public WebDriver getDriver(){
		return this.driver;
	}

}

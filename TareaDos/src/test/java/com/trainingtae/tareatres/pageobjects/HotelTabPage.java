package com.trainingtae.tareatres.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class HotelTabPage extends BasePage{

	@FindBy(id="hotel-destination-hp-hotel")
	private WebElement hotelDestination;

	@FindBy(id="hotel-checkin-hp-hotel")
	private WebElement hotelCheckInDate;

	@FindBy(id="hotel-checkout-hp-hotel")
	private WebElement hotelCheckOutDate;
	
	@FindBy(className="datepicker-next")
	private WebElement nextMonth;

	@FindBy(className="datepicker-day-number")
	private WebElement day;

	@FindBys({@FindBy(className="gcw-submit")})
	private List<WebElement> searchButton;
	
	public HotelTabPage(WebDriver driver) {
		super(driver);
	}
	
	public void fillHotelSearch(String destination){
		enterHotelDestination(destination);
		selectCheckInDate();
		selectCheckOutDate();
		searchHotel();
	}
	
	private void enterHotelDestination(String destination) {
		hotelDestination.sendKeys(destination);
		hotelDestination.sendKeys(Keys.TAB);
	}

	private void selectCheckInDate() {
		hotelCheckInDate.click();
		nextMonth.click();
		nextMonth.click();
		day.click();
	}

	private void selectCheckOutDate(){
		hotelCheckOutDate.click();
		getDriver().findElement(By.xpath("//button[contains(@data-day,'5')]")).click();
	}

	private void searchHotel(){
		searchButton.get(1).click();	
	}

}

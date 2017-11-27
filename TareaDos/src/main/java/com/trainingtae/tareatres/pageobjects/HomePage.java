package com.trainingtae.tareatres.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

	private String URL = "http://www.travelocity.com";

	@FindBy(id="tab-flight-tab-hp")
	private WebElement flightTab;
	
	@FindBy(id="tab-hotel-tab-hp")
	private WebElement hotelTab;

	@FindBy(id="flight-type-roundtrip-label-hp-flight")
	private WebElement roundtripLabel;

	@FindBy(id="flight-origin-hp-flight")
	private WebElement flightOrigin;

	@FindBy(id="flight-destination-hp-flight")
	private WebElement flightDestination;

	@FindBy(id="flight-departing-hp-flight")
	private WebElement flightDepartingDate;

	@FindBy(id="flight-returning-hp-flight")
	private WebElement flightReturningDate;
	
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
	
	@FindBy(className="gcw-submit")
	private WebElement searchButton;

	public HomePage(WebDriver driver) {
		super(driver);
		goToPage(driver);
	}

	public FlightResultsPage bookFlight(String origin, String destination) {
		selectFlightTab();
		selectRoundtripLabel();
		enterFlightOrigin(origin);
		enterFlightDestination(destination);
		selectDepartingDate();
		selectReturningDate();
		search();
		return new FlightResultsPage(getDriver());
	}
	
	public void bookHotel(String destination) {
		selectHotelTab();
		enterHotelDestination(destination);
		selectCheckInDate();
		selectCheckOutDate();
		search();
	}
	
	private void goToPage(WebDriver driver) {
		driver.get(URL);
		driver.manage().window().maximize();
	}

	private void selectFlightTab() {
		flightTab.click();
	}

	private void selectRoundtripLabel() {
		roundtripLabel.click();
	}

	private void enterFlightOrigin(String origin) {
		flightOrigin.sendKeys(origin);
	}

	private void enterFlightDestination(String destination) {
		flightDestination.sendKeys(destination);
	}

	private void selectDepartingDate() {
		flightDepartingDate.click();
		nextMonth.click();
		nextMonth.click();
		day.click();
	}

	private void selectReturningDate() {
		flightReturningDate.click();
		nextMonth.click();
		day.click();
	}
	
	private void search(){
		getWait().until(ExpectedConditions.visibilityOf(searchButton));
		searchButton.click();
	}
	
	private void selectHotelTab() {
		hotelTab.click();
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
	
	public String getURL() {
		return URL;
	}

	public WebElement getFlightTab() {
		return flightTab;
	}

	public WebElement getRoundtripLabel() {
		return roundtripLabel;
	}

	public WebElement getFlightOrigin() {
		return flightOrigin;
	}

	public WebElement getFlightDestination() {
		return flightDestination;
	}

	public WebElement getFlightDepartingDate() {
		return flightDepartingDate;
	}

	public WebElement getFlightReturningDate() {
		return flightReturningDate;
	}

	public WebElement getNextMonth() {
		return nextMonth;
	}

	public WebElement getDay() {
		return day;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
}

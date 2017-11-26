package com.trainingtae.tareatres.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	private String URL = "http://www.travelocity.com";

	@FindBy(id = "tab-flight-tab-hp")
	private WebElement flightTab;

	@FindBy(id = "flight-type-roundtrip-label-hp-flight")
	private WebElement roundtripLabel;

	@FindBy(id = "flight-origin-hp-flight")
	private WebElement flightOrigin;

	@FindBy(id = "flight-destination-hp-flight")
	private WebElement flightDestination;

	@FindBy(id = "flight-departing-hp-flight")
	private WebElement flightDepartingDate;

	@FindBy(id = "flight-returning-hp-flight")
	private WebElement flightReturningDate;

	@FindBy(className = "datepicker-next")
	private WebElement nextMonth;

	@FindBy(className = "datepicker-day-number")
	private WebElement day;

	@FindBy(className = "gcw-submit")
	private WebElement searchButton;

	public HomePage(WebDriver driver) {
		super(driver);
		goToPage(driver);
	}

	public FlightResultsPage bookFlight(String origin, String destination) {
		selectFlightTab();
		selectRoundtripLabel();
		enterOrigin(origin);
		enterDestination(destination);
		selectDepartingDate();
		selectReturningDate();
		searchButton.click();
		return new FlightResultsPage(getDriver());
	}

	private void goToPage(WebDriver driver) {
		driver.get(URL);
	}

	private void selectFlightTab() {
		flightTab.click();
	}

	private void selectRoundtripLabel() {
		roundtripLabel.click();
	}

	private void enterOrigin(String origin) {
		flightOrigin.sendKeys(origin);
	}

	private void enterDestination(String destination) {
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

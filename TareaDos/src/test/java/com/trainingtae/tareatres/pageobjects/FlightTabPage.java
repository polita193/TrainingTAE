package com.trainingtae.tareatres.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class FlightTabPage extends BasePage{

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
	
	@FindBy(className="datepicker-next")
	private WebElement nextMonth;

	@FindBy(className="datepicker-day-number")
	private WebElement day;

	@FindBys({@FindBy(className="gcw-submit")})
	private List<WebElement> searchButton;

	public FlightTabPage(WebDriver driver) {
		super(driver);
	}
	
	public void fillFlightSearch(String origin, String destination){
		selectRoundtripLabel();
		enterFlightOrigin(origin);
		enterFlightDestination(destination);
		selectFltDepartingDate();
		selectFltReturningDate();
		searchFlight();	
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

	private void selectFltDepartingDate() {
		flightDepartingDate.click();
		nextMonth.click();
		nextMonth.click();
		day.click();
	}

	private void selectFltReturningDate() {
		flightReturningDate.click();
		nextMonth.click();
		day.click();
	}
	
	private void searchFlight(){
		searchButton.get(0).click();
	}
}

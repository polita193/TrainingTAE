package com.trainingtae.tareatres.pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

	private String URL = "http://www.travelocity.com";

	@FindBy(id="tab-flight-tab-hp")
	private WebElement flightTab;

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

	@FindBy(id="tab-hotel-tab-hp")
	private WebElement hotelTab;

	@FindBy(id="hotel-destination-hp-hotel")
	private WebElement hotelDestination;

	@FindBy(id="hotel-checkin-hp-hotel")
	private WebElement hotelCheckInDate;

	@FindBy(id="hotel-checkout-hp-hotel")
	private WebElement hotelCheckOutDate;

	@FindBy(id="tab-package-tab-hp")
	private WebElement packageTab;

	@FindBy(id="fh-fh-hp-package")
	private WebElement packageFHLabel;

	@FindBy(id="fhc-fhc-hp-package")
	private WebElement packageFHCarLabel;

	@FindBy(id="package-origin-hp-package")
	private WebElement packageOrigin;

	@FindBy(id="package-destination-hp-package")
	private WebElement packageDestination;

	@FindBy(id="package-departing-hp-package")
	private WebElement packageDepartingDate;

	@FindBy(id="package-returning-hp-package")
	private WebElement packageReturningDate;

	@FindBy(id="partialHotelBooking-hp-package")
	private WebElement partialHotel;

	@FindBy(id="package-checkin-hp-package")
	private WebElement packageCheckInDate;

	@FindBy(id="package-checkout-hp-package")
	private WebElement packageCheckOutDate;

	@FindBy(className="error-link")
	private WebElement errorMessage;

	@FindBy(id="tab-cruise-tab-hp")
	private WebElement cruiseTab;

	@FindBy(id="cruise-destination-hp-cruise")
	private WebElement cruiseDestination;

	@FindBy(id="cruise-departure-month-hp-cruise")
	private WebElement cruiseDepartureMonth;

	@FindBy(className="datepicker-next")
	private WebElement nextMonth;

	@FindBy(className="datepicker-day-number")
	private WebElement day;

	@FindBys({@FindBy(className="gcw-submit")})
	private List<WebElement> searchButton;

	public HomePage(WebDriver driver) {
		super(driver);
		goToPage(driver);
	}

	public FlightResultsPage bookFlight(String origin, String destination) {
		selectFlightTab();
		selectRoundtripLabel();
		enterFlightOrigin(origin);
		enterFlightDestination(destination);
		selectFltDepartingDate();
		selectFltReturningDate();
		searchFlight();
		return new FlightResultsPage(getDriver());
	}

	public HotelResultsPage bookHotel(String destination) {
		selectHotelTab();
		enterHotelDestination(destination);
		selectCheckInDate();
		selectCheckOutDate();
		searchHotel();
		return new HotelResultsPage(getDriver());
	}

	public void bookFHPackage(String origin, String destination){
		selectPackageTab();
		selectFHPkgLabel();
		enterPackageOrigin(origin);
		enterPackageDestination(destination);
		selectPkgDepartingDate();
		selectPkgReturningDate();
		checkPartialHotel();
		selectPkgCheckInDate();
		selectPkgCheckOutDate();
		searchPackage();
	}

	public PkgHotelResultPage bookFHCarPackage(String origin, String destination) {
		selectPackageTab();
		selectFHCarPkgLabel();
		enterPackageOrigin(origin);
		enterPackageDestination(destination);
		selectPkgDepartingDate();
		selectPkgReturningDate();
		searchPackage();
		return new PkgHotelResultPage(getDriver());
	}

	public CruiseResultsPage bookCruise(String destination, String month){
		selectCruiseTab();
		selectCruiseDestination(destination);
		selectCruiseDepartureMonth(month);
		searchCruise();
		return new CruiseResultsPage(getDriver());
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

	private void selectHotelTab() {
		hotelTab.click();
	}

	private void enterHotelDestination(String destination) {
		hotelDestination.sendKeys(destination);
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

	private void selectPackageTab() {
		packageTab.click();	
	}

	private void selectFHPkgLabel() {
		packageFHLabel.click();
	}

	private void selectFHCarPkgLabel() {
		packageFHCarLabel.click();
	}

	private void enterPackageOrigin(String origin) {
		packageOrigin.sendKeys(origin);
	}

	private void enterPackageDestination(String destination) {
		packageDestination.sendKeys(destination);
	}

	private void selectPkgDepartingDate(){
		packageDepartingDate.click();
		nextMonth.click();
		nextMonth.click();
		day.click();
	}

	private void selectPkgReturningDate(){
		packageReturningDate.click();
		getDriver().findElement(By.xpath("//button[contains(@data-day,'13')]")).click();
	}

	private void checkPartialHotel() {
		if(!partialHotel.isSelected())
			partialHotel.click();
	}

	private void selectPkgCheckInDate(){
		packageCheckInDate.click();
		getDriver().findElement(By.xpath("//button[contains(@data-day,'16')]")).click();
	}

	private void selectPkgCheckOutDate(){
		packageCheckOutDate.click();
		getDriver().findElement(By.xpath("//button[contains(@data-day,'18')]")).click();
	}

	private void searchPackage(){
		searchButton.get(2).click();	
	}

	public String validateErrorMessage() {
		return errorMessage.getText();
	}

	private void selectCruiseTab() {
		cruiseTab.click();	
	}

	private void selectCruiseDestination(String destination) {
		getWait().until(ExpectedConditions.elementToBeClickable(cruiseDestination));
		cruiseDestination.click();
		Select destinationList = new Select(cruiseDestination);
		destinationList.selectByVisibleText(destination);
	}

	private void selectCruiseDepartureMonth(String month) {
		getWait().until(ExpectedConditions.elementToBeClickable(cruiseDepartureMonth));
		cruiseDepartureMonth.click();
		Select monthList = new Select(cruiseDepartureMonth);
		monthList.selectByVisibleText(month);
	}

	private void searchCruise() {
		searchButton.get(4).click();
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

}

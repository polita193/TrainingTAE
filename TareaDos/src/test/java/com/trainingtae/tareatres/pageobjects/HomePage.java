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

	private static final String URL = "http://www.travelocity.com";

	@FindBy(id="tab-flight-tab-hp")
	private WebElement flightTab;
	
	@FindBy(id="tab-hotel-tab-hp")
	private WebElement hotelTab;

	@FindBy(id="tab-package-tab-hp")
	private WebElement packageTab;
	
	@FindBy(id="tab-cruise-tab-hp")
	private WebElement cruiseTab;

	public HomePage(WebDriver driver) {
		super(driver);
		goToPage(driver);
	}

	public FlightResultsPage bookFlight(String origin, String destination) {
		FlightTabPage flightTabPage = selectFlightTab();
		flightTabPage.fillFlightSearch(origin, destination);
		return new FlightResultsPage(getDriver());
	}

	public HotelResultsPage bookHotel(String destination) {
		HotelTabPage hotelTabPage = selectHotelTab();
		hotelTabPage.fillHotelSearch(destination);
		return new HotelResultsPage(getDriver());
	}

	public String bookFHPackage(String origin, String destination){
		PackageTabPage packageTabPage = selectPackageTab();
		return packageTabPage.fillPackageFHSearch(origin, destination);
	}

	public PkgHotelResultPage bookFHCarPackage(String origin, String destination) {
		PackageTabPage packageTabPage = selectPackageTab();
		packageTabPage.fillPackageFHCarSearch(origin, destination);
		return new PkgHotelResultPage(getDriver());
	}

	public CruiseResultsPage bookCruise(String destination, String month){
		CruiseTabPage cruiseTabPage = selectCruiseTab();
		cruiseTabPage.fillCruiseSearch(destination, month);
		return new CruiseResultsPage(getDriver());
	}

	private void goToPage(WebDriver driver) {
		driver.get(URL);
	}

	private FlightTabPage selectFlightTab() {
		flightTab.click();
		return new FlightTabPage(getDriver());
	}

	private HotelTabPage selectHotelTab() {
		hotelTab.click();
		return new HotelTabPage(getDriver());
	}
	
	private PackageTabPage selectPackageTab() {
		packageTab.click();
		return new PackageTabPage(getDriver());	
	}

	private CruiseTabPage selectCruiseTab() {
		cruiseTab.click();
		return new CruiseTabPage(getDriver());	
	}
	
	public String getURL() {
		return URL;
	}
}

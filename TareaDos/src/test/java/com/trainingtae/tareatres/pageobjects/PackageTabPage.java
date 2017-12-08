package com.trainingtae.tareatres.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class PackageTabPage extends BasePage {

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
	
	@FindBy(className="datepicker-next")
	private WebElement nextMonth;

	@FindBy(className="datepicker-day-number")
	private WebElement day;

	@FindBys({@FindBy(className="gcw-submit")})
	private List<WebElement> searchButton;

	public PackageTabPage(WebDriver driver) {
		super(driver);
	}
	
	public String fillPackageFHSearch(String origin, String destination){
		selectFHPkgLabel();
		enterPackageOrigin(origin);
		enterPackageDestination(destination);
		selectPkgDepartingDate();
		selectPkgReturningDate();
		checkPartialHotel();
		selectPkgCheckInDate();
		selectPkgCheckOutDate();
		searchPackage();
		return validateErrorMessage();
	}
	
	public void fillPackageFHCarSearch(String origin, String destination){
		selectFHCarPkgLabel();
		enterPackageOrigin(origin);
		enterPackageDestination(destination);
		selectPkgDepartingDate();
		selectPkgReturningDate();
		searchPackage();
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

}

package com.trainingtae.tareatres.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CruiseTabPage extends BasePage {

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
	
	public CruiseTabPage(WebDriver driver) {
		super(driver);
	}
	
	public void fillCruiseSearch(String destination, String month){
		selectCruiseDestination(destination);
		selectCruiseDepartureMonth(month);
		searchCruise();
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

	
	

}

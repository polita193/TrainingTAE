package com.trainingtae.tareatres.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightResultsPage extends BasePage {

	@FindBy(name="sort")
	private WebElement sortOption;

	@FindBys({@FindBy(className="flight-module")})
	private List<WebElement> flightResultList;

	private String xpathSelectButton = "(.//button[contains(@class,'t-select-btn')])";
	private String xpathDuration = "(.//*[@data-test-id='duration'])";
	private String xpathDetailsAndFee = "(.//a[contains(@class,'flight-details-link')])";

	private Select sort;

	public FlightResultsPage(WebDriver driver) {
		super(driver);
	}

	public List<String> getSortingOptions() {
		getWait().until(ExpectedConditions.visibilityOf(sortOption));
		sort = new Select(sortOption);
		List<String> options = new ArrayList<String>();
		for (WebElement w : sort.getOptions()) {
			if (!options.contains(w.getText().replaceAll(" .*", ""))) {
				options.add(w.getText().replaceAll(" .*", ""));
			}
		}
		return options;
	}

	public boolean selectButtonIsPresent() {
		closePopUpWindow();
		boolean present = false;
		getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(flightResultList)));
		for (WebElement w : flightResultList) {
			if (w.findElement(By.xpath(xpathSelectButton)).isDisplayed())
			present = true;
		}
		return present;
	}

	public boolean flightDurationIsPresent() {
		boolean present = false;
		for (WebElement w : flightResultList) {
			if (w.findElement(By.xpath(xpathDuration)).isDisplayed())
			present = true;
		}
		return present;
	}

	public boolean detailsAndFeeIsPresent() {
		boolean present = false;
		for (WebElement w : flightResultList) {
			if (w.findElement(By.xpath(xpathDetailsAndFee)).isDisplayed())
			present = true;
		}
		return present;
	}

	public boolean sortByDurationAsc() {
		sort.selectByValue("duration:asc");
		getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(flightResultList)));
		return validateSorting();
	}

	private boolean validateSorting() {
		int count = 0;
		WebElement base = flightResultList.get(0).findElement(By.xpath(xpathDuration));
		for (WebElement w : flightResultList) {
			WebElement value = w.findElement(By.xpath(xpathDuration));
			if (getDuration(base.getText()) <= getDuration((value.getText()))) {
				base = value;
				count++;
			}
		}
		return count == flightResultList.size();
	}

	private int getDuration(String text) {
		text = text.replace(" ", "");
		text = text.replace("m", "");
		text = text.replace("h", "");
		return Integer.parseInt(text);
	}

	public TripDetailPage pickFlights() {
		selectFlightByposition(0);
		selectFlightByposition(3);
		return new TripDetailPage(getDriver());
	}
	
	public CarResulstPage pickPkgFlightsFHC() {
		selectFlightByposition(0);
		selectFlightByposition(0);
		return new CarResulstPage(getDriver());
	}
	
	private void selectFlightByposition(int pos){
		getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(flightResultList)));
		flightResultList.get(pos).findElement(By.xpath(xpathSelectButton)).click();
	}
	
	public WebElement getSortOption() {
		return sortOption;
	}

	public List<WebElement> getFlightResultList() {
		return flightResultList;
	}
}

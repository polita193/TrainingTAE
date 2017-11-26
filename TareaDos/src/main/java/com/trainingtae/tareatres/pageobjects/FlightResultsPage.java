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
		return validateSorting();
	}

	private boolean validateSorting() {
		boolean ordered = false;
		getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(flightResultList)));
		WebElement base = flightResultList.get(0).findElement(By.xpath(xpathDuration));
		for (WebElement w : flightResultList) {
			WebElement value = w.findElement(By.xpath(xpathDuration));
			if (getDuration(base.getText()) <= getDuration((value.getText()))) {
				ordered = true;
				base = value;
			} else
				ordered = false;
		}
		return ordered;
	}

	private int getDuration(String text) {
		text = text.replace(" ", "");
		text = text.replace("m", "");
		text = text.replace("h", "");
		return Integer.parseInt(text);
	}

	public TripDetailPage pickFlights() {
		flightResultList.get(0).findElement(By.xpath(xpathSelectButton)).click();
		getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(flightResultList)));
		flightResultList.get(3).findElement(By.xpath(xpathSelectButton)).click();
		return new TripDetailPage(getDriver());
	}

	public WebElement getSortOption() {
		return sortOption;
	}

	public List<WebElement> getFlightResultList() {
		return flightResultList;
	}

}

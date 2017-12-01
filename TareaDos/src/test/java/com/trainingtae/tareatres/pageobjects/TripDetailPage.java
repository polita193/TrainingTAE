package com.trainingtae.tareatres.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TripDetailPage extends BasePage {
	
	@FindBy(className="trip-total")
	private WebElement tripTotal;
	
	@FindBy(className="priceGuarantee")
	private WebElement priceGuarantee;
	
	@FindBys({@FindBy(className="date")})
	private List <WebElement> tripInfoDate;
	
	@FindBy(id="bookButton")
	private WebElement bookButton;
	
	public TripDetailPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean tripTotalIsPresent(){
		changeToNewTab();
		getWait().until(ExpectedConditions.titleIs("Trip Detail | Travelocity"));
		getWait().until(ExpectedConditions.visibilityOf(tripTotal));
		return tripTotal.isDisplayed();
	}
	
	public boolean tripInfoIsPresent(){
		boolean present = false;
		if(tripInfoDate.get(0).isDisplayed() && tripInfoDate.get(1).isDisplayed()){
			present = true;
		}
		return present;
	}
	
	public boolean priceGuaranteeIsPresent(){
		return priceGuarantee.getText().equals("Price Guarantee");
	}

	public TravelerInfoPage bookFlight() {
		bookButton.click();
		return new TravelerInfoPage(getDriver());
	}

	public WebElement getTripTotal() {
		return tripTotal;
	}

	public WebElement getPriceGuarantee() {
		return priceGuarantee;
	}

	public List<WebElement> getTripInfoDate() {
		return tripInfoDate;
	}

	public WebElement getBookButton() {
		return bookButton;
	}
}

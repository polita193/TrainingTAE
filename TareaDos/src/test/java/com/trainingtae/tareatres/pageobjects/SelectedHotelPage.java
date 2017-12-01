package com.trainingtae.tareatres.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SelectedHotelPage extends BasePage{
	
	@FindBy(className="rating-number")
	private WebElement stars;
	
	@FindBy(className="book-button")
	private WebElement bookRoomButton;

	public SelectedHotelPage(WebDriver driver) {
		super(driver);
	}

	public int validateStars() {
		getWait().until(ExpectedConditions.visibilityOf(stars));
		return Integer.parseInt(stars.getText());
	}
	
	public FlightResultsPage selectFirstRoom(){
		bookRoomButton.click();
		return new FlightResultsPage(getDriver());
	}

}

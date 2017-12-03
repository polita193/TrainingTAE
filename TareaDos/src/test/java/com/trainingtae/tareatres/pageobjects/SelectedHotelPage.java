package com.trainingtae.tareatres.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SelectedHotelPage extends BasePage{
	
	@FindBy(className="rating-number")
	private WebElement stars;
	
	@FindBys({@FindBy(xpath="//article")})
	private List <WebElement> roomList;
	
	@FindBy(className="book-button")
	private WebElement bookRoomButton;

	@FindBy(className="hotel-description")
	private WebElement hotelDescription;
	
	public SelectedHotelPage(WebDriver driver) {
		super(driver);
	}
	
	public float validateStars() {
		changeToNewTab();
		getWait().until(ExpectedConditions.visibilityOf(stars));
		return Float.parseFloat(stars.getText());
	}
	
	public FlightResultsPage selectFirstRoom(){
		bookRoomButton.click();
		return new FlightResultsPage(getDriver());
	}
	
	public boolean selectButtonIsPresent(){
		int count = 0;
		getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(roomList)));
		for (WebElement w : roomList) {
			if (w.findElement(By.xpath("//a[contains(@class,'book-button')]")).isDisplayed())
			count++;
		}
		return count == roomList.size();
	}
	
	public boolean hotelDescriptionIsPresent(){
		return hotelDescription.isDisplayed();
	}
}

package com.trainingtae.tareatres.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TravelerInfoPage extends BasePage {

	@FindBy(id="urgency-updated")
	private WebElement urgencyMessage;
	
	@FindBy(className="faceoff-module-title")
	private WebElement questionTitle;
	
	@FindBy(id="complete-booking")
	private WebElement completeBookingButton;
	
	@FindBy(className="summary")
	private WebElement summaryTripInfo;
	
	public TravelerInfoPage(WebDriver driver) {
		super(driver);
	}

	public String getUrgencyMessage() {
		getWait().until(ExpectedConditions.visibilityOf(urgencyMessage));
		return urgencyMessage.getText().trim();
	}
	
	public String getQuestionTitle(){
		return questionTitle.getText().trim();
	}
	
	public boolean bookingButtonIsPresent(){
		return completeBookingButton.isEnabled();
	}
	
	public boolean summaryTripInfoISPresent(){
		return summaryTripInfo.isDisplayed();
	}
	
	public String getTitle(){
		return getDriver().getTitle();
	}

	public WebElement getCompleteBookingButton() {
		return completeBookingButton;
	}

	public WebElement getSummaryTripInfo() {
		return summaryTripInfo;
	}
}

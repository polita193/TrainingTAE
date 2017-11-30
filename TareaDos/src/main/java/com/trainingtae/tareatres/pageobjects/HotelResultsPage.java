package com.trainingtae.tareatres.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HotelResultsPage extends BasePage {
	
	@FindBy(id="mer-signup-toggle-btn")
	private WebElement toggleDiscount;
	
	@FindBy(id="mer-banner-signup-email")
	private WebElement emailField;
	
	@FindBy(xpath="//article[1]|//article[2]")
	private WebElement sponsored;

	public HotelResultsPage(WebDriver driver) {
		super(driver);
	}

	public boolean validateSponsored(){
		return sponsored.getAttribute("data-automation").equals("sponsored");
	}
	
	public boolean getDiscountWithEmail(){
		closePopUpWindow();
		getWait().until(ExpectedConditions.visibilityOf(toggleDiscount));
		toggleDiscount.click();
		return emailField.isDisplayed();
	}
	
	public WebElement getToggleDiscount() {
		return toggleDiscount;
	}

	public WebElement getEmailField() {
		return emailField;
	}

	public WebElement getSponsored() {
		return sponsored;
	}
}

package com.trainingtae.tareatres.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PackageDetailInfoPage extends BasePage {
	
	@FindBy(xpath="//*[@class='title-main']")
	private WebElement questionTitle;
	
	@FindBy(className="contact_name")
	private WebElement contactName;
	
	@FindBy(id="creditCardInput")
	private WebElement creditCardNumber;
	
	@FindBy(name="email")
	private WebElement emailField;

	@FindBy(id="complete-booking")
	private WebElement completeBookingButton;
	
	public PackageDetailInfoPage(WebDriver driver) {
		super(driver);
	}

	public String getQuestionTitle1() {
		getWait().until(ExpectedConditions.visibilityOf(questionTitle));
		return questionTitle.getText().trim();
	}
	
	public boolean contacNameFieldIsPresent(){
		return contactName.isDisplayed();
	}
	
	public boolean creditCardNumberIspresent(){
		return creditCardNumber.isDisplayed();
	}
	
	public boolean emailFieldIsPresent(){
		return emailField.isDisplayed();
	}
	
	public boolean completeBookingIsPresent(){
		return completeBookingButton.isEnabled();
	}
}

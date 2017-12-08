package com.trainingtae.tareatres.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CarResulstPage extends BasePage{
	
	@FindBys({@FindBy(xpath="//a[contains(@class,'btn-action')]")})
	private List<WebElement> CarResultList;
	
	@FindBy(className="demand-info-message")
	private WebElement highDemandMessage;
	
	public CarResulstPage(WebDriver driver) {
		super(driver);
	}
	
	public PackageDetailInfoPage selectCar(){
		getWait().until(ExpectedConditions.visibilityOfAllElements(CarResultList));
		CarResultList.get(0).click();
		return new PackageDetailInfoPage(getDriver());
	}
	
	public String validateHighDemandMessage(){
		return highDemandMessage.getText();
	}
}

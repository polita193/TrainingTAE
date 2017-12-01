package com.trainingtae.tareatres.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class CarResulstPage extends BasePage{
	
	public CarResulstPage(WebDriver driver) {
		super(driver);
	}

	@FindBys({@FindBy(className="listing-wrapper")})
	private List<WebElement> CarResultList;
	
	public PackageDetailInfoPage selectCar(){
		CarResultList.get(2).click();
		return new PackageDetailInfoPage(getDriver());
	}
	

}

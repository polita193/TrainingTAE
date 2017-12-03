package com.trainingtae.tareatres.pageobjects;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CruiseResultsPage extends BasePage {

	@FindBy(id="destination-select")
	private WebElement destinationSelected;

	@FindBy(id="departure-month-select")
	private WebElement monthSelected;

	@FindBy(id="length-10-14")
	private WebElement filterLength10_14;

	@FindBy(className="cruise-card-content")
	private List<WebElement> cruiseCardList; 

	@FindBys({@FindBy(className="sailing-list")})
	private WebElement sailingList;

	public CruiseResultsPage(WebDriver driver) {
		super(driver);
	}

	public boolean validateCruiseFilter(String destination, String month) {
		getWait().until(ExpectedConditions.visibilityOf(destinationSelected));
		return (destination.equals(destinationSelected.getText()) && month.equals(monthSelected.getText()));
	}

	public boolean isLengthFilterSelected(){
		filterLength10_14.click();
		getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(filterLength10_14)));
		return filterLength10_14.isSelected();
	}

	public boolean validateCruiseListDiscount(){
		int count = 0;
		getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(cruiseCardList)));
		for(WebElement w: cruiseCardList){
			if(w.isDisplayed()){
				if(w.findElement(By.xpath(".//*[not(contains(@class,'message-flag'))]")).isDisplayed())
					count++;
			}	
		}
		return count <= cruiseCardList.size();
	}

	public void selectCruiseWithMoreDiscount() {
		WebElement selected= null;
		getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(cruiseCardList)));
		try{
			WebElement moreDiscount = cruiseCardList.get(0);
			for(WebElement w: cruiseCardList){
				getWait().until(ExpectedConditions.elementToBeClickable(w));
				if(convertDiscount(moreDiscount) <= convertDiscount(w)){
					moreDiscount = w;
				}
			}
			selected = moreDiscount;
		}catch(NoSuchElementException e){

		}
		getWait().until(ExpectedConditions.elementToBeClickable(selected.findElement(By.className("show-dates-button"))));
		selected.findElement(By.className("show-dates-button")).click();
	}


	private int convertDiscount(WebElement element){
		String text = "";
		int value = 0;
		getWait().until(ExpectedConditions.visibilityOf(element));
		try{
			text = element.findElement(By.xpath(".//*[contains(@class,'message-flag')]")).getText();
			text = text.replaceAll("Up to ", "");
			text = text.replaceAll("% off", "");
			value = Integer.parseInt(text);
		}catch (NoSuchElementException e) {

		}
		return value;
	}

	public boolean sailingListIsPresent() {
		return sailingList.isDisplayed();
	}
}

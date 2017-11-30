package com.trainingtae.tareatres.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PkgHotelResultPage extends BasePage {

	@FindBy(id="inpHotelNameMirror")
	private WebElement searchByNameField;

	@FindBy(xpath="//button[@data-opt-group='Price']")
	private WebElement sortByPriceButton;

	@FindBys({@FindBy(xpath="//article")})
	private List <WebElement> hotelResults;

	@FindBy(className="pagination-next")
	private WebElement nextPage;
	
	public PkgHotelResultPage(WebDriver driver) {
		super(driver);
	}

	public boolean searchByNameFieldIsPresent(){
		getWait().until(ExpectedConditions.visibilityOf(searchByNameField));
		return searchByNameField.isDisplayed();
	}

	public boolean validateSortingByPrice() {
		sortByPriceButton.click();
		getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(hotelResults)));
		return validateSorting();
	}


	private boolean validateSorting() {
		int count = 0;
		getWait().until(ExpectedConditions.visibilityOfAllElements(hotelResults));
		WebElement base = hotelResults.get(0).findElement(By.className("actualPrice"));
		for (WebElement w : hotelResults) {
			WebElement value = w.findElement(By.className("actualPrice"));
			if (getPrice(base.getText()) <= getPrice(value.getText())) {
				base = value;
				count++;
			}
		}
		System.out.println("count es"+ count+ "y la lista es"+hotelResults.size());
		return count == hotelResults.size();
	}

	private int getPrice(String text) {
		text = text.replace("$", "");
		return Integer.parseInt(text);
	}

	public SelectedHotelPage selectHotelThreeStars() {
		WebElement selectedHotel = null;
		while(selectedHotel == null){
			getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(hotelResults)));
			for (WebElement w : hotelResults) {
				if(getStarRating(w.findElement(By.className("star-rating")).getText()) >= 3.0){
					selectedHotel = w;
				}
			}
			nextPage.click();
		}
		selectedHotel.click();
		return new SelectedHotelPage(getDriver());
	}

	private float getStarRating(String text){
		text = text.replace(" out of 5.0", "");
		return Float.parseFloat(text);
	}
}

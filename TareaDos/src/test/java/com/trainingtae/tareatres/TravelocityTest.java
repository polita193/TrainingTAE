package com.trainingtae.tareatres;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.trainingtae.tareatres.pageobjects.FlightResultsPage;
import com.trainingtae.tareatres.pageobjects.HomePage;
import com.trainingtae.tareatres.pageobjects.TravelerInfoPage;
import com.trainingtae.tareatres.pageobjects.TripDetailPage;

public class TravelocityTest extends BaseTest {

	@Test(enabled=false)
	public void bookFlightTest() {
		HomePage homepage = getHomePage();
		FlightResultsPage flightResultsPage = homepage.bookFlight("LAS", "LAX");
		Assert.assertTrue(getExpectedList().containsAll(flightResultsPage.getSortingOptions()));
		Assert.assertTrue(flightResultsPage.selectButtonIsPresent());
		Assert.assertTrue(flightResultsPage.flightDurationIsPresent());
		Assert.assertTrue(flightResultsPage.detailsAndFeeIsPresent());
		Assert.assertTrue(flightResultsPage.sortByDurationAsc());
		TripDetailPage tripDetailPage = flightResultsPage.pickFlights();
		Assert.assertTrue(tripDetailPage.tripTotalIsPresent());
		Assert.assertTrue(tripDetailPage.tripInfoIsPresent());
		Assert.assertTrue(tripDetailPage.priceGuaranteeIsPresent());
		TravelerInfoPage travelerInfoPage = tripDetailPage.bookFlight();
		Assert.assertEquals(travelerInfoPage.getUrgencyMessage(), "Avoid change fees. Protect your trip.");
		Assert.assertEquals(travelerInfoPage.getTitle(), "Travelocity: Payment");
		Assert.assertEquals(travelerInfoPage.getQuestionTitle(), "Who's traveling?");
		Assert.assertTrue(travelerInfoPage.bookingButtonIsPresent());
		Assert.assertTrue(travelerInfoPage.summaryTripInfoISPresent());
	}

	@Test(enabled=true)
	public void bookHotelTest(){
		HomePage homepage = getHomePage();
		homepage.bookHotel("Montevideo, Uruguay");
	}
	
	private List<String> getExpectedList() {
		List<String> expectedList = new ArrayList<String>();
		expectedList.add("Price");
		expectedList.add("Departure");
		expectedList.add("Arrival");
		expectedList.add("Duration");
		return expectedList;
	}
}

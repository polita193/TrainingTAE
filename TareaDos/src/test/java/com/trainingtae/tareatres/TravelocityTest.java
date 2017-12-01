package com.trainingtae.tareatres;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.trainingtae.tareatres.pageobjects.CarResulstPage;
import com.trainingtae.tareatres.pageobjects.CruiseResultsPage;
import com.trainingtae.tareatres.pageobjects.FlightResultsPage;
import com.trainingtae.tareatres.pageobjects.HomePage;
import com.trainingtae.tareatres.pageobjects.HotelResultsPage;
import com.trainingtae.tareatres.pageobjects.PackageDetailInfoPage;
import com.trainingtae.tareatres.pageobjects.PkgHotelResultPage;
import com.trainingtae.tareatres.pageobjects.SelectedHotelPage;
import com.trainingtae.tareatres.pageobjects.TravelerInfoPage;
import com.trainingtae.tareatres.pageobjects.TripDetailPage;

public class TravelocityTest extends BaseTest {

	@Test(enabled=true)
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
	public void bookFHCarPackageTest(){
		HomePage homepage = getHomePage();
		PkgHotelResultPage pkgHotelResultsPage = homepage.bookFHCarPackage("LAS", "LAX");
		Assert.assertTrue(pkgHotelResultsPage.searchByNameFieldIsPresent());
		Assert.assertTrue(pkgHotelResultsPage.validateSortingByPrice());
		SelectedHotelPage selectedHotelPage = pkgHotelResultsPage.selectHotelThreeStars();
		Assert.assertTrue(selectedHotelPage.validateStars() >= 3);
		//
		//
		FlightResultsPage flightResultsPage = selectedHotelPage.selectFirstRoom();
		CarResulstPage carResultsPage = flightResultsPage.pickPkgFlightsFHC();
		PackageDetailInfoPage packageDetailInfo = carResultsPage.selectCar();
		//
		//
		//
		//
		//
	}

	@Test(enabled=true)
	public void bookHotelTest(){
		HomePage homepage = getHomePage();
		HotelResultsPage hotelResultsPage = homepage.bookHotel("Montevideo, Uruguay");
		Assert.assertTrue(hotelResultsPage.getDiscountWithEmail());
		Assert.assertTrue(hotelResultsPage.validateSponsored());		
	}

	@Test(enabled=true)
	public void bookFHPackageTest(){
		HomePage homepage = getHomePage();
		String errorMessage = homepage.bookFHPackage("LAS", "LAX");
		Assert.assertEquals(errorMessage, "Your partial check-in and check-out dates must fall within your arrival and departure dates. Please review your dates.");
	}

	@Test(enabled=true)
	public void bookCruiseTest(){
		String destination = "Europe";
		String month = "Jun 2018";
		HomePage homePage= getHomePage();
		CruiseResultsPage cruiseResultsPage = homePage.bookCruise(destination, month);
		Assert.assertTrue(cruiseResultsPage.validateCruiseFilter(destination, month));
		Assert.assertTrue(cruiseResultsPage.isLengthFilterSelected());
		//Assert.assertTrue(cruiseResultsPage.validateCruiseListDiscount());
		//cruiseResultsPage.selectCruiseWithMoreDiscount();
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

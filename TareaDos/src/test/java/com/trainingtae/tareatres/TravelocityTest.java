package com.trainingtae.tareatres;

import org.testng.annotations.Test;

import com.trainingtae.tareatres.pageobjects.HomePage;

public class TravelocityTest extends BaseTest{
	
	@Test
	public void bookFlightTest(){
		HomePage homepage = getHomePage();
		homepage.bookFlight("LAS", "LAX");		
	}
}

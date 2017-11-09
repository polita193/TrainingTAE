package com.trainingtae.tareatres;

import org.testng.annotations.Test;
import com.trainingtae.tareatres.domain.Manager;

public class TravelocityTest {
	
	public Manager manager;

	@Test
	public void bookFlight(){
		
		manager.searchFlight();
	}
}

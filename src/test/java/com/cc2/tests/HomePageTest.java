package com.cc2.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cc2.base.Base;
import com.cc2.pages.FlightsPage;
import com.cc2.pages.HomePage;




public class HomePageTest extends Base{
	HomePage home;
	FlightsPage flight;
	Logger log =Logger.getLogger(HomePageTest.class);
	
	HomePageTest (){
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		home=new HomePage();
		flight=new FlightsPage();
		
	}
	
	@Test()
	public void step1() throws InterruptedException {
		
		home.search();
		log.info("Search flights");
		home.selectFromDate();
		home.date();
		home.DepartureDate();
		log.debug("Departure date is searched");
		home.todate();
		home.clickOnSearch();
		flight.printDepartureFlightRecords();
		flight.printReturnFlightRecords();
		flight.clcikOnNonstopFlights();
		//Assert.assertTrue(flight.verify());
		System.out.println("Selected");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}

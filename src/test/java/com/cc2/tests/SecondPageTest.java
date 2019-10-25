package com.cc2.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cc2.base.Base;
import com.cc2.pages.SecondPage;

import junit.framework.Assert;

public class SecondPageTest extends Base{
	SecondPage second;
	@BeforeMethod
	public void setUp() {
		initialization();
		
		second=new SecondPage();
	}
	
	@Test
	public void verifyDetails() {
		second.clickOnHotels();
		Assert.assertTrue(second.verifyHotels());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}

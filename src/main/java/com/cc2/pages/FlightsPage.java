package com.cc2.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cc2.base.Base;
import com.cc2.utilities.PageScroll;



public class FlightsPage extends Base {
	

	@FindBy(xpath="//div[@id='ow-domrt-jrny']/child::div[2]/child::div")
	List<WebElement> departureFlights;
	
	@FindBy(xpath="//div[@class='splitVw-sctn pull-right']/child::div[2]/child::div")
	List<WebElement> returnFlights;
	
	@FindBy(xpath="//div[@id='stop_group']/child::span[1]")
	WebElement Nonstop;
	
	@FindBy(xpath="//a[@class='pull-right reset-filter stop_reset']")
	WebElement reset;
	
	@FindBy(xpath="//div[@id='stop_group']/child::span[2]")
	WebElement Onestop;
	
	public FlightsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void printDepartureFlightRecords() throws InterruptedException {
		
		PageScroll.toBottomOfPage();
		System.out.println("No of departure flights - "+departureFlights.size());
	}
	
	public void printReturnFlightRecords() {
		//JavascriptExecutor js = ((JavascriptExecutor) driver);
		// js.executeScript("window.scrollTo(document.body.scrollHeight,0);");
		System.out.println("Return flights record- "+returnFlights.size());
	}
	
	public void clcikOnNonstopFlights() {
		Nonstop.click();
	}
	public Boolean verify() {
		Boolean b =Nonstop.isSelected();
		return b;
	}
	public void clickOnOneStopFilter() {
		System.out.println("Title --" +driver.getTitle());
		
		reset.click();
		Onestop.click();
	}
		
	}
	


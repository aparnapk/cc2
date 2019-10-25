package com.cc2.pages;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cc2.base.Base;



public class HomePage extends Base{
	
	WebDriverWait wait;
	
	@FindBy(xpath="//a[@class='active makeFlex hrtlCenter column']/span[2]")
	WebElement flights;

	@FindBy(xpath="//ul[@class='fswTabs latoBlack greyText']/li[2]")
	WebElement roundtrip;
	
	@FindBy(xpath="//label[@for='fromCity']//span[@class='lbl_input latoBold  appendBottom5']")
	WebElement FromEnter;
	
	@FindBy(xpath="//input[@placeholder='From']")
	WebElement fromDropdown;
	
	@FindBy(id="react-autowhatever-1-section-0-item-0")
	WebElement fromval;
	
	@FindBy(xpath="//label[@for='toCity']//span[@class='lbl_input latoBold  appendBottom5']")
	WebElement toEnter;
	
	@FindBy(xpath="//input[@placeholder='To']")
	WebElement todrp;
	
	@FindBy(id="react-autowhatever-1-section-0-item-0")
	WebElement toval;
	
	@FindBy(xpath="//a[@class='primaryBtn font24 latoBlack widgetSearchBtn ']")
	WebElement searchButton;
	
	@FindBy(xpath="//label[@for='departure']")
	WebElement fromdate;
	
	@FindBy(xpath="//div[@class='DayPicker-Caption']")
	WebElement currentMonth;
	String month = "October2019";
	String month1 = "October2019";
	@FindBy(xpath="//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
	WebElement arrow;
	//@FindBy(xpath="//input[@id='return']")
	//WebElement returnDate;
			
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void search() {
		flights.click();
		System.out.println("Clicked on flights tab");
		roundtrip.click();
		System.out.println("clicked on checkbox");
		
		FromEnter.click();
		fromDropdown.sendKeys(" Delhi");
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(fromval)).click();
		toEnter.click();
		todrp.sendKeys("Bangalore");
		wait.until(ExpectedConditions.elementToBeClickable(toval)).click();
		System.out.println("To val selected");
		
		
	}
	
	public void selectFromDate() {
		fromdate.click();
		System.out.println(currentMonth.getText());
		while(true){
			String val = currentMonth.getText();
		if(val.equals(month)) 
		{
			break;
		}
		else
		{
			arrow.click();
		}
	}
	}
	
	public void date() {
	List<WebElement> ts = driver.findElements(By.xpath("//div[@class='DayPicker-Day']"));
	
	System.out.println("Total no of col "+ts.size());
	for(WebElement i:ts) {
		if(i.getText().equals("27")) {
			i.click();
			break;
		}
	}
}
	public void DepartureDate() {
		//returnDate.click();
		System.out.println(currentMonth.getText());
		while(true){
			String val = currentMonth.getText();
		if(val.equals(month1)) 
		{
			break;
		}
		else
		{
			arrow.click();
		}
	}
		
	}
	public void todate() {
		List<WebElement> ts = driver.findElements(By.xpath("//div[@class='DayPicker-Day']"));
		
		System.out.println("Total no of col "+ts.size());
		for(WebElement i:ts) {
			if(i.getText().equals("30")) {
				i.click();
				break;
			}
		}
	
}
	
	public FlightsPage clickOnSearch() {
		searchButton.click();
		return new FlightsPage();
	}
}

			
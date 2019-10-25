package com.cc2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cc2.base.Base;

public class SecondPage extends Base {


	@FindBy(xpath="//li[@data-cy='menu_Hotels']/child::a/span[1]")
	WebElement hotels;
	
	public SecondPage() {
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnHotels() {
		hotels.click();
	}
	
	public Boolean verifyHotels() {
		Boolean b =hotels.isSelected();
		return b;
		
	}
}

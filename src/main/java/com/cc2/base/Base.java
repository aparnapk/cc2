package com.cc2.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Base {
	public Properties prop;
	   public static WebDriver driver;
	   public WebDriverWait wait;
	   public int STANDARD_DELAY = 5;
	   public Base() {
	      try {
	         prop = new Properties();

	         FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
	               + "\\src\\main\\java\\com\\cc2\\properties\\config.properties");
	         prop.load(ip);

	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }

	   public void initialization() {
	      String browserName = prop.getProperty("browser");
	       if(browserName.equals("chrome")) {
	    	   String pat=System.getProperty("user.dir")+"\\src\\main\\java\\com\\cc2\\drivers\\chromedriver.exe";
	    	System.setProperty("webdriver.chrome.driver",pat );
			driver = new ChromeDriver();
	           
	      }
	      initializeWait();
	      driver.manage().window().maximize();
	      driver.manage().deleteAllCookies();
	      driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	      driver.get(prop.getProperty("url"));
	   }

	   public void initializeWait() {
	      wait = new WebDriverWait(driver, 10);
	   }

	   public void waitForElement(WebElement element){
	      wait.until(ExpectedConditions.elementToBeClickable(element));
	   }

	   public void pauseForSeconds(int seconds){
	      try {
	         TimeUnit.SECONDS.sleep(seconds);
	      } catch (InterruptedException e) {
	         e.printStackTrace();
	      }
	   }
}

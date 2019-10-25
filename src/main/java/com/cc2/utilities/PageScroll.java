package com.cc2.utilities;

import org.openqa.selenium.JavascriptExecutor;

import com.cc2.base.Base;





public class PageScroll extends Base {
	
	/*public static void scrollToBottom() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
	    long Height =Long.parseLong(js.executeScript("return document.body.scrollHeight").toString());
		
		System.out.println("height -"+Height);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}*/
	
	//Scrolls till the bottom of page
		public static void toBottomOfPage()
		{
			try {
				JavascriptExecutor js = ((JavascriptExecutor) driver);
			    long Height =Long.parseLong(js.executeScript("return document.body.scrollHeight").toString());
			    
			    while (true) {
			        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			        Thread.sleep(500);

			        long newHeight = Long.parseLong(js.executeScript("return document.body.scrollHeight").toString());
			        if (newHeight == Height) {
			            break;
			        }
			        Height = newHeight;
			    }
			} catch (Exception e) {
			    e.printStackTrace();
			}
		}
}
  
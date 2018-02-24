package com.hr.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {

	
	private WebDriver webdriver;
	public WebDriver getDriver(String name){
	
		switch(name){
		
		case Browser.IE:
		webdriver = new InternetExplorerDriver();
		webdriver.get("http://opensource.demo.orangehrmlive.com/index.php/auth/login");
		break;
		
		case Browser.Chrome:
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\asus\\Downloads\\chromedriver.exe");
			webdriver = new ChromeDriver();
			webdriver.get("http://opensource.demo.orangehrmlive.com/index.php/auth/login");
			break;
		}
		return webdriver;
		
		
	}
}

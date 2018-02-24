package com.hr.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.hr.driver.Driver;
import com.hr.pages.LoginPage;

public class LoginTests {

	Driver driver;
	WebDriver chromeDriver;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setup(){
		
		driver = new Driver();
		chromeDriver =driver.getDriver("Chrome");
		loginPage = new LoginPage(chromeDriver);
	}
	
	@Test
	public void successfulLogin(){
		
		loginPage.login("Admin", "admin");
		String expectedCurrentUrl = "http://opensource.demo.orangehrmlive.com/index.php/dashboar";
		String actualCurrentUrl= chromeDriver.getCurrentUrl();
		Assert.assertEquals(actualCurrentUrl, expectedCurrentUrl);
	}
	
	@Ignore
	public void failedLogin(){
	
		loginPage.login("a", "a");
		String errorMessage = loginPage.getErrorMessage();
		Assert.assertEquals(errorMessage, "Invalid credentials");
	}
	
	@AfterMethod
	public void tearDown(){
		chromeDriver.close();
	}
	
}

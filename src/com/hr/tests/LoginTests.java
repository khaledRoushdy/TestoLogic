package com.hr.tests;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;










import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;










import ExcelUtilitie.Excel;

import com.hr.driver.Driver;
import com.hr.pages.AddUserPage;
import com.hr.pages.AdminPage;
import com.hr.pages.LoginPage;

public class LoginTests {

	Driver driver;
	WebDriver chromeDriver;
	LoginPage loginPage;
	AdminPage adminPage;
	AddUserPage addUserPage;
	
	@BeforeMethod
	public void setup(){
		
		driver = new Driver();
		chromeDriver =driver.getDriver("Chrome");
		loginPage = new LoginPage(chromeDriver);
		adminPage = new AdminPage(chromeDriver);
		addUserPage = new AddUserPage(chromeDriver);
	}
	
	@Test
	public void successfulLogin() throws IOException{
		
		Excel excel = new Excel();
		ArrayList<String> data=  excel.getData("C:\\Users\\asus\\Desktop\\Data.xlsx", "LoginTest");
		
		loginPage.login(data.get(0), data.get(1));
		//loginPage.login("Admin","admin");
		
		String expectedCurrentUrl = "http://opensource.demo.orangehrmlive.com/index.php/dashboard";
		String actualCurrentUrl= chromeDriver.getCurrentUrl();
		Assert.assertEquals(actualCurrentUrl, expectedCurrentUrl);
	}
	
	@Test
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

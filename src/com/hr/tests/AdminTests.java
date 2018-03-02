package com.hr.tests;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ExcelUtilitie.Excel;

import com.hr.driver.Driver;
import com.hr.pages.AddUserPage;
import com.hr.pages.AdminPage;
import com.hr.pages.LoginPage;

public class AdminTests {

	Driver driver;
	WebDriver chromeDriver;
	LoginPage loginPage;
	AdminPage adminPage;
	AddUserPage addUserPage;

	@BeforeMethod
	public void setup() {

		driver = new Driver();
		chromeDriver = driver.getDriver("Chrome");
		loginPage = new LoginPage(chromeDriver);
		adminPage = new AdminPage(chromeDriver);
		addUserPage = new AddUserPage(chromeDriver);
	}

	@Test
	public void AddUserTest() throws IOException {

		Excel excel = new Excel();
		ArrayList<String> data = excel.getData(
				"C:\\Users\\asus\\Desktop\\Data.xlsx", "LoginTest");
		loginPage.login(data.get(0), data.get(1));
		adminPage.ClickAdminMenuButton();
		adminPage.Add();
		addUserPage.Save(1, "Fiona Grace", "khaled", "Enabled", "1234", "1234");
	}
	
	@AfterMethod
	public void tearDown(){
		chromeDriver.close();
	}
}



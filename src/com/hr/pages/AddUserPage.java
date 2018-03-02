package com.hr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddUserPage {

	private WebDriver driver;
	private By userRoleLocator = By.id("systemUser_userType");
	private By employeeNameLocator = By.id("systemUser_employeeName_empName");
	private By userNameLocator = By.id("systemUser_userName");
	private By statusLocator = By.id("systemUser_status");
	private By passwordLocator = By.id("systemUser_password");
	private By confirmPasswordLocator = By.id("systemUser_confirmPassword");
	private By saveButtonLocator = By.id("btnSave");
	private By cancelButtonLocator = By.id("btnCancel");

	public AddUserPage(WebDriver driver) {
		this.driver = driver;
	}

	private WebElement getUserRole() {
		
		return driver.findElement(userRoleLocator);
	}
	private WebElement getEmployeeName() {
		
		return driver.findElement(employeeNameLocator);
	}

	private WebElement getUserName() {
		return driver.findElement(userNameLocator);
	}

	private WebElement getStatus() {
		return driver.findElement(statusLocator);
	}

	private WebElement getPassword() {
		return driver.findElement(passwordLocator);
	}

	private WebElement getConfirmPassword() {
		return driver.findElement(confirmPasswordLocator);
	}

	private WebElement getSaveButton() {
		return driver.findElement(saveButtonLocator);
	}

	private WebElement getCancelButton() {
		return driver.findElement(cancelButtonLocator);
	}
	
	private void SelectItemByVisbleText(WebElement e,String item){
		Select select= new Select(e);
		select.selectByVisibleText(item);
	}
	
	private void SelectItemIndex(WebElement e,int idex){
		Select select= new Select(e);
		select.selectByIndex(idex);
	}
	
	private void fillUserData(int role,String empName,String userName,String status,String password,String confirmPassword){
		SelectItemIndex(getUserRole(),role);
		getEmployeeName().sendKeys(empName);
		getUserName().sendKeys(userName);
		SelectItemByVisbleText(getStatus(), status);
		getPassword().sendKeys(password);
		getConfirmPassword().sendKeys(confirmPassword);
	}

	public void Save(int role,String empName,String userName,String status,String password,String confirmPassword) {
		
		fillUserData(role, empName, userName, status, password, confirmPassword);
		getSaveButton().click();
	}

	public void Cancel(int role,String empName,String userName,String status,String password,String confirmPassword) {
		
		fillUserData(role, empName, userName, status, password, confirmPassword);
		getCancelButton().click();
	}
}

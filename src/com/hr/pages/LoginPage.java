package com.hr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;
	private By userNameLocator = By.id("txtUsername");
	private By passwordNameLocator = By.id("txtPassword");
	private By loginButtonLocator = By.name("Submit");
	private By errorMessageLocator = By.id("spanMessage");
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	private WebElement UserNameElement(){
		return driver.findElement(userNameLocator);
	}
	
	private WebElement passwordElement(){
		return driver.findElement(passwordNameLocator);
	}
	
	private WebElement loginButtonElement(){
		return driver.findElement(loginButtonLocator);
	}
	
	private WebElement errorMessageElement(){
		return driver.findElement(errorMessageLocator);
	}
	
	public void login(String username,String password){
		
		UserNameElement().sendKeys(username);
		passwordElement().sendKeys(password);
		loginButtonElement().click();
	}
	
	public String getErrorMessage(){
		return errorMessageElement().getText();
	}
}

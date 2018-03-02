package com.hr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage {

	private WebDriver driver;
	private By adminLocator = By.id("menu_admin_viewAdminModule");
	private By addButtonLocator = By.id("btnAdd");
	
	public AdminPage(WebDriver driver){
		this.driver = driver;
	}
	
	private WebElement getAdminMenuButton(){
		
		WebElement adminMenuButton = driver.findElement(adminLocator);
		return adminMenuButton;
	}
	
	private WebElement getAddButton(){
		WebElement addButton = driver.findElement(addButtonLocator);
		return addButton;
	}
	
	public void ClickAdminMenuButton(){
		
		WebElement adminMenuButton= getAdminMenuButton();
		adminMenuButton.click();
		
	}
	
	public void Add(){
		WebElement addButton= getAddButton();
		addButton.click();
	}
	
	public void Search(){
		
	}
	
	public void Reset(){
		
	}
	
	public void delet(){
		
	}
	
	
	
	
}

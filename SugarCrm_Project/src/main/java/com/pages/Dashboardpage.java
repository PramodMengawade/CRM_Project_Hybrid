package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class Dashboardpage extends BaseClass{

	public WebDriver driver;
	

	@FindBy(xpath="//b[text()='Java By Kiran']")
	WebElement header;
	
	//@FindBy(xpath="//span[text()='Users']")
	//WebElement userBtn;
	
	@FindBy(id="moduleTab_2_Home")
	WebElement supporttab;

	public Dashboardpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public Userpage clickuser() {
		supporttab.click();
		return new Userpage(driver);
	}
	public String getHeader() {
		
		return header.getText();
	}
	
}

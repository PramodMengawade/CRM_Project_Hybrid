package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

public class MarketingPage extends BaseClass {
	

	//Marketing Tab
	@FindBy(xpath="//a[@id='grouptab_1']")
	WebElement marketingtab;
	
	@FindBy(xpath="//a[@id='moduleTab_1_Home']")
	WebElement hometab;
	
	//Add Dashlet Button
	@FindBy(xpath="//input[@id='add_dashlets']")
	WebElement addDashletbtn;
	
	@FindBy(xpath="//div[@class='container-close']")
	WebElement closedashletbtn;
	
	//Account Tab
	@FindBy(xpath="//a[@id='moduleTab_1_Accounts']")
	WebElement accounttab;	
	
	//Create Button
	@FindBy(xpath="//a[@id='create_link']")
	WebElement createbtn;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement namefield;
	
	@FindBy(xpath="//input[@id='phone_office']")
	WebElement billphonefield;
	
	@FindBy(xpath="//textarea[@id='billing_address_street']")
	WebElement billstreetfield;
	
	@FindBy(xpath="//input[@id='billing_address_city']")
	WebElement billcityfield;
	
	@FindBy(xpath="//input[@id='billing_address_state']")
	WebElement billstatefield;
	
	@FindBy(xpath="//input[@id='billing_address_country']")
	WebElement billcountryfield;
	
	
	public MarketingPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public void validateMarketingTab()
	{
		marketingtab.click();
	}
	
/*	public void validateHomeTab()
	{
		hometab.click();
	}
	
	public void validateAddDashletBtn()
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(addDashletbtn));
		addDashletbtn.click();
	}
	
	public void validateCloseDashletBtn()
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(closedashletbtn));
		closedashletbtn.click();
	}*/

	public void validateAccountTab()
	{
		accounttab.click();
	}
	
	public void validateCreateButton()
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(createbtn));
		createbtn.click();
	}
	
	public void validateNameField()
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(namefield));
		namefield.sendKeys("Pramod");
	}
	
	public void validateBillPhoneField()
	{
		billphonefield.sendKeys("9922123456");
	}
	
	public void validateBillStreetField()
	{
		billstreetfield.sendKeys("MG Road");
	}
	
	public void validateBillCityField()
	{
		billcityfield.sendKeys("Ahemednagar");
	}
	
	public void validateBillStateField()
	{
		billstatefield.sendKeys("Maharahstra");
	}
	
	public void validateBillCountryField()
	{
		billcountryfield.sendKeys("India");
	}
}

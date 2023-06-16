package com.tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pages.Loginpage;
import com.pages.MarketingPage;

public class LoginTest extends BaseClass 
{
	
	int count=1;
	
	//Loginpage lp= null;
	//MarketingPage mp=null;*/
	
	@BeforeSuite
	public void setup()throws Exception 
	{
		//initialization();
		//lp= new Loginpage(driver);
		//mp=new MarketingPage(driver);
	
	}
	
/*	@Test
	public void test01() {
		lp.loginToApplication("admin", "pass");
		Assert.assertEquals(driver.getTitle(), "WebStocker");
	}
	*/

	
	@Test
	public void test01() throws Exception
	{
		
		while(count<=3)
		{
			
		initialization();
		Loginpage lp= null;
		lp= new Loginpage(driver);
		
		driver.findElement(By.id("user_name")).sendKeys(lp.getCellData(count, 0));
		driver.findElement(By.id("user_password")).sendKeys(lp.getCellData(count, 1));
		
	
		driver.findElement(By.id("login_button")).click();
		
		if(driver.getTitle().contains("WebStocker")) 
		
		{
			lp.writeCell(count, 2, "Pass");
			count++;
			//lp.validateLogoutbtn();
			
		}
		else
		{
			lp.writeCell(count, 2, "Fail");
			count++;
		}
		}
	}
	
/*	@Test
	public void test02() {
		Assert.assertEquals(driver.getTitle(), "WebStocker1");
	}
	@Test
	public void test03() {
		throw new SkipException("skipping testcase");
	}
	
	@Test
	public void test04()
	{
		mp.validateMarketingTab();
	}
	*/
/*	@Test
	public void test05()
	{
		mp.validateHomeTab();
	}
	
	@Test
	public void test06()
	{
		mp.validateAddDashletBtn();
	}
	
	@Test
	public void test07()
	{
		mp.validateCloseDashletBtn();
	}*/

/*	@Test
	public void test08()
	{
		mp.validateAccountTab();
	}
	
	@Test
	public void test09()
	{
		mp.validateCreateButton();
	}
	
	@Test
	public void test10()
	{
		mp.validateNameField();
	}
	
	@Test
	public void test11()
	{
		mp.validateBillPhoneField();
	}
	
	@Test
	public void test12()
	{
		mp.validateBillStreetField();
	}
	
	@Test
	public void test13()
	{
		mp.validateBillCityField();
	}
	
	@Test
	public void test14()
	{
		mp.validateBillStateField();
	}
	
	@Test
	public void test15()
	{
		mp.validateBillCountryField();
	}*/
}

package com.pages;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class Loginpage extends BaseClass{

	
	@FindBy(id="user_name")
	WebElement username;
	
	@FindBy(id="user_password")
	WebElement password;
	
	@FindBy(id="login_button") 
	WebElement loginBtn;
	
	@FindBy(xpath="//a[@id='logout_link']") 
	WebElement logoutBtn;
	
	public Loginpage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	public void loginToApplication(String uname, String pass) 
	{		
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginBtn.click();

	}
	
	
	/*public Dashboardpage validLogin() 
	{
		username.sendKeys("admin");
		password.sendKeys("pass");
		loginBtn.click();
		return new Dashboardpage(driver);
		
	}*/
	
	
	int count=1;Sheet sh=null;
	Row r=null;
	Cell c=null;

	public String getCellData(int row, int col) throws Exception
	{
		
		DataFormatter df=new DataFormatter();
		FileInputStream fis=new FileInputStream("Test.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1"); 
		Cell c=sh.getRow(row).getCell(col);
		
		return df.formatCellValue(c);
	}
	
	public void writeCell(int row, int col, String data) throws Exception
	{
		FileInputStream fis=new FileInputStream("Test.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		if(wb.getSheet("Sheet1")==null)
		{
			sh=wb.createSheet("Sheet1");
			r=sh.createRow(row);
			c=r.createCell(col);
		}
		else
		{
			sh=wb.getSheet("Sheet1");
			if(sh.getRow(row)==null)
			{
				r=sh.createRow(row);
				c=r.createCell(col);
			}
			else
			{
				r=sh.getRow(row);
				if(r.getCell(col)==null)
					c=r.createCell(col);
				else
					c=r.getCell(col);
			}
		}
		
		c.setCellValue(data);
		FileOutputStream fos=new FileOutputStream("Test.xlsx");
		wb.write(fos);
		wb.close();
		fos.close();
	}

	public void validateLogoutbtn()
	{
		logoutBtn.click();
	}
}

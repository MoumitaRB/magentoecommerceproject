package com.magentoecommerceproject.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.magentoecommerceproject.pageObjects.AdminHomePage;
import com.magentoecommerceproject.pageObjects.AdminLoginPage;
import com.magentoecommerceproject.testBase.BaseClass;

public class ExportAllOrdersInCSVFilesAndSendTheseFilesToAnotherEmailIdAsAttachment_010 extends BaseClass{
	
	public AdminLoginPage alpObj;
	public AdminHomePage ahpObj;
	
	@Test
	public void verifyingConsoleDisplaysAllOrderInformation() throws IOException, Exception
	{
		driver.get(propObj.getProperty("baseURL2"));
		alpObj=new AdminLoginPage(driver);
		alpObj.setUserName("user01");
		alpObj.setPassword("guru99com");
		alpObj.clickOnLoginBtn();
		Thread.sleep(3000);
		ahpObj=new AdminHomePage(driver);
		ahpObj.clickOnCloseBtn();
		ahpObj.clickOnOrderTabUnderSalesTab();
		Thread.sleep(1000);
		ahpObj.selectCSVOptionFromDropDown("CSV");
		ahpObj.clickOnExportBtn();
		Thread.sleep(5000);
		boolean fileExsistsStatus=ahpObj.isFileExsists("C://Users//moumi//Downloads//orders.csv");
		Thread.sleep(4000);
		if(fileExsistsStatus==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		ahpObj.readCSVFile("C://Users//moumi//Downloads//orders.csv");
		Thread.sleep(20000);
	}

}

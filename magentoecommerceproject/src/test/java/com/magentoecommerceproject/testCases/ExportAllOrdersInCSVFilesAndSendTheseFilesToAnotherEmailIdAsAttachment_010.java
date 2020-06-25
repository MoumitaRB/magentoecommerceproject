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
		logger.info("**************************Starting of ExportAllOrdersInCSVFilesAndSendTheseFilesToAnotherEmailIdAsAttachment_010*********************************");
		alpObj.setUserName("user01");
		alpObj.setPassword("guru99com");
		alpObj.clickOnLoginBtn();
		Thread.sleep(3000);
		ahpObj=new AdminHomePage(driver);
		ahpObj.clickOnCloseBtn();
		ahpObj.clickOnOrderTabUnderSalesTab();
		Thread.sleep(1000);
		logger.info("***********************Downloading CSV File************************");
		ahpObj.selectCSVOptionFromDropDown("CSV");
		ahpObj.clickOnExportBtn();
		Thread.sleep(5000);
		boolean fileExsistsStatus=ahpObj.isFileExsists("C://Users//moumi//Downloads//orders.csv");
		Thread.sleep(4000);
		if(fileExsistsStatus==true)
		{   
			logger.info("*********************CSV File is Exsists***********************");
			Assert.assertTrue(true);
		}
		else
		{   
			logger.warn("************************CSV File does not exsist*****************");
			captureScreen(driver, "verifyingConsoleDisplaysAllOrderInformation");
			Assert.assertTrue(false);
		}
		
		logger.info("***********************Reading CSV File is successful************************");
		ahpObj.readCSVFile("C://Users//moumi//Downloads//orders.csv");
		Thread.sleep(20000);
		
		logger.info("*************************Ending of ExportAllOrdersInCSVFilesAndSendTheseFilesToAnotherEmailIdAsAttachment_010********************************");
	}
}
	

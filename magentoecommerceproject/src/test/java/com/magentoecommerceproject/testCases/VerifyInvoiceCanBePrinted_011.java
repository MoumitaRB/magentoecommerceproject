package com.magentoecommerceproject.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.magentoecommerceproject.pageObjects.AdminHomePage;
import com.magentoecommerceproject.pageObjects.AdminLoginPage;
import com.magentoecommerceproject.testBase.BaseClass;

public class VerifyInvoiceCanBePrinted_011 extends BaseClass{
	
	public AdminLoginPage alpObj;
	public AdminHomePage ahpObj;
	
	@Test
	public void verifyingErrorMsg() throws InterruptedException, IOException
	{
		driver.get(propObj.getProperty("baseURL2"));
		alpObj=new AdminLoginPage(driver);
		logger.info("**************************Staring of VerifyInvoiceCanBePrinted_011**********************");
		alpObj.setUserName("user01");
		alpObj.setPassword("guru99com");
		alpObj.clickOnLoginBtn();
		Thread.sleep(3000);
		ahpObj=new AdminHomePage(driver);
		ahpObj.clickOnCloseBtn();
		ahpObj.clickOnOrderTabUnderSalesTab();
		Thread.sleep(1000);
		ahpObj.selectStatusOptionsFromDropdown("Canceled");
		Thread.sleep(2000);
		ahpObj.clickOnSearchBtn();
		Thread.sleep(2000);
		ahpObj.clickOnCheckBox();
		Thread.sleep(2000);
		ahpObj.selectActionOptionsFromDropdown("Print Invoices");
		Thread.sleep(2000);
		ahpObj.clickOnSubmitBtn();
		Thread.sleep(2000);
		boolean errorMsgStatus=ahpObj.verifyingErrorMsg("There are no printable documents related to selected orders.");
		if(errorMsgStatus==true)
		{
		   logger.info("************************Error Msg Status Verification is Successful***********************");
		   Assert.assertTrue(true);
		}
		else
		{
		   logger.warn("************************Error Msg Status Verification is not Successful***********************");
		   captureScreen(driver, "verifyingErrorMsg");
		   Assert.assertTrue(false);
		   Thread.sleep(3000);
		
		}
	}
	
	@Test
	public void verifyingInvoiceIsDownloaded() throws InterruptedException, IOException
	{   
		ahpObj=new AdminHomePage(driver);
		ahpObj.selectStatusOptionsFromDropdown("Complete");
		Thread.sleep(3000);
		ahpObj.clickOnSearchBtn();
		Thread.sleep(2000);
		ahpObj.clickOnCheckBox();
		Thread.sleep(3000);
		ahpObj.selectActionOptionsFromDropdown("Print Invoices");
		ahpObj.clickOnSubmitBtn();
		Thread.sleep(4000);
		ahpObj.getLatestFilefromDir("C://Users//moumi//Downloads");
		Thread.sleep(10000);
		boolean b1=ahpObj.isFileExsistsMethod2();
		Thread.sleep(3000);
		if(b1==true)
		{
		  logger.info("************************File exsists is successful*****************************");
		  Assert.assertTrue(true);
		}
		else
		{ 
			logger.warn("************************File exsists is not successful*****************************");
		    captureScreen(driver, "verifyingInvoiceIsDownloaded");
		    Assert.assertTrue(false);
		}
		
		Thread.sleep(3000);
		logger.info("************************Ending of VerifyInvoiceCanBePrinted_011******************");
	}

}

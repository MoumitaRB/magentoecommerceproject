package com.magentoecommerceproject.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.magentoecommerceproject.pageObjects.AdminHomePage;
import com.magentoecommerceproject.pageObjects.AdminLoginPage;
import com.magentoecommerceproject.testBase.BaseClass;

public class VerifyDisabledAndBlankFields_015 extends BaseClass{
	
	public AdminLoginPage alpObj;
	public AdminHomePage ahpObj;
	
	
	@Test
	public void verifyingDisabledAndBlankFieldsUnderCustomerInformation() throws InterruptedException, IOException
	{
		driver.get(propObj.getProperty("baseURL2"));
		Thread.sleep(3000);
		logger.info("**************************Starting of VerifyDisabledAndBlankFields_015*******************************");
		alpObj=new AdminLoginPage(driver);
		alpObj.setUserName("user01");
		alpObj.setPassword("guru99com");
		alpObj.clickOnLoginBtn();
		Thread.sleep(3000);
		ahpObj=new AdminHomePage(driver);
		ahpObj.clickOnCloseBtn();
		ahpObj.clickOnManageCustomerTabUnderCustomerTab();
		ahpObj.clickOnCheckBoxForCustomerDetails();
		ahpObj.clickOnEditLink();
		Thread.sleep(3000);
		ahpObj.clickOnAccountInformationTab();
		Thread.sleep(3000);
		boolean disabledStatus=ahpObj.verifyingDisabledFields();
		System.out.println(disabledStatus);
		Thread.sleep(4000);
		boolean blankStatus=ahpObj.verifyingBlankFields();
		System.out.println(blankStatus);
		Thread.sleep(4000);
		if((disabledStatus==true)&&(blankStatus==true))
		{   
			logger.info("*************************Verification of disabled status & blanked status are successful***************************");
			Assert.assertTrue(true);
		}
		else
		{   
			logger.warn("*************************Verification of disabled status & blanked status are not successful*************************");
			captureScreen(driver,"verifyingDisabledAndBlankFieldsUnderCustomerInformation");
			Assert.assertTrue(false);
		}
		
		Thread.sleep(5000);
		logger.info("***********************Ending of VerifyDisabledAndBlankFields_015**********************");
	}

}

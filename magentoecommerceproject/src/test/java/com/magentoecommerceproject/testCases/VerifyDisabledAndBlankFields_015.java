package com.magentoecommerceproject.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.magentoecommerceproject.pageObjects.AdminHomePage;
import com.magentoecommerceproject.pageObjects.AdminLoginPage;
import com.magentoecommerceproject.testBase.BaseClass;

public class VerifyDisabledAndBlankFields_015 extends BaseClass{
	
	public AdminLoginPage alpObj;
	public AdminHomePage ahpObj;
	
	
	@Test
	public void verifyingDisabledAndBlankFieldsUnderCustomerInformation() throws InterruptedException
	{
		driver.get(propObj.getProperty("baseURL2"));
		Thread.sleep(3000);
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
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		Thread.sleep(5000);
	}

}

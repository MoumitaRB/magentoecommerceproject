package com.magentoecommerceproject.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.magentoecommerceproject.pageObjects.AdminHomePage;
import com.magentoecommerceproject.pageObjects.AdminLoginPage;
import com.magentoecommerceproject.testBase.BaseClass;

public class VerifyInvoiceCanBePrinted_011 extends BaseClass{
	
	public AdminLoginPage alpObj;
	public AdminHomePage ahpObj;
	
	@Test
	public void verifyingErrorMsg() throws InterruptedException
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
		Assert.assertEquals(errorMsgStatus, true);
		Thread.sleep(3000);
		
		
	}
	
	@Test
	public void verifyingInvoiceIsDownloaded() throws InterruptedException
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
		Assert.assertEquals(b1, true);
		
		Thread.sleep(3000);
		
	}

}

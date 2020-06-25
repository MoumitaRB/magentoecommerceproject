package com.magentoecommerceproject.testCases;

import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.magentoecommerceproject.pageObjects.AdminHomePage;
import com.magentoecommerceproject.pageObjects.AdminLoginPage;
import com.magentoecommerceproject.testBase.BaseClass;

public class VerifyingSortIsWorkingCorrectly_013 extends BaseClass{
	
	public AdminLoginPage alpObj;
	public AdminHomePage ahpObj;
	
	@Test
	public void verifyingSortFunctionalityInDecendingOrder() throws InterruptedException, ParseException, IOException
	{
		driver.get(propObj.getProperty("baseURL2"));
		Thread.sleep(3000);
		logger.info("**************************Starting of VerifyingSortIsWorkingCorrectly_013*************************");
		alpObj=new AdminLoginPage(driver);
		alpObj.setUserName("user01");
		alpObj.setPassword("guru99com");
		alpObj.clickOnLoginBtn();
		Thread.sleep(3000);
		ahpObj=new AdminHomePage(driver);
		ahpObj.clickOnCloseBtn();
		ahpObj.clickOnInvoiceTabUnderSaleTab();
		ahpObj.storingInvoiveDatesInArraylists();
		Thread.sleep(6000);
		boolean b1=ahpObj.sortingInvoiceDatesInDecendingOrder();
		Thread.sleep(3000);
		logger.info("**************************Sorting invoice dates in decesding order is successful*************************");
		captureScreen(driver, "verifyingSortFunctionalityInDecendingOrder");
		Assert.assertEquals(b1, true);
	}

	@Test(dependsOnMethods="verifyingSortFunctionalityInDecendingOrder")
	public void verifyingSortFunctionalityInAssendingOrder() throws InterruptedException, ParseException, IOException
	{
		ahpObj=new AdminHomePage(driver);
		ahpObj.clickOnInvoiceDateBtn();
		Thread.sleep(2000);
		ahpObj.storingInvoiveDatesInArraylists();
		Thread.sleep(6000);
		boolean b2=ahpObj.sortingInvoiceDatesInAssendingOrder();
		logger.info("*************************Sorting invoice dates in assending order is successful*********************");
		captureScreen(driver, "verifyingSortFunctionalityInAssendingOrder");
		Assert.assertEquals(b2, true);
		Thread.sleep(4000);
		
		logger.info("**************************Ending of VerifyingSortIsWorkingCorrectly_013***********************");
	}
}

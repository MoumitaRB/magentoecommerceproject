package com.magentoecommerceproject.testCases;

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
	public void verifyingSortFunctionalityInDecendingOrder() throws InterruptedException, ParseException
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
		ahpObj.clickOnInvoiceTabUnderSaleTab();
		ahpObj.storingInvoiveDatesInArraylists();
		Thread.sleep(6000);
		boolean b1=ahpObj.sortingInvoiceDatesInDecendingOrder();
		Thread.sleep(3000);
		Assert.assertEquals(b1, true);
	}

	@Test(dependsOnMethods="verifyingSortFunctionalityInDecendingOrder")
	public void verifyingSortFunctionalityInAssendingOrder() throws InterruptedException, ParseException
	{
		ahpObj=new AdminHomePage(driver);
		ahpObj.clickOnInvoiceDateBtn();
		Thread.sleep(2000);
		ahpObj.storingInvoiveDatesInArraylists();
		Thread.sleep(6000);
		boolean b2=ahpObj.sortingInvoiceDatesInAssendingOrder();
		Assert.assertEquals(b2, true);
		Thread.sleep(4000);
	}
}

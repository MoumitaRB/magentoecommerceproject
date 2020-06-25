package com.magentoecommerceproject.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.magentoecommerceproject.pageObjects.DashBoardPage;
import com.magentoecommerceproject.pageObjects.HomePage;
import com.magentoecommerceproject.pageObjects.LoginPage;
import com.magentoecommerceproject.testBase.BaseClass;

public class VerifyYouWillBeAbleToSavePrevoisOrderAsAPDFFile_007 extends BaseClass{
	
	public HomePage hpObj;
	public LoginPage lpObj;
	public DashBoardPage dbpObj;
	
	@Test
	public void verifyingPreviouslyCreatedOrderIsDisplayedInRecentOrder() throws InterruptedException
	{
		driver.get(propObj.getProperty("baseURL"));
		hpObj=new HomePage(driver);
		
		logger.info("**********************Starting Of VerifyYouWillBeAbleToSavePrevoisOrderAsAPDFFile_007*********************");
		hpObj.clickOnMyAccountLink();
		lpObj=new LoginPage(driver);
		lpObj.setRegisteredEmailId("samit@gmail.com");
		lpObj.setRegisteredPassword("samitroy");
		lpObj.clickOnLoginBtn();
		dbpObj=new DashBoardPage(driver);
		dbpObj.clickOnMyOrderLink();
		boolean orderStatus=dbpObj.verifyingPrevioulyCreatedOrderIsDisplayedInRecentOrdersTable("100012048", "Pending");
		Thread.sleep(3000);
		logger.info("***************Verification Of OrderStatus is successful*****************");
		Assert.assertEquals(orderStatus, true);
		dbpObj.clickOnViewOrderBtn();
		Thread.sleep(3000);
		dbpObj.clickOnPrintOrderBtn();
		Thread.sleep(3000);
		dbpObj.handlingWindows("Print Order # 100012048", "Order # 100012048" );
		Thread.sleep(3000);
		dbpObj.switchToChildWindowId2();
		Thread.sleep(3000);
		dbpObj.selectPDFOption();
		Thread.sleep(2000);
		dbpObj.clickOnSaveButton();
		Thread.sleep(4000);
		

	}

}

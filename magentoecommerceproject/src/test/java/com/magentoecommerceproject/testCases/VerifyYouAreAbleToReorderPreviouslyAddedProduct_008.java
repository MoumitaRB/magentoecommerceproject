package com.magentoecommerceproject.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.magentoecommerceproject.pageObjects.DashBoardPage;
import com.magentoecommerceproject.pageObjects.HomePage;
import com.magentoecommerceproject.pageObjects.LoginPage;
import com.magentoecommerceproject.testBase.BaseClass;

public class VerifyYouAreAbleToReorderPreviouslyAddedProduct_008 extends BaseClass {
	
	public HomePage hpObj;
	public LoginPage lpObj;
	public DashBoardPage dbpObj;
	
	@Test
	public void verifyingGrandTotalIsChangedAfterUpdatingTheProductQuantity() throws InterruptedException, IOException
	{
		driver.get(propObj.getProperty("baseURL"));
		hpObj=new HomePage(driver);
		
		logger.info("*********************Starting Of VerifyYouAreAbleToReorderPreviouslyAddedProduct_008************************");
		hpObj.clickOnMyAccountLink();
		lpObj=new LoginPage(driver);
		lpObj.setRegisteredEmailId("samit@gmail.com");
		lpObj.setRegisteredPassword("samitroy");
		lpObj.clickOnLoginBtn();
		dbpObj=new DashBoardPage(driver);
		dbpObj.clickOnReorderLinkInRecentOrder("100012063");
		Thread.sleep(2000);
		dbpObj.changeTheQuantityAndClickOnUpdateBtn("10");
		boolean grandTotalStatus=dbpObj.verifyTheGrandTotalIsChanged("GRAND TOTAL", 6200.00);
		Thread.sleep(4000);
		dbpObj.clickOnProceedToCheckOutBtn();
		dbpObj.clickOnDropDownBtn("New Address");
		dbpObj.fillingBillingAddressForm("Samit","Roy", "6789 AppleValley", "ClifRoad", "Eagan", "New York", "542896", "United States", "12345678");
		Thread.sleep(4000);
		dbpObj.ClickOnContinueBtn();
		Thread.sleep(1000);
		dbpObj.clickOnContinueBtn2();
		Thread.sleep(1000);
		dbpObj.clickOnRadioBtnForCashPayment();
		Thread.sleep(1000);
		dbpObj.clickOnContinueBtn3();
		Thread.sleep(5000);
		dbpObj.clickOnPlaceAnOrderBtn();
		Thread.sleep(3000);
		boolean orderIdGerenatedStatus=dbpObj.verifyingOrderNumberIsGeneratedAfterReorder("YOUR ORDER HAS BEEN RECEIVED.");
		if((grandTotalStatus==true)&&(orderIdGerenatedStatus==true))
		{   
			logger.info("********************Verifying GrandToatalStatus and OrderIdGeneratedStatus are successful*****************************");
			Assert.assertTrue(true);
		}
		else
		{   
			logger.warn("***********************Verifying GrandToatalStatus and OrderIdGeneratedStatus are not successful********************");
			captureScreen(driver, "verifyingGrandTotalIsChangedAfterUpdatingTheProductQuantity");
			Assert.assertTrue(false);
		}
	    Thread.sleep(4000);
		
	}
	
	

}

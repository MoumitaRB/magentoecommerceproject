package com.magentoecommerceproject.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.magentoecommerceproject.pageObjects.DashBoardPage;
import com.magentoecommerceproject.pageObjects.HomePage;
import com.magentoecommerceproject.pageObjects.LoginPage;
import com.magentoecommerceproject.testBase.BaseClass;

public class VerifyUserIsAbleToPurchaseProductUsingRegisteredEmailId_006 extends BaseClass {
	
	public HomePage hpObj;
	public LoginPage lpObj;
	public DashBoardPage dbpObj;
	
	@Test
	public void verifyingFlatRateShippingCostIsAdded() throws InterruptedException, IOException
	{
		driver.get(propObj.getProperty("baseURL"));
		hpObj=new HomePage(driver);
		
		logger.info("*******************Starting of VerifyUserIsAbleToPurchaseProductUsingRegisteredEmailId_006**********************");
		hpObj.clickOnMyAccountLink();
		lpObj=new LoginPage(driver);
		lpObj.setRegisteredEmailId("samit@gmail.com");
		lpObj.setRegisteredPassword("samitroy");
		lpObj.clickOnLoginBtn();
		lpObj.clickOnTVLink();
		lpObj.clickOnAddToWishList("LG LCD");
		Thread.sleep(2000);
		dbpObj=new DashBoardPage(driver);
		dbpObj.clickOnWishListlink();
		Thread.sleep(1000);
		dbpObj.ClickOnAddToCartButton();
		Thread.sleep(1000);
		dbpObj.clickOnProceedToCheckOutBtn();
		Thread.sleep(3000);
		dbpObj.clickOnDropDownBtn("New Address");
		Thread.sleep(3000);
		logger.info("*******************Providing informatiom for filling the billing address******************");
		dbpObj.fillingBillingAddressForm("Samit","Roy","6789 AppleValley", "ClifRoad","Eagan", "New York","542896", "United States","12345678");
		Thread.sleep(4000);
		dbpObj.ClickOnContinueBtn();
		boolean taxrateStatus=dbpObj.verifyingFlatRateShippingIsGenarated("Flat Rate",5.00);
		Thread.sleep(3000);
		dbpObj.clickOnContinueBtn2();
		Thread.sleep(1000);
		dbpObj.clickOnRadioBtnForCashPayment();
		Thread.sleep(1000);
		dbpObj.clickOnContinueBtn3();
		Thread.sleep(1000);
		dbpObj.gettingTheTotalAfterAddingShippingCost(615.0, 5.00);
		boolean totalStatus=dbpObj.verifyingTheTotalProductCostAfterAddingShippingCost();
		Thread.sleep(6000);
		dbpObj.clickOnPlaceAnOrderBtn();
		boolean orderStatus=dbpObj.verifyingOrderIsPlacedAndOrderNumberGenerated("YOUR ORDER HAS BEEN RECEIVED.");
        Thread.sleep(6000);
		if((taxrateStatus==true)&&(totalStatus==true)&&(orderStatus==true))
		{   
			logger.info("********************Verifyng TaxrateStatus TotalStatus and OrderStatus are successful**********************");
			Assert.assertTrue(true);
		}
		else
		{   
			logger.warn("**********************Verifying TaxrateStatus TotalStatus and OrderStatus are not successful**********************");
			captureScreen(driver, "verifyingFlatRateShippingCostIsAdded");
			Assert.assertTrue(false);
		}
	
     logger.info("**********************Ending of VerifyUserIsAbleToPurchaseProductUsingRegisteredEmailId_006***************************");
 }
}

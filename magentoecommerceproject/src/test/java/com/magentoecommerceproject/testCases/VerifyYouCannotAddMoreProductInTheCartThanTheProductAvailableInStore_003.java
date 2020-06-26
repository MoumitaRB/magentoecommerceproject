package com.magentoecommerceproject.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.magentoecommerceproject.pageObjects.HomePage;
import com.magentoecommerceproject.pageObjects.ProceedToCheckOutPage;
import com.magentoecommerceproject.testBase.BaseClass;

public class VerifyYouCannotAddMoreProductInTheCartThanTheProductAvailableInStore_003 extends BaseClass {

	public HomePage hpObj;
	public ProceedToCheckOutPage pcopObj;
	
	@Test
	public void verifyingMoreProductCanNotAddToTheCartThanAvailableInStore() throws InterruptedException, IOException
	{
		   driver.get(propObj.getProperty("baseURL"));
		   hpObj=new HomePage(driver);
		   logger.info("*****************************Starting of VerifyYouCannotAddMoreProductInTheCartThanTheProductAvailableInStore_003******************************");
		   hpObj.clickOnMobileLink();
		   Thread.sleep(3000);
		   hpObj.clickOnAddToCartForSonyXperiaMobile("Sony Xperia");
		   Thread.sleep(3000);
		   pcopObj=new ProceedToCheckOutPage(driver);
		   
		   boolean errorMsgStatus=pcopObj.verifyingErrorMsgAfterClickingUpadateBtn("Some of the products cannot be ordered in requested quantity.");
		   if(errorMsgStatus==true)
		   {  
			   logger.info("*********************Error msg verification is successful********************");
			   Assert.assertTrue(true);
		   }
		   else
		   {   
			   logger.warn("***********************Error msg verification is not successful******************");
			   captureScreen(driver, "verifyingMoreProductCanNotAddToTheCartThanAvailableInStore");
		       Assert.assertTrue(false);
		   }
		   Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods="verifyingMoreProductCanNotAddToTheCartThanAvailableInStore")
	
	public void verifyingEmptyCartConfirmationMsg() throws InterruptedException, IOException
	{
		boolean emptyCartMsgStatus= pcopObj.verifyingEmptyCartMsg("SHOPPING CART IS EMPTY");
		if(emptyCartMsgStatus==true)
		{
		  logger.info("************************Empty cart confirmation msg is successful*******************");
		  Assert.assertTrue(true);
		}
		else
		{
		  logger.warn("***********************Empty cart confirmation msg is not successful********************");
		  captureScreen(driver, "verifyingEmptyCartConfirmationMsg");
		  Assert.assertEquals(emptyCartMsgStatus, true);
		  Thread.sleep(6000);
		}
		
		logger.info("********************************Ending of VerifyYouCannotAddMoreProductInTheCartThanTheProductAvailableInStore_003*****************************");
	}
}

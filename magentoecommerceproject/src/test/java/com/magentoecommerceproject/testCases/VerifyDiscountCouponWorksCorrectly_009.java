package com.magentoecommerceproject.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.magentoecommerceproject.pageObjects.HomePage;
import com.magentoecommerceproject.testBase.BaseClass;

public class VerifyDiscountCouponWorksCorrectly_009 extends BaseClass{
	
	public HomePage hpObj;

	@Test
	public void verifyingAppliedCouponConfirmationMsg() throws InterruptedException, IOException
	{
		driver.get(propObj.getProperty("baseURL"));
		hpObj=new HomePage(driver);
		logger.info("***************************Staring of VerifyDiscountCouponWorksCorrectly_009************************");
		hpObj.clickOnMobileLink();
		hpObj.clickOnAddToCartButtonForIphone("IPHONE");
		hpObj.setCouponCode("GURU50");
		hpObj.clickOnApplyBtn();
		Thread.sleep(3000);
		boolean msgStatus=hpObj.verifyingCouponAppliedConfirmationMsg("Coupon code \"GURU50\" was applied.");
		if(msgStatus==true)
		{
			logger.info("**************************Verifying MsgStatus is successful************************");
		    Assert.assertTrue(true);
		
		}
		else
		{
		    logger.warn("**************************Verifying MsgStatus is not successful************************");
		    captureScreen(driver,"verifyingAppliedCouponConfirmationMsg");
		    Assert.assertTrue(false);
		    Thread.sleep(2000);
		}
	}
	
	
	@Test
	public void verifyingTheGrandTotalAfterApplyingCoupon() throws InterruptedException, IOException
	{
		hpObj.gettingDiscountedPriceBy5PercentAfterApplyingCoupon(500.00);
		boolean couponWorkingStatus=hpObj.verifyingDiscountedPrice();
		if(couponWorkingStatus==true)
		{
		   logger.info("*********************Verifying couponWorkingStatus is successful*************************" );
		   Assert.assertTrue(true);
		
		}
		else
		{
		  logger.warn("*********************Verifying couponWorkingStatus is not successful*************************" );
		  captureScreen(driver, "verifyingTheGrandTotalAfterApplyingCoupon");
		  Assert.assertTrue(false);
		  Thread.sleep(7000);
		}
		
		logger.info("********************Ending of VerifyDiscountCouponWorksCorrectly_009************************");
	}

}

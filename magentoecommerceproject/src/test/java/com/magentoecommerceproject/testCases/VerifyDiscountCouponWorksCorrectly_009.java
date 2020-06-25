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
		logger.info("**************************Verifying MsgStatus is successful************************");
		captureScreen(driver,"verifyingAppliedCouponConfirmationMsg");
		Assert.assertEquals(msgStatus, true);
		Thread.sleep(2000);
	}
	
	
	@Test
	public void verifyingTheGrandTotalAfterApplyingCoupon() throws InterruptedException, IOException
	{
		hpObj.gettingDiscountedPriceBy5PercentAfterApplyingCoupon(500.00);
		boolean couponWorkingStatus=hpObj.verifyingDiscountedPrice();
		logger.info("*********************Verifying couponWorkingStatus is successful*************************" );
		captureScreen(driver, "verifyingTheGrandTotalAfterApplyingCoupon");
		Assert.assertEquals(couponWorkingStatus, true);
		Thread.sleep(7000);
		
		logger.info("********************Ending of VerifyDiscountCouponWorksCorrectly_009************************");
	}

}

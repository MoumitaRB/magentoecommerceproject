package com.magentoecommerceproject.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.magentoecommerceproject.pageObjects.HomePage;
import com.magentoecommerceproject.testBase.BaseClass;

public class VerifyDiscountCouponWorksCorrectly_009 extends BaseClass{
	
	public HomePage hpObj;

	@Test
	public void verifyingAppliedCouponConfirmationMsg() throws InterruptedException
	{
		driver.get(propObj.getProperty("baseURL"));
		hpObj=new HomePage(driver);
		hpObj.clickOnMobileLink();
		hpObj.clickOnAddToCartButtonForIphone("IPHONE");
		hpObj.setCouponCode("GURU50");
		hpObj.clickOnApplyBtn();
		Thread.sleep(3000);
		boolean msgStatus=hpObj.verifyingCouponAppliedConfirmationMsg("Coupon code \"GURU50\" was applied.");
		Assert.assertEquals(msgStatus, true);
		Thread.sleep(2000);
	}
	
	
	@Test
	public void verifyingTheGrandTotalAfterApplyingCoupon() throws InterruptedException
	{
		hpObj.gettingDiscountedPriceBy5PercentAfterApplyingCoupon(500.00);
		boolean couponWorkingStatus=hpObj.verifyingDiscountedPrice();
		Assert.assertEquals(couponWorkingStatus, true);
		Thread.sleep(7000);
	}

}

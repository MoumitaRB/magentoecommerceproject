package com.magentoecommerceproject.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.magentoecommerceproject.pageObjects.HomePage;
import com.magentoecommerceproject.testBase.BaseClass;

public class VerifyComparingTwoProducts_000 extends BaseClass {
	
	public HomePage hpObj;
	
	@Test
	public void verifyingCompareProductsInThePopUpWindow() throws InterruptedException, IOException
	{
		   driver.get(propObj.getProperty("baseURL"));
		   hpObj=new HomePage(driver);
		   
		   logger.info("****************Starting VerifyComparingTwoProducts_000***********************");
		   hpObj.clickOnMobileLink();
		   Thread.sleep(3000);
		   hpObj.clickOnAddToCompareBtnForSonyXperiaMobile("Sony Xperia");
		   Thread.sleep(2000);
		   hpObj.clickOnAddToCompareBtnForIphoneMobile("IPhone");
		   Thread.sleep(2000);
		   hpObj.getProductsNameAfterAddingToCompareList();
		   Thread.sleep(3000);
		   hpObj.clickOnCompareBtn();
		   Thread.sleep(3000);
		   hpObj.handlingWindows("Products Comparison List - Magento Commerce");
		   Thread.sleep(2000);
		   boolean b1= hpObj.verifyingPopUpWindowMsges("COMPARE PRODUCTS");
		   Thread.sleep(3000);
		   boolean b2= hpObj.verifyingHomepageTitle("Mobile");
		   Thread.sleep(3000);
		   if((b1==true)&&(b2==true))
		   {   
               logger.info("*********************Popup Window And HomePage Title Verification Are Successful*********************");
			   Assert.assertTrue(true);
		   }
		   else
		   {   
			   logger.warn("*********************Popup Window And HomePage Title Verification are not Successful*****************");
			   captureScreen(driver, "verifyingCompareProductsInThePopUpWindow");
			   Assert.assertTrue(false);
		   }
		   
	}

}

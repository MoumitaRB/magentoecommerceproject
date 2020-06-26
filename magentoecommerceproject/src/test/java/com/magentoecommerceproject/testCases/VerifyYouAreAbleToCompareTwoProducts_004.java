package com.magentoecommerceproject.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.magentoecommerceproject.pageObjects.HomePage;
import com.magentoecommerceproject.testBase.BaseClass;

public class VerifyYouAreAbleToCompareTwoProducts_004 extends BaseClass {
	public HomePage hpObj;
	
@Test
public void verifyingCompareProductsInThePopUpWindow() throws InterruptedException, IOException
{
	   driver.get(propObj.getProperty("baseURL"));
	   hpObj=new HomePage(driver);
	   
	   logger.info("***********************Starting of VerifyYouAreAbleToCompareTwoProducts_004************************");
	   hpObj.clickOnMobileLink();
	   Thread.sleep(3000);
	   hpObj.clickOnAddToCompareBtnForSonyXperiaMobile("Sony Xperia");
	   Thread.sleep(2000);
	   hpObj.clickOnAddToCompareBtnForIphoneMobile("IPhone");
	   Thread.sleep(2000);
	   hpObj.clickOnCompareBtn();
	   Thread.sleep(2000);
	   
	   boolean b1=hpObj.verifyingPopupWindowMsg("Products Comparison List - Magento Commerce","COMPARE PRODUCTS","SONY XPERIA","IPHONE");
	   Thread.sleep(4000);
	   
	  if((b1==true))
	  {   
		  logger.info("*************************Popup window msg verification is successful******************");
		  Assert.assertTrue(true);
	  }
	  else
	  {   
		  logger.warn("**************************Popup window msg verification is not successful****************");
		  captureScreen(driver, "verifyingCompareProductsInThePopUpWindow");
		  Assert.assertTrue(false);
	  }
	  
     logger.info("************************Ending of VerifyYouAreAbleToCompareTwoProducts_004***************************" );
 }
  
}

package com.magentoecommerceproject.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.magentoecommerceproject.pageObjects.HomePage;
import com.magentoecommerceproject.testBase.BaseClass;

public class VerifyYouAreAbleToCompareTwoProducts_004 extends BaseClass {
	public HomePage hpObj;
	
@Test
public void verifyingCompareProductsInThePopUpWindow() throws InterruptedException
{
	   driver.get(propObj.getProperty("baseURL"));
	   hpObj=new HomePage(driver);
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
		  Assert.assertTrue(true);
	  }
	  else
	  {
		  Assert.assertTrue(false);
	  }
   
 }
  
}

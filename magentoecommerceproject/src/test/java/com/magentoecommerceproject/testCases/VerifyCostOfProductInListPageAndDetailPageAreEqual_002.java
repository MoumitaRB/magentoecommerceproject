package com.magentoecommerceproject.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.magentoecommerceproject.pageObjects.DetailedProductPage;
import com.magentoecommerceproject.pageObjects.HomePage;
import com.magentoecommerceproject.testBase.BaseClass;

 public class VerifyCostOfProductInListPageAndDetailPageAreEqual_002 extends BaseClass{
    
   public HomePage hpObj;
   public DetailedProductPage dpObj;
   
   @Test
   public void verifyingProductValueInListAndDetaliedPage() throws InterruptedException
   {
	   driver.get(propObj.getProperty("baseURL"));
	   hpObj=new HomePage(driver);
	   hpObj.clickOnMobileLink();
	   Thread.sleep(3000);
	   double listPageCostStatus=hpObj.readTheCostOfTheProductFromMobileListPage1("Sony Xperia", 100.00);
	   Thread.sleep(4000);
	   
	   hpObj.clickOnSonyXperiaMobile();
	   Thread.sleep(4000);
	   
	   dpObj=new DetailedProductPage(driver);
	   double detailPageCostStatus=dpObj.readTheCostOfTheProductFromProductDetailedPage("SONY XPERIA", 100.00);
	   
	   if(listPageCostStatus==detailPageCostStatus)
	   {
		   Assert.assertTrue(true);
	   }
	   else
	   {
		   Assert.assertTrue(false);
	   }
	   
	   Thread.sleep(4000);
	  
	   
   }
   
}

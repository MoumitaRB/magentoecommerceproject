package com.magentoecommerceproject.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.magentoecommerceproject.pageObjects.DetailedProductPage;
import com.magentoecommerceproject.pageObjects.HomePage;
import com.magentoecommerceproject.testBase.BaseClass;

 public class VerifyCostOfProductInListPageAndDetailPageAreEqual_002 extends BaseClass{
    
   public HomePage hpObj;
   public DetailedProductPage dpObj;
   
   @Test
   public void verifyingProductValueInListAndDetaliedPage() throws InterruptedException, IOException
   {
	   driver.get(propObj.getProperty("baseURL"));
	   hpObj=new HomePage(driver);
	   logger.info("**********************Starting of VerifyCostOfProductInListPageAndDetailPageAreEqual_002***************************" );
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
		   logger.info("*****************************Cost of product in the list page and detailed page are equal**************************");
		   Assert.assertTrue(true);
	   }
	   else
	   {   
		   logger.warn("***********************Cost of product in the list page and detailed page are not equals**********************************");
		   captureScreen(driver, "verifyingProductValueInListAndDetaliedPage");
		   Assert.assertTrue(false);
	   }
	   
	   Thread.sleep(4000);
	  logger.info("***************************Ending of VerifyCostOfProductInListPageAndDetailPageAreEqual_002***************************" );
	   
   }
   
}

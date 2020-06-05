package com.magentoecommerceproject.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.magentoecommerceproject.pageObjects.HomePage;
import com.magentoecommerceproject.pageObjects.ProceedToCheckOutPage;
import com.magentoecommerceproject.testBase.BaseClass;

public class VerifyYouCannotAddMoreProductInTheCartThanTheProductAvailableInStore_003 extends BaseClass {

	public HomePage hpObj;
	public ProceedToCheckOutPage pcopObj;
	
	@Test
	public void verifyingMoreProductCanNotAddToTheCartThanAvailableInStore() throws InterruptedException
	{
		   driver.get(propObj.getProperty("baseURL"));
		   hpObj=new HomePage(driver);
		   hpObj.clickOnMobileLink();
		   Thread.sleep(3000);
		   hpObj.clickOnAddToCartForSonyXperiaMobile("Sony Xperia");
		   Thread.sleep(3000);
		   pcopObj=new ProceedToCheckOutPage(driver);
		   
		   boolean errorMsgStatus=pcopObj.verifyingErrorMsgAfterClickingUpadateBtn("Some of the products cannot be ordered in requested quantity.");
		   if(errorMsgStatus==true)
		   {
			   Assert.assertTrue(true);
		   }
		   else
		   {
			   Assert.assertTrue(false);
		   }
		   Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods="verifyingMoreProductCanNotAddToTheCartThanAvailableInStore")
	
	public void verifyingEmptyCartConfirmationMsg() throws InterruptedException
	{
		boolean emptyCartMsgStatus= pcopObj.verifyingEmptyCartMsg("SHOPPING CART IS EMPTY");
		Assert.assertEquals(emptyCartMsgStatus, true);
		Thread.sleep(6000);
	}
}

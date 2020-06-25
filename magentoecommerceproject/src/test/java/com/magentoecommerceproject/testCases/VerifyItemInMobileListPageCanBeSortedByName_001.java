package com.magentoecommerceproject.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.magentoecommerceproject.pageObjects.HomePage;
import com.magentoecommerceproject.testBase.BaseClass;



public class VerifyItemInMobileListPageCanBeSortedByName_001 extends BaseClass{
	
	public HomePage hpObj;
	
	@Test
	public void verifyingHomePageTitleTest() throws IOException
	{   
		driver.get(propObj.getProperty("baseURL"));
		hpObj=new HomePage(driver);
		logger.info("**********************Starting VerifyItemInMobileListPageCanBeSortedByName_001*********************");
		
		boolean titleResult=hpObj.verifyingTitleOfTheHomePage("Home page");
		boolean textTitleResult=hpObj.verifyingTextTitleOfTheHomePage("THIS IS DEMO SITE FOR");
		{
			if((titleResult==true)&&(textTitleResult==true))
			{   
				logger.info("**********************Title of HomePage and Text Title of the HomePage Verification are successful*****************");
				Assert.assertTrue(true);
			}
			else
			{   
				logger.warn("******************Title of homepage and text title of the home page verification are not successful*********************" );
				captureScreen(driver, "verifyingHomePageTitleTest");
				Assert.assertTrue(false);
			}
		}
	
	}
	
	@Test(dependsOnMethods="verifyingHomePageTitleTest")
	public void verifyingMobilePageTitleTest() throws InterruptedException, IOException
	{  
		hpObj.clickOnMobileLink();
		Thread.sleep(3000);
		boolean mpTitleStatus=hpObj.verifyingMobilePageTitle("Mobile");
		if(mpTitleStatus==true)
		{    
			logger.info("****************************Mobile page title verification is successful********************");
			Assert.assertTrue(true);
		}
		else
		{   
			logger.warn("***************************Mobile page title verification is not successful**********************");
			captureScreen(driver,"verifyingMobilePageTitleTest");
			Assert.assertTrue(false);
		}
		
	}
	
	@Test(dependsOnMethods="verifyingMobilePageTitleTest")
	public void verifyingAll3ProductsAvailableUnderNameDropDown() throws InterruptedException, IOException
	{
		hpObj.selectOptionFromDropDownBtn();
		boolean totalNumberOfProduct=hpObj.verifyingAll3ProductsUnderNameDropdown("IPhone", "Samsung Galaxy", "Sony Xperia",3);
		if(totalNumberOfProduct==true)
		{   
			logger.info("**********************All three products are available under dropdown***************************");
			Assert.assertTrue(true);
		}
		else
		{   
			logger.info("**********************All three products are not available under dropdown***********************");
			captureScreen(driver,"verifyingAll3ProductsAvailableUnderNameDropDown");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods="verifyingAll3ProductsAvailableUnderNameDropDown")
	public void verifyingAll3ProductsSortedByNameTest() throws IOException
	{
		boolean sortedStatus=hpObj.verifyingAll3ProductsSortedByName();
		if(sortedStatus==true)
		{   logger.info("**********************All three products are sorted by name*********************");
			Assert.assertTrue(true);
		}
		else
			
		{   
			logger.warn("**********************All three products are not sorted by name**********************");
			captureScreen(driver,"verifyingAll3ProductsSortedByNameTest");
			Assert.assertTrue(false);
		}
		
		logger.info("*********************Ending of VerifyItemInMobileListPageCanBeSortedByName_001***********************");
	}
	
	
}

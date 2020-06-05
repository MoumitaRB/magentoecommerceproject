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
		boolean titleResult=hpObj.verifyingTitleOfTheHomePage("Home page");
		boolean textTitleResult=hpObj.verifyingTextTitleOfTheHomePage("THIS IS DEMO SITE FOR");
		{
			if((titleResult==true)&&(textTitleResult==true))
			{
				Assert.assertTrue(true);
			}
			else
			{   
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
			Assert.assertTrue(true);
		}
		else
		{   
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
			Assert.assertTrue(true);
		}
		else
		{   
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
		{
			Assert.assertTrue(true);
		}
		else
		{   captureScreen(driver,"verifyingAll3ProductsSortedByNameTest");
			Assert.assertTrue(false);
		}
	}
	
}

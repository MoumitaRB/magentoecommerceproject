package com.magentoecommerceproject.testCases;

import org.testng.annotations.Test;

import com.magentoecommerceproject.pageObjects.AdvancedSearchPage;
import com.magentoecommerceproject.pageObjects.HomePage;
import com.magentoecommerceproject.testBase.BaseClass;

public class VerifySearchFunctionality_014 extends BaseClass{
	
	public HomePage hpObj;
	public AdvancedSearchPage aspObj;
	
	@Test
	public void productNameAndPriceBetween0_150AreDisplayedInTheConsole() throws InterruptedException
	{
		driver.get(propObj.getProperty("baseURL"));
	    Thread.sleep(4000);
	    hpObj=new HomePage(driver);
	    hpObj.clickOnAdvancedSearchLink();
	    aspObj=new AdvancedSearchPage(driver);
	    aspObj.setPriceFrom("0");
	    aspObj.setPriceTo("150");
	    aspObj.clickOnSearchBtn();
	    Thread.sleep(3000);
	    aspObj.gettingTheProductNameAndPriceMethod2("SONY XPERIA", "SAMSUNG GALAXY","","100.00","",100.00, 130.00, 0.0);
	    Thread.sleep(8000);
	    aspObj.clickOnCatalogAdvancedSearchLink();
	    Thread.sleep(3000);
	    aspObj.setPriceFrom("151");
	    aspObj.setPriceTo("1000");
	    aspObj.clickOnSearchBtn();
	    Thread.sleep(3000);
	    aspObj.gettingTheProductNameAndPriceMethod2("IPHONE", "LG LCD", "SAMSUNG LCD", "500.00", "700.00", 500.00, 615.00, 700.00);
	    Thread.sleep(7000);
	    
	    
	}
	
}

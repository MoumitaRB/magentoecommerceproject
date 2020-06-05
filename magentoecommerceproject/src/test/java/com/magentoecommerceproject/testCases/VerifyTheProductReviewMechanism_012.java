package com.magentoecommerceproject.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.magentoecommerceproject.pageObjects.AdminHomePage;
import com.magentoecommerceproject.pageObjects.AdminLoginPage;
import com.magentoecommerceproject.pageObjects.DetailedProductPage;
import com.magentoecommerceproject.pageObjects.HomePage;
import com.magentoecommerceproject.pageObjects.ReviewPage;
import com.magentoecommerceproject.testBase.BaseClass;

public class VerifyTheProductReviewMechanism_012 extends BaseClass{
	
	public ReviewPage rpObj;
	public AdminLoginPage alpObj;
	public AdminHomePage ahpObj;
	public HomePage hpObj;
	public DetailedProductPage dpObj;
	
	@Test
	public void verifyingReviewIsApproved() throws InterruptedException
	{
		
		driver.get(" http://live.demoguru99.com/index.php/review/product/list/id/1/");
		rpObj=new ReviewPage(driver);
		rpObj.setLetUsKnowYourThoughts("One of the best mobiles so far with lots of festures.");
		rpObj.setSummaryOfYourReview("Picture quality is good.");
		rpObj.setNickName("New Tester");
		rpObj.clickOnSubmitReviewBtn();
		boolean msgStatus=rpObj.verifyingConfirmationMsg("Your review has been accepted for moderation.");
		Assert.assertEquals(msgStatus, true);
		Thread.sleep(3000);
		driver.get(propObj.getProperty("baseURL2"));
		Thread.sleep(3000);
		alpObj=new AdminLoginPage(driver);
		alpObj.setUserName("user01");
		alpObj.setPassword("guru99com");
		alpObj.clickOnLoginBtn();
		Thread.sleep(3000);
		ahpObj=new AdminHomePage(driver);
		ahpObj.clickOnCloseBtn();
		ahpObj.clickOnPendingReviewTabUnderCatalogTab();
		Thread.sleep(3000);
		ahpObj.clickOnEditLinkAfterSortingTableById();
		Thread.sleep(5000);
		ahpObj.selectOptionsFromStatus2DropDown("Approved");
		Thread.sleep(2000);
	    ahpObj.clickonSaveBtn();
	    Thread.sleep(3000);
	    driver.get(propObj.getProperty("baseURL"));
	    Thread.sleep(4000);
	    hpObj=new HomePage(driver);
	    hpObj.clickOnMobileLink();
	    Thread.sleep(3000);
	    hpObj.clickOnSonyXperiaMobile();
	    Thread.sleep(2000);
		dpObj=new DetailedProductPage(driver);
		dpObj.clickOnReviewBtn();
		Thread.sleep(3000);
		boolean b1=dpObj.verifyingReviewComment("One of the best mobiles so far with lots of festures. REVIEW BY NEW TESTER");
		Thread.sleep(5000);
		Assert.assertEquals(b1, true);
		
	}


}

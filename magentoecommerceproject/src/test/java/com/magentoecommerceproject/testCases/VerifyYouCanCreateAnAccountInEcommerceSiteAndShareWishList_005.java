package com.magentoecommerceproject.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.magentoecommerceproject.pageObjects.HomePage;
import com.magentoecommerceproject.pageObjects.LoginPage;
import com.magentoecommerceproject.testBase.BaseClass;

public class VerifyYouCanCreateAnAccountInEcommerceSiteAndShareWishList_005 extends BaseClass{
	
	public HomePage hpObj;
	public LoginPage lpObj;
	
	@Test
	public void verifyingAccountRegistrationDone() throws InterruptedException
	{
		driver.get(propObj.getProperty("baseURL"));
		hpObj=new HomePage(driver);
		hpObj.clickOnMyAccountLink();
		lpObj=new LoginPage(driver);
		lpObj.clickOnCreateAccountLink();
		Thread.sleep(2000);
		String email=randomString()+"@gamil.com";
		lpObj.setEmailId(email);
		Thread.sleep(2000);
		lpObj.fillingRegistrationForm("Amir","Khan","amir1000", "amir1000");
		Thread.sleep(3000);
		lpObj.clickOnRegistrationBtn();
		boolean registrationStatus=lpObj.verifyingRegistrationisDone("Thank you for registering with Main Website Store.");
		Thread.sleep(3000);
		lpObj.clickOnTVLink();
		Thread.sleep(2000);
		lpObj.clickOnAddToWishList("LG LCD");
		Thread.sleep(2000);
		lpObj.clickOnShareWishWishListBtn();
		Thread.sleep(2000);
		lpObj.setEmilIdAndMsg("mou123@gmail.com", "Sharing my Wish list...");
		Thread.sleep(2000);
		lpObj.clickOnShareWishListBtn2();
		Thread.sleep(2000);
		boolean sharedWishListStatus=lpObj.verifyingSharingWishListConfirmationMsg("Your Wishlist has been shared.");
		if((registrationStatus==true)&&(sharedWishListStatus==true))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);

	}
	
	

}

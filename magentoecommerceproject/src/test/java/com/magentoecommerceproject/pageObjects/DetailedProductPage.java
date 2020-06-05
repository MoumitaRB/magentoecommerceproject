package com.magentoecommerceproject.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailedProductPage {
	
	public WebDriver driver;
	public JavascriptExecutor js;
	
	public DetailedProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
   
	//locators
	
	@FindBy(xpath="//span[@class='h1']")
	@CacheLookup
	WebElement sXProductName;
	
	@FindBy(xpath="//span[@class='price']")
	@CacheLookup
	WebElement sXproductCost;
	
	@FindBy(xpath="//li[@class='last']//span[contains(text(),'Reviews')]")
	@CacheLookup
	WebElement reviewBtn;
	

	
	//actions
	
	public double readTheCostOfTheProductFromProductDetailedPage(String exp_productName, double exp_productCost)
	{
		 double detailedPageCost=0.0;
			String act_productName=sXProductName.getText();
			System.out.println(act_productName);
			if(act_productName.equals(exp_productName))
			{
				String cost=sXproductCost.getText();
				String productCost=cost.replaceAll("[^0-9.]", "");
				System.out.println(productCost);
				double act_productCost=Double.parseDouble(productCost);
				if(act_productCost==exp_productCost)
				{
					detailedPageCost=detailedPageCost+act_productCost;
				}
				
			}
		return detailedPageCost;
	}
	
	public void clickOnReviewBtn()
	{   
		js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",reviewBtn);
		reviewBtn.click();
	}
	
	public boolean verifyingReviewComment(String exp_review)
	{   boolean flag=false;
		List<WebElement>reviewList=driver.findElements(By.xpath("//dd[@class='tab-container last current']//dd"));
		for(WebElement review:reviewList)
		{
			String act_rew=review.getText();
			//String act_review=rew.replaceAll("[^A-Za-z]", "");
			System.out.println("Review: "+act_rew);
			if(act_rew.contains(exp_review))
			{
				flag=true;
				break;
			}
			else
			{
				flag=false;
			}
		}
		return flag;
	}
}

package com.magentoecommerceproject.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewPage {
	
	public WebDriver driver;
	public JavascriptExecutor js;
	
	public ReviewPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//locators
	
	@FindBy(xpath="//textarea[@id='review_field']")
	@CacheLookup
	WebElement txtThoughts;
	
	@FindBy(xpath="//input[@id='summary_field']")
	@CacheLookup
	WebElement txtSummary;
	
	@FindBy(xpath="//input[@id='nickname_field']")
	@CacheLookup
	WebElement txtnickName;
	
	@FindBy(xpath="//div[@class='buttons-set']//button[@class='button']")
	@CacheLookup
	WebElement submitReviewBtn;
	
	@FindBy(xpath="//li[@class='success-msg']//ul//li")
	@CacheLookup
	WebElement crfMsg;
	
	
	//actions
	
	public void setLetUsKnowYourThoughts(String exp_text)
	{
		txtThoughts.clear();
		txtThoughts.sendKeys(exp_text);
	}
	
	public void setSummaryOfYourReview(String exp_review)
	{
		txtSummary.clear();
		txtSummary.sendKeys(exp_review);
	}
	
	public void setNickName(String name)
	{
		txtnickName.clear();
		txtnickName.sendKeys(name);
	}
	
	public void clickOnSubmitReviewBtn()
	{
		submitReviewBtn.click();
	}

	public boolean verifyingConfirmationMsg(String exp_text)
	{ 
	  boolean flag=false;
	  try {
		js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",crfMsg);
		String act_text=crfMsg.getText();
		System.out.println("Confirmation msg after submitting reviews:"+act_text);
		if(act_text.equals(exp_text))
		{
			flag= true;
		}
		else
		{
			flag= false;
		}
	  }catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  return flag;
	}
}

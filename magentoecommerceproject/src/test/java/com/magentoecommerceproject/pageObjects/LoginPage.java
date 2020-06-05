package com.magentoecommerceproject.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
  public WebDriver driver;
  public JavascriptExecutor js;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	//locators
	
	@FindBy(xpath="//span[contains(text(),'Create an Account')]")
	@CacheLookup
	WebElement createAccountLink;
	
	@FindBy(xpath="//input[@id='firstname']")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='lastname']")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='email_address']")
	@CacheLookup
	WebElement txtEmailId;
	
	@FindBy(xpath="//input[@id='password']")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='confirmation']")
	@CacheLookup
	WebElement txtCfmPassword;
	
	@FindBy(xpath="//div[@class='buttons-set']//button[@class='button']")
	@CacheLookup
	WebElement registrationBtn;
	
	@FindBy(xpath="//li[@class='success-msg']//ul//li")
	@CacheLookup
	WebElement crfMsg;
	
	@FindBy(xpath="//li//a[contains(text(),'TV')]")
	@CacheLookup
	WebElement tvLink;
	
	@FindBy(xpath="//a[contains(text(),'LG LCD')]")
	@CacheLookup
	WebElement productName;
	
	@FindBy(xpath="//li[1]//div[1]//div[3]//ul[1]//li[1]//a[1]")
	@CacheLookup
	WebElement addToWIshListBtn;
	
	@FindBy(xpath="//button[@name='save_and_share']")
	@CacheLookup
	WebElement shareWishListBtn;
	
	@FindBy(xpath="//textarea[@id='email_address']")
	@CacheLookup
	WebElement txtEmailArea;
	
	@FindBy(xpath="//textarea[@id='message']")
	@CacheLookup
	WebElement txtMsgArea;
	
	@FindBy(xpath="//button[@id='send2']")
	@CacheLookup
	WebElement loginBtn;
	
	
//	@FindBy(xpath="//div[@class='buttons-set form-buttons']//button[@class='button']")
//	@CacheLookup
//	WebElement shareWishListBtn2;
//	
//	@FindBy(xpath="//li[@class='success-msg']//ul//li")
//	@CacheLookup
//	WebElement wishListCrfMsg;
	
	
	@FindBy(xpath="//input[@id='email']")
	@CacheLookup
	WebElement txtRegisteredEmailId;
	
	@FindBy(xpath="//input[@id='pass']")
	@CacheLookup
	WebElement txtRegisteredPwd;
	
	//actions
	public void clickOnCreateAccountLink()
	
	{   
	    js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",createAccountLink);
		createAccountLink.click();
	}
	
	public void setEmailId(String email)
	{
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",txtEmailId);
		txtEmailId.clear();
		txtEmailId.sendKeys(email);
		
	}
	
	public void fillingRegistrationForm(String fname, String lname, String pwd, String pwd2)
	{
		js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",txtFirstName);
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
		js.executeScript("arguments[0].scrollIntoView();",txtLastName);
		txtLastName.clear();
		txtLastName.sendKeys(lname);
		js.executeScript("arguments[0].scrollIntoView();",txtPassword);
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
		js.executeScript("arguments[0].scrollIntoView();",txtCfmPassword);
		txtCfmPassword.clear();
		txtCfmPassword.sendKeys(pwd2);
	
	}
	
	public void clickOnRegistrationBtn()
	{
		registrationBtn.click();
	}
	
	public boolean verifyingRegistrationisDone(String exp_text)
	{
		String act_text=crfMsg.getText();
		System.out.println(act_text);
		if(act_text.equals(exp_text))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void clickOnTVLink()
	{
		tvLink.click();
	}
	
	public void clickOnAddToWishList(String exp_name)
	{
		String act_name=productName.getText();
		System.out.println(act_name);
		if(act_name.equals(exp_name))
		{
			addToWIshListBtn.click();
		}
	}
	
	public void clickOnShareWishWishListBtn()
	{
		shareWishListBtn.click();
	}
	
	public void setEmilIdAndMsg(String email, String msg)
	{
		txtEmailArea.clear();
		txtEmailArea.sendKeys(email);
		txtMsgArea.clear();
		txtMsgArea.sendKeys(msg);
	}
	
	public void clickOnShareWishListBtn2()
	{
		driver.findElement(By.xpath("//div[@class='buttons-set form-buttons']//button[@class='button']")).click();
	}
	
	public boolean verifyingSharingWishListConfirmationMsg(String exp_text)
	{
		String act_text=driver.findElement(By.xpath("//li[@class='success-msg']//ul//li")).getText();
		System.out.println(act_text);
		if(act_text.equals(exp_text))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void setRegisteredEmailId(String email)
	{
		txtRegisteredEmailId.clear();
		txtRegisteredEmailId.sendKeys(email);
	}
	
	public void setRegisteredPassword(String pwd)
	{
		txtRegisteredPwd.clear();
		txtRegisteredPwd.sendKeys(pwd);
	}
	
	public void clickOnLoginBtn()
	{
		loginBtn.click();
	}
}

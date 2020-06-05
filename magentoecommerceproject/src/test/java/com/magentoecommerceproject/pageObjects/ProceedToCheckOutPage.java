package com.magentoecommerceproject.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProceedToCheckOutPage {
	
	public WebDriver driver;
	
	
  public ProceedToCheckOutPage(WebDriver driver)
  {
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
  }
  
  //locators
  
  @FindBy(xpath="//tbody//tr//td[@class='product-cart-actions']//input[@title='Qty']")
  @CacheLookup
  WebElement txtQty;
  
  @FindBy(xpath="//td[@class='product-cart-actions']//button[@name='update_cart_action']")
  @CacheLookup
  WebElement updateBtn;
  
  @FindBy(xpath="//li[@class='error-msg']//ul//li")
  @CacheLookup
  WebElement errorMsg;
  
  @FindBy(xpath="//table[@id='shopping-cart-table']//tfoot//tr//td//button[@id='empty_cart_button']")
  @CacheLookup
  WebElement emptyCartBtn;
  
  @FindBy(xpath="//div[@class='page-title']//h1")
  @CacheLookup
  WebElement emptyCartCfmMsg;
  
  
  //actions
  
  public boolean verifyingErrorMsgAfterClickingUpadateBtn(String exp_errorMsg) throws InterruptedException
  {   
	  txtQty.click();
	  txtQty.clear();
	  txtQty.sendKeys("1000");
	  Thread.sleep(3000);
	  updateBtn.click();
	  String act_errorMsg=errorMsg.getText();
	  System.out.println(act_errorMsg);
	  if(act_errorMsg.equals(exp_errorMsg))
	  {
		  return true;
	  }
	  
	  else
	  {
		  return false;
	  }
	 
  }
  
  public boolean verifyingEmptyCartMsg(String exp_msg) throws InterruptedException
  {
	  JavascriptExecutor js= (JavascriptExecutor)driver;
	  js.executeScript("arguments[0].scrollIntoView();",emptyCartBtn );
	  emptyCartBtn.click();
	  Thread.sleep(3000);
	  
	  String act_msg=emptyCartCfmMsg.getText();
	  System.out.println(act_msg);
	  if(act_msg.equals(exp_msg))
	  {
		  return true;
	  }
	  else
	  {
		  return false;
	  }
	  
  }
  
}

package com.magentoecommerceproject.pageObjects;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DashBoardPage {
	
public WebDriver driver;
public JavascriptExecutor js;
public double act_total=0.00;
public String act_orderNo="";
public String parentWindowId="";
public String childWindowId1=null;
public String childWindowId2=null;
public String act_ReorderNo="";
	
	public DashBoardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	//locators

	@FindBy(xpath="//li[@class='current']")
	@CacheLookup
	WebElement wishListBtn;
	
	@FindBy(xpath="//div[@class='cart-cell']//button[@class='button btn-cart']")
	@CacheLookup
	WebElement addToCartBtn;
	
	@FindBy(xpath="//li[@class='method-checkout-cart-methods-onepage-bottom']//button[@class='button btn-proceed-checkout btn-checkout']")
	@CacheLookup
	WebElement proceedToCheckoutBtn;
	
	@FindBy(xpath="//select[@id='billing-address-select']")
	@CacheLookup
	WebElement dropDownBtn;
	
	@FindBy(xpath="//input[@id='billing:firstname']")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='billing:lastname']")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='billing:street1']")
	@CacheLookup
	WebElement txtAdd1;
	
	@FindBy(xpath="//input[@id='billing:street2']")
	@CacheLookup
	WebElement txtAdd2;
	
	@FindBy(xpath="//input[@id='billing:city']")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(id="billing:region_id")
	@CacheLookup
	WebElement stateDropdownBtn;
	
	@FindBy(xpath="//input[@id='billing:postcode']")
	@CacheLookup
	WebElement txtZip;
	
	@FindBy(id="billing:country_id")
	@CacheLookup
	WebElement countryDropDownBtn;
	
	@FindBy(name="billing[telephone]")
	@CacheLookup
	WebElement txtPhNo;
	
	@FindBy(xpath="//div[@id='billing-buttons-container']//button[@class='button']")
	@CacheLookup
	WebElement continueBtn;
	
	@FindBy(xpath="//dt[contains(text(),'Flat Rate')]")
	@CacheLookup
	WebElement flatRateText;
	
	@FindBy(xpath="//label[@for='s_method_flatrate_flatrate']//span")
	@CacheLookup
	WebElement flatRate;
	
	@FindBy(xpath="//div[@id='shipping-method-buttons-container']//button[@class='button']")
	@CacheLookup
	WebElement continueBtn2;
	
	@FindBy(xpath="//input[@id='p_method_checkmo']")
	@CacheLookup
	WebElement radioBtn;
	
	@FindBy(xpath="//div[@id='payment-buttons-container']//button[@class='button']")
	@CacheLookup
	WebElement continueBtn3;
	
	@FindBy(xpath="//button[@class='button btn-checkout']")
	@CacheLookup
	WebElement placeOrderBtn;
	
	@FindBy(xpath="//h1[contains(text(),'Your order has been received.')]")
	@CacheLookup
	WebElement orderCrfMsg;
	
	@FindBy(xpath="//div[@class='col-main']//p//a[1]")
	@CacheLookup
	WebElement orderId;
	
	@FindBy(xpath="//li//a[contains(text(),'My Orders')]")
	@CacheLookup
	WebElement myOrderLink;
	
	//@FindBy(xpath="//tr[@class='first odd']//a[contains(text(),'View Order')]") 
	@FindBy(xpath="//tr[1]//td[6]//span[1]//a[1]")
	@CacheLookup
	WebElement viewOrderBtn;
	
	@FindBy(xpath="//a[@class='link-print']")
	@CacheLookup
	WebElement printOrderBtn;
	
	@FindBy(xpath="//input[@title='Qty']")
	@CacheLookup
	WebElement txtQty;
	
	@FindBy(xpath="//td[@class='product-cart-actions']//button[@name='update_cart_action']")
	@CacheLookup
	WebElement updateBtn;
	
	@FindBy(xpath="//table[@id='shopping-cart-totals-table']//tfoot//tr//td[1]")
	@CacheLookup
	WebElement grandTotalText;
	
	@FindBy(xpath="//table[@id='shopping-cart-totals-table']//tfoot//tr//td[2]")
	@CacheLookup
	WebElement grandTotal;
	
	//actions
	
	public void clickOnWishListlink()
	{   
	    js= (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView();",wishListBtn);
		wishListBtn.click();
	}
	
	public void ClickOnAddToCartButton()
	{
		addToCartBtn.click();
	}
	
	public void clickOnProceedToCheckOutBtn()
	{
		proceedToCheckoutBtn.click();
	}
	
	public void clickOnDropDownBtn(String exp_option)
	{
		js= (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView();",dropDownBtn);
	    dropDownBtn.click();
	    Select selectdd=new Select(dropDownBtn);
	    selectdd.selectByVisibleText(exp_option);
	}
	
	public void fillingBillingAddressForm(String fname, String lname, String add1, String add2, String city, String state, String pin, String country, String ph) throws InterruptedException
	{
		js= (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView();",txtFirstName);
	    txtFirstName.clear();
	    txtFirstName.sendKeys(fname);
	    js.executeScript("arguments[0].scrollIntoView();",txtLastName);
	    txtLastName.clear();
	    txtLastName.sendKeys(lname);
	    js.executeScript("arguments[0].scrollIntoView();",txtAdd1);
	    txtAdd1.clear();
	    txtAdd1.sendKeys(add1);
	    js.executeScript("arguments[0].scrollIntoView();",txtAdd2);
	    txtAdd2.clear();
	    txtAdd2.sendKeys(add2);
	    js.executeScript("arguments[0].scrollIntoView();",txtcity);
	    txtcity.clear();
	    txtcity.sendKeys(city);
	    js.executeScript("arguments[0].scrollIntoView();",stateDropdownBtn);
	    stateDropdownBtn.click();
	    Select statedd=new Select(stateDropdownBtn);
	    statedd.selectByVisibleText(state);
	    Thread.sleep(3000);
	    js.executeScript("arguments[0].scrollIntoView();",txtZip);
	    txtZip.clear();
	    txtZip.sendKeys(pin);
	    js.executeScript("arguments[0].scrollIntoView();",countryDropDownBtn);
	    countryDropDownBtn.click();
	    Select countrydd=new Select(countryDropDownBtn);
	    countrydd.selectByVisibleText(country);
	    Thread.sleep(3000);
	    js.executeScript("arguments[0].scrollIntoView();",txtPhNo);
	    txtPhNo.clear();
	    txtPhNo.sendKeys(ph);
	        
	}
	
	public void ClickOnContinueBtn()
	{
		continueBtn.click();
	}
	
	public boolean verifyingFlatRateShippingIsGenarated(String exp_text, double exp_rate)
	{   
		boolean flag=true;
		js= (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView();",flatRateText);
		String act_text=flatRateText.getText();
		System.out.println(act_text);
		if(act_text.equals(exp_text))
		{   
		    js.executeScript("arguments[0].scrollIntoView();",flatRate);
			String rate=flatRate.getText();
			System.out.println(act_text);
			String act_rate=rate.replaceAll("[^0-9.]", "");
			System.out.println(act_rate);
			double doubleRate=Double.parseDouble(act_rate);
			if(doubleRate==exp_rate)
			{
				flag=true;
			}
			else
			{
				flag=false;
			}
			
		}
		
		return flag;
	}
	
	public void clickOnContinueBtn2()
	{
		continueBtn2.click();
	}
	
	public void clickOnRadioBtnForCashPayment()
	{
		radioBtn.click();
	}
	
	public void clickOnContinueBtn3()
	{
		continueBtn3.click();
	}
	public void gettingTheTotalAfterAddingShippingCost(double exp_subTotal, double exp_tax)
	{  
		List<WebElement>rownum=driver.findElements(By.xpath("//table//tfoot//tr"));
		for(int r=1; r<=rownum.size(); r++)
		{
		   String subTotal= driver.findElement(By.xpath("//table//tfoot//tr["+r+"]//td[2]")).getText();
		   String act_subtotal=subTotal.replaceAll("[^0-9.]", "");
		   System.out.println(act_subtotal);
		   double double_subTotal=Double.parseDouble(act_subtotal);
		   act_total=act_total+double_subTotal;
		   System.out.println(act_total);
		   if(double_subTotal==exp_subTotal)
		   {
			   String tax=driver.findElement(By.xpath("//table//tfoot//tr["+(r+1)+"]//td[2]")).getText();
			   String act_tax=tax.replaceAll("[^0-9.]", "");
			   System.out.println(act_tax);
			   double double_actTax=Double.parseDouble(act_tax);
			   if(double_actTax==exp_tax)
			   {
				   act_total=act_total+double_actTax;
				   System.out.println(act_total);
				   break;
			   }
		   }
		   
		}
		
	}
	
	public boolean verifyingTheTotalProductCostAfterAddingShippingCost()
	{
		String total=driver.findElement(By.xpath("//table//tfoot//tr[3]//td[2]")).getText();
		System.out.println(total);
		String grandTotal=total.replaceAll("[^0-9.]", "");
		double act_grandTotal=Double.parseDouble(grandTotal);
		System.out.println(act_grandTotal);
		if(act_grandTotal==act_total)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public void clickOnPlaceAnOrderBtn()
	{
		placeOrderBtn.click();
	}
	
	public boolean verifyingOrderIsPlacedAndOrderNumberGenerated(String exp_msg)
	{  
		boolean flag=false;
		String act_msg=orderCrfMsg.getText();
		System.out.println(act_msg);
		if(act_msg.equals(exp_msg))
		{
			 act_orderNo=act_orderNo.concat(orderId.getText());
			 System.out.println(act_orderNo);
		     boolean b1=!act_orderNo.isEmpty();
		     if(b1==true)
		     {
		    	 flag=true;
		     }
		     else
		     {
		    	 flag=false;
		     }
		}
		return flag;
	}
	
	public void clickOnMyOrderLink()
	{   
		js= (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView();",myOrderLink);
		myOrderLink.click();
	}
	
	public boolean verifyingPrevioulyCreatedOrderIsDisplayedInRecentOrdersTable(String exp_orderNo, String exp_status)
	{  
		boolean flag=false;
		List<WebElement>rownum=driver.findElements(By.xpath("//table[@id='my-orders-table']//tbody//tr"));
		for(int r=1; r<=rownum.size(); r++)
		{
			String orderNo=driver.findElement(By.xpath("//table[@id='my-orders-table']//tbody//tr["+r+"]//td[1]")).getText();
			System.out.println(orderNo);
			if(orderNo.equals(act_orderNo))
			{
				String act_status=driver.findElement(By.xpath("//table[@id='my-orders-table']//tbody//tr["+r+"]//td[5]")).getText();
				System.out.println(act_status);
				if(act_status.equals(exp_status))
				{
					flag=true;
				    break;
				}
				else
				{
					flag=false;
				}
			}
			if(flag=true)
			{
				break;
			}
		}
		
		return flag;
	}
	
	
	public void clickOnViewOrderBtn()
	{
		viewOrderBtn.click();
	}
	
	public void clickOnPrintOrderBtn()
	{
		printOrderBtn.click();
	}
	
	public void handlingWindows(String exp_title, String exp_title2)
	{
		Set<String>windowId=driver.getWindowHandles();
		System.out.println(windowId.size());
		for(String id:windowId)
		{
			String act_title=driver.switchTo().window(id).getTitle();
			System.out.println(act_title);
			if(act_title.equals(exp_title)&&(childWindowId1==null))
			{   
				childWindowId1=id;
				System.out.println("child1 window id:"+childWindowId1);
				System.out.println(driver.getTitle());
				//driver.close();
			}
			else if(act_title.equals(exp_title2))
			{
				parentWindowId=id;
				System.out.println("parent window id: "+parentWindowId);
			}
			
			else
			{
				childWindowId2=id;
				System.out.println("child2 window id:"+childWindowId2);
				
		    }
		}
		
	}
	
	public void switchToChildWindowId2()
	{
		driver.switchTo().window(childWindowId2);
		System.out.println(driver.getWindowHandle());
		driver.manage().window().maximize();
		
	}
	
	public void selectPDFOption()
	{
		WebElement destination=driver.findElement(By.xpath("//div[@id='container']//print-preview-destination-settings[@id='destinationSettings']//#shadow-root//print-preview-settings-section//div//"
				+ "print-preview-destination-select[@id='destinationSelect']//shadow-root//select[@class='md-select']"));
	    js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", destination);
		//destination.click();
		Select destinationdd=new Select (destination);
		destinationdd.selectByValue("Save as PDF/local/");
		
	}
	
	public void clickOnSaveButton()
	{
		driver.findElement(By.xpath("//cr-button[@class='action-button']")).click();
	}
	
	public void clickOnReorderLinkInRecentOrder(String exp_orderNo)
	{
		List<WebElement>rownum=driver.findElements(By.xpath("//table[@id='my-orders-table']//tbody//tr"));
		for(int r=1; r<=rownum.size(); r++)
		{
			String orderNo=driver.findElement(By.xpath("//table[@id='my-orders-table']//tbody//tr["+r+"]//td[1]")).getText();
			System.out.println(orderNo);
			if(orderNo.equals(exp_orderNo))
			{
				driver.findElement(By.xpath("//table[@id='my-orders-table']//tbody//tr[1]//td[6]//a[2]")).click();
				break;
			}
	    }
 
	 }
	
	public void changeTheQuantityAndClickOnUpdateBtn(String exp_qty)
	{
		txtQty.click();
		txtQty.clear();
		txtQty.sendKeys(exp_qty);
		updateBtn.click();
		
	}
	
	public boolean verifyTheGrandTotalIsChanged(String exp_text, double exp_grandTotal)
	{
		boolean flag=false;
		String act_text=grandTotalText.getText();
		System.out.println(act_text);
		if(act_text.equals(exp_text))
		{
			String total=grandTotal.getText();
			String act_grandTotal=total.replaceAll("[^0-9.]", "");
			System.out.println(act_grandTotal);
			double double_grandTotal=Double.parseDouble(act_grandTotal);
			if(double_grandTotal==exp_grandTotal)
			{
				flag=true;
			}
			else
			{
				flag=false;
			}
			
		}
		return flag;
		
	}
	
	public boolean verifyingOrderNumberIsGeneratedAfterReorder(String exp_msg)
	{
		boolean flag1=false;
		String act_msg=orderCrfMsg.getText();
		System.out.println(act_msg);
		if(act_msg.equals(exp_msg))
		{
			 act_ReorderNo=act_ReorderNo.concat(orderId.getText());
			 System.out.println(act_ReorderNo);
			 boolean b1=!act_ReorderNo.isEmpty();
		     if(b1==true)
		     {
		    	 flag1=true;
		     }
		     else
		     {
		    	 flag1=false;
		     }
			 
		}
		return flag1;
	}
	
}

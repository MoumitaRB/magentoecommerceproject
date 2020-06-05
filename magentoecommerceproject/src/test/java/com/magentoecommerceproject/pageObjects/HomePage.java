package com.magentoecommerceproject.pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	public WebDriver driver;
	public String parentWindowId="";
	public String childWindowId="";
	public String product1="";
	public String product2="";
	public double discountedTotal=0.0;
	public double discountedTotal2=0.0;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//locators
	
	@FindBy(xpath="//h2[contains(text(),'This is demo site for')]")
	@CacheLookup
	WebElement titleText;
	
	
	@FindBy(xpath="//li[@class='level0 nav-1 first']//a")
	@CacheLookup
	WebElement mobileLink;
	
	@FindBy(xpath="//h1[contains(text(),'Mobile')]")
	@CacheLookup
	WebElement mobileTitleTExt;
	
	@FindBy(xpath="//body[contains(@class,'catalog-category-view categorypath-mobile-html category-mobile')]/div[@class='wrapper']/div[@class='page']/div[@class='main-container col3-layout']/div[@class='main']/div[@class='col-wrapper']/div[@class='col-main']/div[@class='category-products']"
			+ "/div[@class='toolbar']/div[@class='sorter']/div[@class='sort-by']/select[1]")
	@CacheLookup
	WebElement dropDownBtn;
	
	@FindBy(xpath="//h2[@class='product-name']//a")
    @CacheLookup
    List <WebElement> productList;
	
	@FindBy(xpath="//h2[@class='product-name']//a[contains(text(),'Sony Xperia')]")
	@CacheLookup
	WebElement sXProductName;
	
	@FindBy(xpath="//span[contains(text(),'$100.00')]")
	@CacheLookup
	WebElement productCost;
	
	@FindBy(xpath="//a//img[@id='product-collection-image-1']")
	@CacheLookup
	WebElement productImg;
	
	@FindBy(xpath="//div[@class='block block-list block-compare']//button[@class='button']")
	@CacheLookup
	WebElement compareBtn;
	
	@FindBy(xpath="//a[@class='skip-link skip-account']")
	@CacheLookup
	WebElement accountLink;
	
	@FindBy(xpath="//div[@id='header-account']//a[contains(text(),'My Account')]")
	@CacheLookup
	WebElement myAccountLink;
	
	@FindBy(xpath="//a[contains(text(),'IPhone')]")
	@CacheLookup
	WebElement productName;
	
	@FindBy(xpath="//li[2]//div[1]//div[3]//button[1]")
	@CacheLookup
	WebElement addToCartBtnForIphone;
	
	@FindBy(xpath="//input[@id='coupon_code']")
	@CacheLookup
	WebElement txtCouponCode;
	
	@FindBy(xpath="//span[contains(text(),'Apply')]")
	@CacheLookup
	WebElement applyBtn;
	
	@FindBy(xpath="//li[@class='success-msg']//ul//li")
	@CacheLookup
	WebElement couponAppliedcrfMsg;
	
	@FindBy(xpath="//a[contains(text(),'Advanced Search')]")
	@CacheLookup
	WebElement advancedSearchLink;
	
	//actoins
	
	public boolean verifyingTitleOfTheHomePage(String exp_title)
	{
		String act_title=driver.getTitle();
		if(act_title.equals(exp_title))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean verifyingTextTitleOfTheHomePage(String exp_text)
	{
		String act_text=titleText.getText();
		if(act_text.equals(exp_text))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
   
	public void clickOnMobileLink()
	{
		mobileLink.click();
	}
	
	public boolean verifyingMobilePageTitle(String exp_title)
	{
		String act_title=mobileTitleTExt.getText();
		if(act_title.equals(exp_title))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void selectOptionFromDropDownBtn() throws InterruptedException
	{
		dropDownBtn.click();
		Select sortBy= new Select(dropDownBtn);
		sortBy.selectByVisibleText("Name");
		Thread.sleep(8000);	
	}
	
	public boolean verifyingAll3ProductsUnderNameDropdown(String exp_productName1,String exp_productName2, String exp_productName3, int totalproduct)
	{  int productNo=0;
	   boolean flag=false;
	   for(WebElement product:productList)
		{
			String act_productName=product.getAttribute("title");
			{
				if((act_productName.equals(exp_productName1))&&(act_productName.equals(exp_productName2))&&(act_productName.equals(exp_productName3)))
				{
					productNo=productNo+1;
					if(productNo==totalproduct)
					{
						flag=true;
					}
					else
					{
						flag=false;
					}
				}
			}
		}
		
	   return flag;
	}
	
	
	public boolean verifyingAll3ProductsSortedByName()
	{ 
	   List<String> originalList=new ArrayList<String>();
	   List<String> sortedList=new ArrayList<String>();
       boolean flag=false;
	
		for(WebElement product:productList)
		{
			String act_productName=product.getAttribute("title");
			originalList.add(act_productName);
			sortedList.add(act_productName);
			
		}
		
		Collections.sort(sortedList);
		if(originalList.equals(sortedList))
		{
			flag=true;
		}
		else
		{
			flag=false;
		}
		
		return flag;	
			
	}
	
	public double readTheCostOfTheProductInMobileListPage(String exp_productName, double exp_productCost)
	{   double mobilePageCost=0.0;
		String act_productName=sXProductName.getText();
		System.out.println(act_productName);
		if(act_productName.equals(exp_productName))
		{
			String cost=productCost.getText();
			String productCost=cost.replaceAll("[^0-9.]", "");
			System.out.println(productCost);
			double act_productCost=Double.parseDouble(productCost);
			if(act_productCost==exp_productCost)
			{
				mobilePageCost=mobilePageCost+act_productCost;
			}
			
		}
		return mobilePageCost;
	}
	
	public void clickOnSonyXperiaMobile()
	{
		productImg.click();
	}
	
	public double readTheCostOfTheProductFromMobileListPage1(String exp_productTitle, double exp_productCost)
	{   
		double mobilePageCost=0.0;
		
		for(WebElement mobile:productList)
		{
			String act_title=mobile.getAttribute("title");
			if(act_title.equals(exp_productTitle))
			{
				String cost=driver.findElement(By.xpath("//h2[@class='product-name']//following-sibling::div//span[@id='product-price-1']//span")).getText();
				String productCost=cost.replaceAll("[^0-9.]", "");
				System.out.println(productCost);
				double act_productCost=Double.parseDouble(productCost);
				if(act_productCost==exp_productCost)
				{
					mobilePageCost=mobilePageCost+act_productCost;
				}
			}
		}
		return mobilePageCost;
	}
	
	
	public void clickOnAddToCartForSonyXperiaMobile(String exp_mobileTitle)
	{
		for(WebElement mobile:productList)
		{
			String act_title=mobile.getAttribute("title");
			if(act_title.equals(exp_mobileTitle))
			{ 
			   driver.findElement(By.xpath("//li[1]//div[1]//div[3]//button[1]")).click();
			   break;
			}
		
	    }
		
		
  }
	
	public void clickOnAddToCompareBtnForSonyXperiaMobile(String exp_mobileTitle1)
	{  
		//List<WebElement>mobileList=driver.findElements(By.xpath("//h2[@class='product-name']//a"));
		for(WebElement mobile:productList)
		{
			String act_title=mobile.getAttribute("title");
			if(act_title.equals(exp_mobileTitle1))
			{ 
                driver.findElement(By.xpath("//li[1]//div[1]//div[3]//ul[1]//li[2]//a[1]")).click();
				break;
		    }
		
	    }
		
	}
	
	public void clickOnAddToCompareBtnForIphoneMobile(String exp_mobileTitle1)
	{  
		List<WebElement>mobileList=driver.findElements(By.xpath("//h2[@class='product-name']//a"));
		for(WebElement mobile:mobileList)
		{
			String act_title=mobile.getAttribute("title");
			if(act_title.equals(exp_mobileTitle1))
			{ 
                driver.findElement(By.xpath("//li[2]//div[1]//div[3]//ul[1]//li[2]//a[1]")).click();
				break;
		
			}
		
	    }
		
	}
	
	public void clickOnCompareBtn()
	{
		compareBtn.click();
	}
	
	//method 1 for handling popup windows
	public boolean verifyingPopupWindowMsg(String exp_title, String exp_text, String exp_product1, String exp_product2) throws InterruptedException
	{   
		boolean flag=false;
		Set<String>windowId=driver.getWindowHandles();
		String parentWindowId = null;
		String parentWindowTitle = null;
		for(String id:windowId) 
	    {  
		   if (parentWindowId==null) 
			   {
			   parentWindowId = id;
			   parentWindowTitle = driver.switchTo().window(parentWindowId).getTitle();
			   }
	       String title= driver.switchTo().window(id).getTitle();
	       System.out.println(title);
	       if(title.equals(exp_title))
	       { 
	    	  driver.manage().window().maximize();
	    	  String act_text= driver.findElement(By.xpath("//h1[contains(text(),'Compare Products')]")).getText();
	    	  String product1=driver.findElement(By.xpath("//a[contains(text(),'Sony Xperia')]")).getText();
	    	  String product2=driver.findElement(By.xpath("//a[contains(text(),'IPhone')]")).getText();
	    	  Thread.sleep(6000);
	    	  if((act_text.equals(exp_text))&&(product1.equals(exp_product1))&&(product2.equals(exp_product2)))
	    	  {
	    		 flag=true;
	    		 driver.close();
	    		 Thread.sleep(6000);
	    		 driver.switchTo().window(parentWindowId);
	  			 String act_title=driver.getTitle();
	  			 System.out.println(act_title);
	  			 if(act_title.equals(parentWindowTitle))
	  			 {
	  				return true;
	  			 }
	  			 else
	  			 {
	  				return false;
	  			 }
	    	  }
	    	  else
	    	  {
	    		  flag=false;
	    	  }
	    	 
	       }
	      
	 } 
		return flag;
 
}
	
	//method 2 for handling pop up windows
	public void handlingWindows(String exp_title)
	{
		Set<String>windowId=driver.getWindowHandles();
		for(String id:windowId)
		{
			String act_title=driver.switchTo().window(id).getTitle();
			if(act_title.equals(exp_title))
			{   
				childWindowId=childWindowId+id;
				System.out.println("Child window id is:"+childWindowId);
				System.out.println(driver.getTitle());
			}
			else
			{
				parentWindowId=parentWindowId+id;
				System.out.println("Parent window id is:"+parentWindowId);
			}
		}
		
	}
	
	public void getProductsNameAfterAddingToCompareList()
	{
	   String product=driver.findElement(By.xpath("//p[@class='product-name']//a[contains(text(),'Sony Xperia')]")).getText();
	   product1=product1+product;
	   System.out.println("1st product name:"+product1);
	   String sec_product= driver.findElement(By.xpath("//p[@class='product-name']//a[contains(text(),'IPhone')]")).getText();
	   product2=product2+sec_product;
	   System.out.println("2nd product name:"+product2);
	}
	
	public boolean verifyingPopUpWindowMsges(String exp_text) throws InterruptedException
	{  
		boolean flag=false;
		driver.switchTo().window(childWindowId);
		driver.manage().window().maximize();
  	    String act_text= driver.findElement(By.xpath("//h1[contains(text(),'Compare Products')]")).getText();
  	    String act_product1=driver.findElement(By.xpath("//a[contains(text(),'Sony Xperia')]")).getText();
  	    String act_product2=driver.findElement(By.xpath("//a[contains(text(),'IPhone')]")).getText();
  	    Thread.sleep(6000);
  	    if(act_text.equals(exp_text)&&(act_product1.equals(product1))&&(act_product2.equals(product2)))
  	    {
  	    	flag= true;
  	    	driver.close();
  	    	//driver.findElement(By.xpath("//button[@class='button']")).click();
  	    }
  	    else
  	    {
  	    	flag=false;
  	    }
		
  	    return flag;
	}
	
	public boolean verifyingHomepageTitle(String exp_title)
	{
		driver.switchTo().window(parentWindowId);
	    String act_title=driver.getTitle();
	    System.out.println("Parent window title is:"+act_title);
	    if(act_title.equals(exp_title))
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }
	}
	
	public void clickOnMyAccountLink()
	{
		accountLink.click();
		myAccountLink.click();
		
	}

	public void clickOnAddToCartButtonForIphone(String exp_productName)
	{
		String act_productName=productName.getText();
		System.out.println(act_productName);
		if(act_productName.equals(exp_productName))
		{
			addToCartBtnForIphone.click();
		}
	}
	
	public void setCouponCode(String coupon)
	{
		txtCouponCode.clear();
		txtCouponCode.sendKeys(coupon);
	}
	
	public void clickOnApplyBtn()
	{
		applyBtn.click();
	}
	
	public boolean verifyingCouponAppliedConfirmationMsg(String exp_msg)
	{
		String act_crfMsg=couponAppliedcrfMsg.getText();
		System.out.println(act_crfMsg);
		if(act_crfMsg.equals(exp_msg))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//didn't use it
	public void gettingDiscountedPriceAfterApplyingCoupon(double exp_subTotal,double exp_couponDiscount)
	{   
		List<WebElement>rownum=driver.findElements(By.xpath("//table[@id='shopping-cart-totals-table']//tbody//tr"));
		for(int r=1; r<=rownum.size(); r++)
		{
			String subTotal=driver.findElement(By.xpath("//table[@id='shopping-cart-totals-table']//tbody//tr["+r+"]//td[2]")).getText();
		    String act_subTotal=subTotal.replaceAll("[^0-9.]", "");
		    System.out.println(act_subTotal);
		    double double_subTotal=Double.parseDouble(act_subTotal);
		    if(double_subTotal==exp_subTotal)
		    {
		    	discountedTotal=discountedTotal+double_subTotal;
		    	String couponDiscount=driver.findElement(By.xpath("//table[@id='shopping-cart-totals-table']//tbody//tr["+(r+1)+"]//td[2]")).getText();
		    	String act_couponDiscount=couponDiscount.replaceAll("[^0-9.]", "");
		    	System.out.println(act_couponDiscount);
		    	double double_couponDiscount=Double.parseDouble(act_couponDiscount);
		    	if(double_couponDiscount==exp_couponDiscount)
		    	{
		    		discountedTotal=discountedTotal-double_couponDiscount;
		    		System.out.println(discountedTotal);
		    	}
		    	
		    }
		    
		  }
			
	  }
	
	public void gettingDiscountedPriceBy5PercentAfterApplyingCoupon(double exp_subTotal)
	{  
		boolean flag=false;
		double fivePercentOfSubTotal=0.0;
		List<WebElement>rownum=driver.findElements(By.xpath("//table[@id='shopping-cart-totals-table']//tbody//tr"));
		for(int r=1; r<=rownum.size(); r++)
		{
			String subTotal=driver.findElement(By.xpath("//table[@id='shopping-cart-totals-table']//tbody//tr["+r+"]//td[2]")).getText();
		    String act_subTotal=subTotal.replaceAll("[^0-9.]", "");
		    System.out.println("Subtotal after removing regex:"+act_subTotal);
		    double double_subTotal=Double.parseDouble(act_subTotal);
		    if(double_subTotal==exp_subTotal)
		    {
		    	discountedTotal2=discountedTotal2+double_subTotal;
		    	fivePercentOfSubTotal=(discountedTotal2*5)/100;
		    	System.out.println("5 percent of 500 is:"+fivePercentOfSubTotal);
		    	String couponDiscount=driver.findElement(By.xpath("//table[@id='shopping-cart-totals-table']//tbody//tr["+(r+1)+"]//td[2]")).getText();
		    	String act_couponDiscount=couponDiscount.replaceAll("[^0-9.]", "");
		    	System.out.println("Coupon discount after removing regex:"+act_couponDiscount);
		    	double double_couponDiscount=Double.parseDouble(act_couponDiscount);
		    	if(double_couponDiscount==fivePercentOfSubTotal)
		    	{
		    		discountedTotal2=discountedTotal2-fivePercentOfSubTotal;
		    		System.out.println("Discounted total is:"+discountedTotal2);
		    		flag=true;
		    		break;
		    	}
		    	
		     }
		    if(flag=true)
		    {
		     break;
		    }
		}
	}
	
	public boolean verifyingDiscountedPrice()
	{
		String discountedPrice=driver.findElement(By.xpath("//table[@id='shopping-cart-totals-table']//tfoot//tr/td[2]")).getText();
		String act_discountedPrice=discountedPrice.replaceAll("[^0-9.]","");
		System.out.println("Total after removing regular expressions:"+act_discountedPrice);
		double double_discountedPrice=Double.parseDouble(act_discountedPrice);
		if(double_discountedPrice==discountedTotal2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void clickOnAdvancedSearchLink()
	{
		advancedSearchLink.click();
	}
 }
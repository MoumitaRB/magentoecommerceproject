package com.magentoecommerceproject.pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvancedSearchPage {
	public WebDriver driver;
	public HashMap<String, Double> hm=new HashMap<String, Double>();
	
	
	public AdvancedSearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//locators
	
	
	@FindBy(xpath="//a[contains(text(),'Catalog Advanced Search')]")
	@CacheLookup
	WebElement catalogAdvancedSearchLink;
	
	//actions
	
	public void setPriceFrom(String priceValue)
	{
		WebElement txtPriceFrom=driver.findElement(By.xpath("//input[@id='price']"));
		txtPriceFrom.clear();
		txtPriceFrom.sendKeys(priceValue);
	}
	
	public void setPriceTo(String priceValue)
	{
		WebElement txtPriceTo=driver.findElement(By.xpath("//input[@id='price_to']"));
		txtPriceTo.clear();
		txtPriceTo.sendKeys(priceValue);
	}
	
	public void clickOnSearchBtn()
	{   
		WebElement searchBtn=driver.findElement(By.xpath("//div[@class='buttons-set']//button[@class='button']"));
		searchBtn.click();
	}
	
	public void gettingTheProductNameAndPrice(String exp_productName1, String exp_productName2, double exp_price1, double exp_price2)
	{  
		List<WebElement>productName=driver.findElements(By.xpath("//li[@class='item last']//img//parent::a//following-sibling::div//h2//a"));
		for(WebElement name:productName)
		{
			String act_productName=name.getText();
		    System.out.println("product name is:"+act_productName);
			if(act_productName.equals(exp_productName1))
			{   
				String price1= driver.findElement(By.xpath("//li//a//parent::li//div//div//span[@id='product-price-1']//span")).getText();
			    String act_price=price1.replaceAll("[^0-9.]", "");
				System.out.println("Xperia price is:"+act_price);
				double double_price=Double.parseDouble(act_price);
				if(double_price==exp_price1)
				{
			      hm.put(act_productName, double_price);
				}	   
			}
			else if(act_productName.equals(exp_productName2))
			{
				String price2=driver.findElement(By.xpath("//li//a//parent::li//div//div//span[@id='product-price-3']")).getText();
				String act_price=price2.replaceAll("[^0-9.]", "");
				System.out.println("Xperia price is:"+act_price);
				double double_price=Double.parseDouble(act_price);
				if(double_price==exp_price2)
				{
					hm.put(act_productName, double_price);
				}
			}
		}
		System.out.println(hm);
	}
	
	public void gettingTheProductNameAndPriceMethod2(String exp_productName1, String exp_productName2,String exp_productName3, String value1, String value2, double exp_price1, double exp_price2, double exp_price3)
	{
		List<WebElement>productName=driver.findElements(By.xpath("//li[@class='item last']//img//parent::a//following-sibling::div//h2//a"));
		for(WebElement name:productName)
		{
			String act_productName=name.getText();
		    System.out.println("product name is:"+act_productName);
			if((act_productName.equals(exp_productName1))||(act_productName.equals(exp_productName3)))
			{
				List<WebElement>pricelist=driver.findElements(By.xpath("//li[@class='item last']//a//parent::li//div//div//span//span"));
				System.out.println(pricelist.size());
				for(WebElement price:pricelist)
				{
					String price1=price.getText();
					System.out.println(price1);
					if((price1.contains(value1))||(price1.contains(value2)))
					{
						 String act_price=price1.replaceAll("[^0-9.]", "");
						 System.out.println("product price is:"+act_price);
						 double double_price=Double.parseDouble(act_price);
						 if((double_price==exp_price1)||(double_price==exp_price3))
							{
						      hm.put(act_productName, double_price);
						      break;
							}	   
					 
					}
				}
			}
			else if(act_productName.equals(exp_productName2))
			{
				String price2=driver.findElement(By.xpath("//li[@class='item last']//a//parent::li//div//div//p[@class='special-price']//span[2]")).getText();
				String act_price=price2.replaceAll("[^0-9.]", "");
				System.out.println("Product sale price is:"+act_price);
				double double_price=Double.parseDouble(act_price);
				if(double_price==exp_price2)
				{
					hm.put(act_productName, double_price);
				}
			}
		}
		System.out.println(hm);
	}
	
	
	public void clickOnCatalogAdvancedSearchLink()
	{
		catalogAdvancedSearchLink.click();
	}
}

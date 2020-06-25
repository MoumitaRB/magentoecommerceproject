package com.magentoecommerceproject.pageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AdminLoginPage {
	
	public WebDriver driver;

	
	public AdminLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//locators
	
	@FindBy(id="username")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(id="login")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@class='form-button']")
	@CacheLookup
	WebElement loginBtn;
	

	
	@FindBy(id="sales_order_grid_filter_status")
	@CacheLookup
	WebElement statusdropdownBtn;
	
	@FindBy(xpath="//span[contains(text(),'Search')]")
	@CacheLookup
	WebElement searchBtn;
	
	@FindBy(xpath="//table[@id='sales_order_grid_table']//tr[1]//td[1]//input")
	@CacheLookup
	WebElement checkBox;
	
	@FindBy(id="sales_order_grid_massaction-select")
	@CacheLookup
	WebElement actionDropdown;
	
	@FindBy(xpath="//span[contains(text(),'Submit')]")
	@CacheLookup
	WebElement submitBtn;
	
	@FindBy(xpath="//li[@class='error-msg']")
	@CacheLookup
	WebElement errorMsg;
	
	
	//actions
	
	public void setUserName(String uname)
	{
		txtUserName.clear();
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	public void clickOnLoginBtn()
	{
		loginBtn.click();
	}
	


}

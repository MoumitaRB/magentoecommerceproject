package com.magentoecommerceproject.pageObjects;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;


public class AdminHomePage {
	
	public WebDriver driver;
	public String file_path="";
	public ArrayList<Date>originalList=new ArrayList<Date>();
    public ArrayList<Date>sortedList=new ArrayList<Date>();
	
	public AdminHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//locators
	
	@FindBy(xpath="//span[contains(text(),'close')]")
	@CacheLookup
	WebElement closeBtn;
	
	@FindBy(xpath="//span[contains(text(),'Sales')]")
	@CacheLookup
	WebElement salesTab;
	
	@FindBy(xpath="//span[contains(text(),'Orders')]")
	@CacheLookup
	WebElement orderTab;
	
	@FindBy(xpath="//select[@id='sales_order_grid_export']")
	@CacheLookup
	WebElement exportDropDownBtn;
	
	@FindBy(xpath="//button[@title='Export']")
	@CacheLookup
	WebElement exportBtn;

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
	
	@FindBy(xpath="//span[contains(text(),'Catalog')]")
	@CacheLookup
	WebElement catalogTab;
	
	@FindBy(xpath="//span[contains(text(),'Reviews and Ratings')]")
	@CacheLookup
	WebElement reviewAndRatingTab;
	
	@FindBy(xpath="//span[contains(text(),'Customer Reviews')]")
	@CacheLookup
	WebElement customerReviewTab;
	
	@FindBy(xpath="//span[contains(text(),'Pending Reviews')]")
	@CacheLookup
	WebElement pendingReviewTab;
	
	@FindBy(xpath="//li[@class='error-msg']")
	@CacheLookup
	WebElement errorMsg;
	
	@FindBy(id="status_id")
	@CacheLookup
	WebElement statusDropDown2;
	
	@FindBy(xpath="//div[@id='page:main-container']//button[@id='save_button']")
	@CacheLookup
	WebElement saveBtn;
	
	@FindBy(xpath="//span[contains(text(),'Invoices')]")
	@CacheLookup
	WebElement invoiceTab;
	
	@FindBy(xpath="//a[@name='created_at']")
	@CacheLookup
	WebElement invoiceDateBtn;
	
	@FindBy(xpath="//a[@class='active']//span[contains(text(),'Customers')]")
	@CacheLookup
	WebElement customerTab;
	
	@FindBy(xpath="//span[contains(text(),'Manage Customers')]")
	@CacheLookup
	WebElement manageCustomerTab;
	
	@FindBy(xpath="//div[@class='grid']//tr[2]//td[1]//input[1]")
	@CacheLookup
	WebElement checkBoxForCustomerDetails;
	
	@FindBy(xpath="//div[@class='grid']//tr[2]//td[11]//a")
	@CacheLookup
	WebElement editLink;
	
	@FindBy(xpath="//span[contains(text(),'Account Information')]")
	@CacheLookup
	WebElement accountInfoTab;
	
	@FindBy(id="_accountwebsite_id")
	@CacheLookup
	WebElement associatedToWebsiteTab;
	
	@FindBy(id="_accountcreated_in")
	@CacheLookup
	WebElement createdFromTab;
	
	@FindBy(id="_accountmiddlename")
	@CacheLookup
	WebElement middleName;
	
	@FindBy(id="_accountdob")
	@CacheLookup
	WebElement dob;

	
	@FindBy(id="_accountnew_password")
	@CacheLookup
	WebElement password;
	
	
	//actions
	
	public void clickOnCloseBtn()
	{
		closeBtn.click();
	}
	
	public void clickOnOrderTabUnderSalesTab()
	{
		Actions act=new Actions(driver);
		act.moveToElement(salesTab).perform();
		act.moveToElement(orderTab).click().perform();
	}
	
	public void selectCSVOptionFromDropDown(String ddValue)
	{
		Select csvdd=new Select(exportDropDownBtn);
		csvdd.selectByVisibleText(ddValue);
	}
	
	public void clickOnExportBtn()
	{
		exportBtn.click();
	}
	
	public boolean isFileExsists(String location)
	{ 
	  boolean flag=false;
	  try {
		File f=new File(location);
		if(f.exists())
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
	
	//method 2 for file exsists
	
	public boolean isFileDownloaded(String downloadPath, String fileName)
	{
		boolean flag = false;
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().contains(fileName))
	            return flag=true;
	            }

	    return flag;
	}
	
	//getting last modified file in a specific location
	
	public String getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) 
	    {
	        return null;
	    }
	
	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) 
	       {
	           lastModifiedFile = files[i];
	       }
	    }
	    System.out.println(lastModifiedFile);
	    file_path=file_path+lastModifiedFile;
	    System.out.println(file_path);
	   
	    return file_path;
	}
	
	public boolean isFileExsistsMethod2()
	{ 
		boolean flag=false;
		  try {
			File f=new File(file_path);
			if(f.exists())
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
	
	//method 1 for reading csv file
	public void readCSVData(String file_path) throws IOException, Exception
	{
		CSVReader reader = new CSVReader(new FileReader(file_path));
        List<String[]> data = reader.readAll();
		
		for(String[] d : data){
			
			for(String c : d ){
				
				System.out.println(c);
			}
		}
	}
  
	//method 2 for reading csv file
	public void readCSVFile(String path) throws CsvValidationException, IOException
	{
	 try {
		CSVReader reader1 = new CSVReader(new FileReader(path));
		String[]cell;
		
		while((cell=reader1.readNext())!=null)
		{
			
			  String orderNo=cell[0];
			  String purchasedOn=cell[1];
			  String billingName=cell[2];
			  String shippingName=cell[3];
			  String base=cell[4];
			  String purchased=cell[5];
			  String status=cell[6];
			  System.out.println(orderNo+" , "+purchasedOn+" , "+billingName+" , "+shippingName+" , "+base+" , "+purchased+" , "+status);
			
		}	
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	}
	
	
    public void selectStatusOptionsFromDropdown(String value)
	
	{
		statusdropdownBtn.click();
		Select statusdd=new Select(statusdropdownBtn);
		statusdd.selectByVisibleText(value);
	}
	
	public void clickOnSearchBtn()
	{
		searchBtn.click();
		
	}
	
	public void clickOnCheckBox()
	{
		checkBox.click();
	}
	
	public void selectActionOptionsFromDropdown(String value)
	{
		actionDropdown.click();
		Select actiondd=new Select(actionDropdown);
		actiondd.selectByVisibleText(value);
	}
	
	public void clickOnSubmitBtn()
	{
		submitBtn.click();
	}
	
	public boolean verifyingErrorMsg(String exp_msg)
	{ 
		String act_msg=errorMsg.getText();
		System.out.println("Error msg:"+act_msg);
		if(act_msg.equals(exp_msg))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void clickOnPendingReviewTabUnderCatalogTab()
	{
		Actions action=new Actions(driver);
		action.moveToElement(catalogTab).perform();
		action.moveToElement(reviewAndRatingTab).perform();
		action.moveToElement(customerReviewTab).perform();
		action.moveToElement(pendingReviewTab).click().perform();
	}
	
	public void clickOnEditLinkAfterSortingTableById()
	{   ArrayList<Long>idList=new ArrayList<Long>();
		List<WebElement>rownum=driver.findElements(By.xpath("//table[@id='reviwGrid_table']//tbody//tr"));
		System.out.println("Total number of rows:"+rownum.size());
		for(int r=1; r<=rownum.size(); r++)
		{
			String idNo=driver.findElement(By.xpath("//table[@id='reviwGrid_table']//tbody//tr["+r+"]//td[2]")).getText();
			String act_idNo=idNo.replaceAll("[^0-9]", "");
			long long_actId=Long.parseLong(act_idNo);
			System.out.println(long_actId);
			idList.add(long_actId);   

			driver.findElement(By.xpath("//table[@id='reviwGrid_table']//tbody//tr[1]//td[1]//input")).click();
			driver.findElement(By.xpath("//tr[1]//td[10]//a[1]")).click();
			break;
			
		}
		
	}
   
	public void selectOptionsFromStatus2DropDown(String value)
	{
		Select statusDropDown=new Select(statusDropDown2);
		statusDropDown.selectByVisibleText(value);
	}
	
	public void clickonSaveBtn()
	{
		saveBtn.click();
	}
	
	public void clickOnInvoiceTabUnderSaleTab()
	{
		Actions act=new Actions(driver);
		act.moveToElement(salesTab).perform();
		act.moveToElement(invoiceTab).click().perform();
	}
	
	public void storingInvoiveDatesInArraylists() throws ParseException
	{   
		List<WebElement>rownum=driver.findElements(By.xpath("//table[@id='sales_invoice_grid_table']//tbody//tr"));
	    for(int r=1; r<=rownum.size(); r++)
	    {
	    	String dates=driver.findElement(By.xpath("//table[@id='sales_invoice_grid_table']//tbody//tr["+r+"]//td[3]")).getText();
	    	System.out.println(dates);
	    	SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM dd,yyyy");
	    	originalList.add(dateFormatter.parse(dates));
	    	System.out.println("listDates before sorting: "+originalList);
	        sortedList.add(dateFormatter.parse(dates));
	        System.out.println("sortedList before sorting: "+sortedList);
	        
	    }
	 }
	
	public boolean sortingInvoiceDatesInDecendingOrder()
	{   
		boolean flag=false;
	    Collections.sort(sortedList,Collections.reverseOrder());
	    System.out.println("Sortedlist after sorting in decending order:"+sortedList);
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
	
	public void clickOnInvoiceDateBtn()
	{
		invoiceDateBtn.click();
	}
	
	public boolean sortingInvoiceDatesInAssendingOrder()
	{
		boolean flag=false;
	    Collections.sort(sortedList);
	    System.out.println("Sortedlist after sorting in assending order:"+sortedList);
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
	
	public void clickOnManageCustomerTabUnderCustomerTab()
	{
		Actions act=new Actions(driver);
		act.moveToElement(customerTab).perform();
		act.moveToElement(manageCustomerTab).click().perform();
	}
	
	public void clickOnCheckBoxForCustomerDetails()
	{
		checkBoxForCustomerDetails.click();
	}
	
	public void clickOnEditLink()
	{
		editLink.click();
	}
	
	public void clickOnAccountInformationTab()
	{
		accountInfoTab.click();
	}
	
	public boolean verifyingDisabledFields()
	{
		boolean b1=associatedToWebsiteTab.isEnabled();
		boolean b2=createdFromTab.isEnabled();
		if((b1==false)&&(b2==false))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean verifyingBlankFields()
	{
		boolean text1=middleName.getText().isEmpty();
		boolean text2=dob.getText().isEmpty();
		boolean text4=password.getText().isEmpty();
		if((text1==true)&&(text2==true)&&(text4==true))
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
		
	}
}

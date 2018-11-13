package com.skerp.qa.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.skerp.testbase.TestBase;



public class MenuPage extends TestBase {
	
	
	@FindBy(xpath=".//a[@href='#/dashboard']/following-sibling::a")
	public
	WebElement DashboardButton;
	
	@FindBy(xpath=".//span[text()='POS']")
	WebElement POSMenu;
	
	@FindBy(xpath=".//span[text()='Physical Orders']")
	WebElement PhysicalOrders;
	
	@FindBy(xpath=".//span[text()='Lending']")
	WebElement Lending;
	
	@FindBy(xpath=".//a[@href='#/pos/aepsDevices' and text()='AEPS Devices']")
	WebElement AEPSDeviceMap;
	
	@FindBy(xpath=".//a[contains(text(),'Order list')]")
	WebElement Order_list;
	
	
	
	@FindBy(xpath=".//a[contains(text(),'AEPS Orders')]")
	WebElement AEPSOrders;
	
	@FindBy(xpath=".//button[@modal-title='Bulk Upload Device']")
	WebElement BulkUploadButton;
	
	public MenuPage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,15), this);
	}
	

	public Boolean IsDashboardDispalyed() {
		return DashboardButton.isDisplayed();
	}
	
	public void clicksonDashboard() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", DashboardButton);
	}
	
	public void clicksonPOSMenu() {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()", POSMenu);
		POSMenu.click();
	}
	
	public AEPSListPage clicksonAEPSSubMenu() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", AEPSDeviceMap);
		return new AEPSListPage();
	}
	
	public void clicksonPhysicalOrder() {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()", PhysicalOrders);
		PhysicalOrders.click();
	}
	
	public void clicksonOrder_List() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click()",Order_list);
		
	}
}

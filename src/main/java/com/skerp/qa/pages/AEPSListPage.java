package com.skerp.qa.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.skerp.qa.utils.Util;
import com.skerp.testbase.TestBase;

public class AEPSListPage extends TestBase {
	
	@FindBy(xpath=".//h1[@class='al-title']")
	WebElement AEPSListPageTitle;
	
	@FindBy(xpath=".//buttton[@class='pull-right btn btn-success']")
	WebElement Add;
	
	//Add Page
	
	@FindBy(xpath=".//pageslide/div/div[@class='panel-heading text-center ng-binding']")
	WebElement TitleofAddPage;
	
	
	@FindBy(xpath=".//input[@placeholder='Enter Device ID']")
	WebElement DeviceName;
	
	@FindBy(xpath=".//input[@placeholder='Enter Model ID']")
	WebElement ModelId;
	
	@FindBy(xpath="//input[@placeholder='Enter Merchant ID']")
	WebElement MerchantID;
	
	@FindBy(xpath=".//input[@placeholder='Enter Firmware ID']")
	WebElement FirmwareID;
	
	@FindBy(xpath=".//input[@placeholder='Enter Login Name']")
	WebElement LoginName;
	
	@FindBy(xpath=".//select[@placeholder='Select Fingerprint Device Name']")
	WebElement SelectDevice;
	
	@FindBy(xpath=".//input[@placeholder='Enter Fingerprint Device ID']")
	WebElement FingerPrintDeviceId;
	
	@FindBy(xpath="//select[@placeholder='Select Fingerprint Device Name']")
	WebElement fingerDeviceName;
	
	@FindBy(xpath=".//select[@ng-model='formData.isServiceEnabled']")
	WebElement SelectServiceEnable;
	
	@FindBy(xpath=".//select[@ng-model='formData.partnerId']")
	WebElement SelectPartner;
	
	@FindBy(xpath="//button[@type='submit'][contains(text(),'Add')]")
	WebElement AddSubmit;
	
	@FindBy(xpath="//button[@name='button']")
	WebElement addfingerdevices;
	
	@FindBy(xpath=".//input[@ng-model='formData._franchiseDetails']")
	WebElement SearchFranchise;
	
	
	
	
	
	
	
	public AEPSListPage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	public boolean IsTitleCorrect() {
		System.out.println(AEPSListPageTitle.getText());
	   return	AEPSListPageTitle.isDisplayed();
		
	}
	
	public void clicksonAdd() {
		Add.click();
	}
	
	public Boolean validatethePageSlideover()
	{
		System.out.println(TitleofAddPage.getText());
		return TitleofAddPage.isDisplayed();
	}
	
	public void enterDeviceID(String deviceID) {
		DeviceName.clear();
		DeviceName.sendKeys(deviceID);
	}
	
	public void enterModelID(String modelID) {
		ModelId.clear();
		ModelId.sendKeys(modelID);
	}
	
	public void enterLoginName(String loginName) {
		LoginName.clear();
		LoginName.sendKeys(loginName);
	}
	
	public void selectFingerprintDeviceNAme(String fingerprintdevicename) throws InterruptedException {
		Util.selectvaluebyvalue(fingerDeviceName, fingerprintdevicename);
	}
	
	public void enterFingerprintdeviceID(String fingerID) {
		FingerPrintDeviceId.clear();
		FingerPrintDeviceId.sendKeys(fingerID);
	}
	
	public void enterMarchentID(String MarchentId) {
		MerchantID.clear();
		MerchantID.sendKeys(MarchentId);
	}
	
	public void enterFirmwareID(String firm) {
		FirmwareID.clear();
		FirmwareID.sendKeys(firm);
	}
	
	public void selectPartner(String value) throws InterruptedException {
		Util.selectvaluebyvalue(SelectPartner, value);
		
	}
	public void SearchForFranchise(String value) throws InterruptedException {
		Util.AutoBox(SearchFranchise, value);
		
	}
	
   public void selectServiceEnabled(String value) throws InterruptedException {
	   Util.selectvaluebyvalue(SelectServiceEnable, value);
   }
   
   
   public void add_fingerdevice() {
	   addfingerdevices.click();
   }
   public AEPSListPage clicksonAdd_Submit() {
	   AddSubmit.click();
	   return new AEPSListPage();
	   
   }
}

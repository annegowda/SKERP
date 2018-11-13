package com.skerp.qa.pagetest;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.skerp.qa.pages.AEPSListPage;
import com.skerp.qa.pages.LoginPage;
import com.skerp.qa.pages.MenuPage;
import com.skerp.qa.utils.Util;
import com.skerp.testbase.TestBase;

import net.bytebuddy.jar.asm.commons.Method;

public class AEPSListPageTest extends TestBase{

	LoginPage login;
	MenuPage menu;
	AEPSListPage AEPSlistpage;
	
	public AEPSListPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void intializeAll(Method method) {
		report.createTest(method.getName());
		intiatizeBrowser();
		login=new LoginPage();
		
	}
	@Test()
	public void navigatetoAEPSDeviceMappingPageTest() throws InterruptedException {
		menu=login.loginToERP("8095188085","gowda@12");
		assertTrue(menu.IsDashboardDispalyed(),"Button is not clickable");
		menu.clicksonDashboard();;		
	     menu.clicksonPOSMenu();
	     Thread.sleep(1000);
	   AEPSlistpage=  menu.clicksonAEPSSubMenu();
	  Boolean title= AEPSlistpage.IsTitleCorrect();
	  assertTrue(title,"Not corret");
	  
	  AEPSlistpage.clicksonAdd();
	  Thread.sleep(10);
	Boolean slided=  AEPSlistpage.validatethePageSlideover();
	assertTrue(slided,"Add device page not slided");
	Thread.sleep(1000);
	
	AEPSlistpage.enterDeviceID("DV123");
	AEPSlistpage.enterModelID("model123");

	AEPSlistpage.enterMarchentID("MS12312");
	AEPSlistpage.enterFirmwareID("firmID");
	AEPSlistpage.enterLoginName("32131231");
	AEPSlistpage.selectFingerprintDeviceNAme("Mantra");
	AEPSlistpage.enterFingerprintdeviceID("fing123155");
	AEPSlistpage.selectPartner("Atathi");
	AEPSlistpage.add_fingerdevice();
	
	AEPSlistpage.selectServiceEnabled("Disable");
	Thread.sleep(100);
	AEPSlistpage.clicksonAdd_Submit();
	AEPSlistpage.SearchForFranchise("gowda");
	Thread.sleep(100);
	
	
	Thread.sleep(100);
	AEPSlistpage.clicksonAdd_Submit();
	
	Thread.sleep(100);
	Boolean title1= AEPSlistpage.IsTitleCorrect();
	  assertTrue(title1,"Not corret");
	
	     
	    
	}
}

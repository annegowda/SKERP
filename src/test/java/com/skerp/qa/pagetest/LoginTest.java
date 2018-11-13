package com.skerp.qa.pagetest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.skerp.qa.pages.LoginPage;
import com.skerp.qa.pages.MenuPage;
import com.skerp.qa.utils.Util;
import com.skerp.testbase.TestBase;


public class LoginTest extends TestBase {
	
	LoginPage loginpage;
	MenuPage menu;
	String path="C:\\Users\\user\\eclipse-workspace\\SKERP\\Inputs\\inputs.xlsx";
	
	
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void intiateallMethods(Method method) {
		report.createTest(method.getName());
		intiatizeBrowser();
		loginpage=new LoginPage();
		
	}
	
	
	
	@Test()
	public void validateLoginPage() throws InterruptedException {
		Boolean logo=loginpage.logoValidation();
		Thread.sleep(1);
		assertTrue(logo, "Logo Isdisplayed");
		
	}
	
	@Test(dataProvider="dataprovider",dataProviderClass=com.skerp.qa.pagetest.LoginTest.class)
	public void login(String username,String pwd) throws InterruptedException {
	menu=loginpage.loginToERP(username, pwd);
	Boolean dashboardlogo=menu.IsDashboardDispalyed();
	Thread.sleep(10);
	assertTrue(dashboardlogo);
		
	}
	
	
	@DataProvider(name="dataprovider")
	public static Object[][] datagenerator(Method method) {
		String sheetname=method.getName();
		return Util.dataProvider(sheetname );
	}
	
	

}

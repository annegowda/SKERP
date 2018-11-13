package com.skerp.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.skerp.qa.utils.Util;
import com.skerp.qa.utils.WebElementListner;


public class TestBase {

	public static WebDriver driver;
	
	public static Properties prop;
	public static ExtentHtmlReporter htmlreport;
	public static ExtentReports report;
	
	
	public TestBase() {
		try {
			prop=new Properties();
			FileInputStream file=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\SKERP\\Prop.properties");
			prop.load(file);
		}catch (FileNotFoundException filenotfound) {
			System.out.println(filenotfound.getMessage());
		}catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
	}
	
	public void intiatizeBrowser() {
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","D:\\software\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		
		EventFiringWebDriver e_driver=new EventFiringWebDriver(driver);
		WebElementListner listner=new WebElementListner();
		e_driver.register(listner);
		driver=e_driver;
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
				
		
	}
	
	@AfterMethod
	public void teardownBrowser(ITestResult result) throws IOException {
		System.out.println("status="+result.getStatus()+"  testname="+result.getTestName()+"  name="+result.getName()+"  instent name="+result.getInstanceName());
		if(result.isSuccess()==false) {
		Util.captureScreenshotForFailedTest(result.getName());
		}
		driver.close();
	}
	
	@BeforeSuite
	public void beforesuit() {
		htmlreport=new ExtentHtmlReporter("C:\\Users\\user\\eclipse-workspace\\SKERP\\Inputs\\"+"Extend2"+".html");
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		htmlreport.setAppendExisting(true);
	}
	
	@AfterSuite
	public void aftersuit() {
		report.flush();

	}
}

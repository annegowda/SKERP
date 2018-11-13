package com.skerp.qa.pagetest;

import java.lang.reflect.Method;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Test1 {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	
	@BeforeSuite
	public void bfs() {
		 htmlReporter = new ExtentHtmlReporter("C:\\Users\\user\\eclipse-workspace\\SKERP\\Inputs\\"+"extent.html");
		
		 extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.setAppendExisting(true);
		 logger=extent.createTest("LoginTest");
		System.out.println("before Suit");
		
	}

	
	@BeforeTest
	public void bfT() {
		System.out.println("before Test");
	}
	
	@BeforeClass
	public void bfC() {
		System.out.println("before class");
	}
	
	@BeforeMethod
	public void bfM(Method method) {
		logger=extent.createTest(method.getName());
		System.out.println(this.getClass().getName()+"  method="+method.getName());
		System.out.println("before Method");
	}
	
	
	@AfterSuite
	public void Afs() {
		extent.flush();
		System.out.println("After Suit");
	}

	
	@AfterTest
	public void AfT() {
		
		System.out.println("After Test");
	}
	
	@AfterClass
	public void AfC() {
		System.out.println("After class");
	}
	
	@AfterMethod
	public void AfM() {
		
		System.out.println("After Method");
	}
	
	@org.testng.annotations.Test
	public void test11() {
		System.out.println("test1");
	}
	
	@org.testng.annotations.Test
	public void test2() {
		System.out.println("test2");
	}
	
}

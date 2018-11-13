package com.skerp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.skerp.testbase.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath=".//img[@src='/assets/img/sk_logo_blue.png']")
	WebElement dashboardLogo;
	
	
	public HomePage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
	}

	
	
	public Boolean isDashboardLogoDisplayed() {
		return dashboardLogo.isDisplayed();
	}
}

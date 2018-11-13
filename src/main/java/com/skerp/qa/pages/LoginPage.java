package com.skerp.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.skerp.testbase.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(id="inputEmail3")
	WebElement userName;
	
	@FindBy(id="inputPassword3")
	WebElement password;
	
	@FindBy(xpath=".//button[@ng-click='logIn()']")
	WebElement signIn;
	
	@FindBy(xpath=".//img[@src='/assets/img/sk_logo_auth.png']")
	WebElement loginLogo;
	
	@FindBy(xpath="")
	WebElement forgotPasswordLink;
	
	public LoginPage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
	}

	
	public Boolean logoValidation() {
		return loginLogo.isDisplayed();
	}
	
	public MenuPage loginToERP(String userName1,String pwd) {
		
		userName.sendKeys(userName1);
		password.sendKeys(pwd);
		signIn.click();
		return new  MenuPage();
	}

	
	
	
}

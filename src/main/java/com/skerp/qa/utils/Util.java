package com.skerp.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.skerp.testbase.TestBase;

public class Util extends TestBase{

	
	public static Object[][] dataProvider(String sheetname){
		
		FileInputStream file = null;
		String path="C:\\Users\\user\\eclipse-workspace\\SKERP\\Inputs\\inputs.xlsx";
		Workbook wb=null;
		
		try {
			 file=new FileInputStream(path);
		}catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		try {
			 wb=WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sheet sheet=wb.getSheet(sheetname);
		
		int lastrow=sheet.getLastRowNum();
		int lastcoloum=sheet.getRow(1).getLastCellNum();
		System.out.println("row="+lastrow+ "colum="+lastcoloum);
		
		Object[][] inputs=new String[lastrow][lastcoloum];
		
		for(int i=1;i<=lastcoloum;i++) {
			for(int j=0; j<lastrow;j++) {
				int t=i-1;
				inputs[t][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				
			}
		}
		
				
		for(int i=0;i<lastcoloum;i++) {
			for(int j=0; j<lastrow;j++) {
				
				System.out.println(inputs[i][j]);
			}
		}
		
		return inputs;
		
			
	}
	
	
	
	public static void takescreenshot() {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src, new File("C:\\Users\\user\\eclipse-workspace\\SKERP\\ScreenShot\\"+System.currentTimeMillis()+".png"));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		}
	
	
	public static void captureScreenshotForFailedTest(String methodname) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File( "C:\\Users\\user\\eclipse-workspace\\SKERP\\ScreenShot\\"+methodname+".png"));
	}

    
	public static void selectvaluebyvalue(WebElement element,String value) throws InterruptedException {
		Select select=new Select(element);
		Thread.sleep(100);
		select.selectByVisibleText(value);
	}

	public static void selectvaluebyindex(WebElement element,int value) throws InterruptedException {
		Select select=new Select(element);
		Thread.sleep(100);
		select.selectByIndex(value);;
	}

   public static void AutoBox(WebElement element,String value) throws InterruptedException {
	   element.sendKeys(value);
		
		List<WebElement> elemt=driver.findElements(By.xpath(".//ul/li[@ng-click='selectMatch($index)']"));
		Iterator<WebElement> iterator=elemt.iterator();
		
		try {
		while(iterator.hasNext()) {
		for(int i=0;i<elemt.size();i++) {
			System.out.println(elemt.get(i).getText());
			if(elemt.get(i).getText().contains(value)) {
				
				elemt.get(i).click();
				break;
			}
		}
		}}catch (Exception e) {
			System.out.println("Franchise not found");
		}
	   
   }
   


}

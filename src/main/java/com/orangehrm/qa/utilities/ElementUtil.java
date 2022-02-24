package com.orangehrm.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.qa.constants.Constants;

public class ElementUtil {
	WebDriver driver;//driver object
	
	static Properties pro=new Properties();///property file object
	
	
	//default constructor
	public ElementUtil() {
				
		File src=new File(Constants.configpath); //connecting to constants.java configpath

		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
	}
	}

//parameterized constructor
	public ElementUtil(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	public String getUsername()
	{
		String username= pro.getProperty("username");
		return username;
	}
	public String getPassword()
	{
		String password =pro.getProperty("password");
		return password;
		
	}
	
	public String getBaseurl() {
		
		String baseurl=pro.getProperty("baseUrl");
		return baseurl;
		
	}
	
	public  void clickMethod(WebElement e)
	{
		e.click();
	}
	
	
	public void sendKeys(WebElement s,String value)
		{
		s.clear();
		s.sendKeys(value);
	   }


	///propertyFile
	
	public static String getPropertyValue(String key)
	{

		String propertyFile=System.getProperty("user.dir")+"/Configuration/config.properties";
		FileInputStream fis=null;
		try {
			fis = new FileInputStream (propertyFile);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			pro.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}
		String value=pro.get(key).toString();
		return value;
	}


	//Dropdown
	
	public void selectDropDown(WebElement element,String type,String value)
	{
		
		  Select Dd =new Select(element);
		  
		 switch(type){
		 case "index":
		  Dd.selectByIndex(Integer.parseInt(value));
		  break;
		 case "visibleText":
		  Dd.selectByVisibleText(value);
		 case "value":
			  Dd.selectByValue(value);
		  
		 }
		 
		 
//		  List<WebElement>ddlist=Dd.getOptions();
//		  
//		  for(int i=0;i<ddlist.size();i++)
//		  {
//			  System.out.println(ddlist.get(i).getText()); 
//		  }
		  
		}

	public  boolean enableCheck(WebElement element) {
		
		boolean en=element.isEnabled();
		return en;
		
	}

	public void click(WebElement element) {
		element.click();
		
	}
	//Display check
	public boolean displayCheck(WebElement element) {
		System.out.println("displayCheck"+element);
		boolean en=element.isDisplayed();
		return en;
		
		
	}
	
	public String currentUrlCheck()
	{
	
		String url=driver.getCurrentUrl();
		return url;
		
		
	}
	
	
//web table element check
	
	
		
	
	 
	  public  void webTableEx( List<WebElement> tableCols,List<WebElement> tableRows,String username) {
		  //column size
		  List<WebElement>tableCol=tableCols;
		  int col_size=tableCol.size();
		  
		  //row size
		  List<WebElement>tableRow=tableRows;
		  int row_size=tableRow.size(); 
	 
		  //Print all rows and columns
		  
		  System.out.println("record searched "+username);
		  for(int i=0;i<row_size;i++)
		  {
			  List<WebElement>currrentrow=tableRow.get(i).findElements(By.tagName("td"));
			  System.out.println(" print record searched "+username);
			  for(int j=0;j<col_size;j++)
			  {
				String data=currrentrow.get(j).getText();
				System.out.print("     " +data+ "     "); 
			  }
			  System.out.println();
		  }
		  }
		  
		  
	  
//		  for(int i=0;i<row_size;i++)
//		  {
//			  List<WebElement>currrentrow=tableRow.get(i).findElements(By.tagName("td"));
//			  for(int j=0;j<col_size;j++)
//			  {
//				String data=currrentrow.get(j).getText();
//				if(data=="Orange Test") 
//				{
//				System.out.println("record found in table"+data+"row"+i+"column"+j); 
//				break;
//				}
//				else 
//				System.out.println("record not  avaialble"); 
//					
//				
//			  }
//		  }
		  
		  
	  
	//web table element check
	


	  public void fileupload(WebElement file,String filepath) {
		  
	
		  file.sendKeys("filepath");
		 
		  
	  }
		 
//Mouse hover
	  
	  public void mousehover(WebElement h)
	  {
	  	Actions act=new Actions(driver);

	  	act.moveToElement(h).build().perform();
	  	
	  }	

	  
	
//end of class
}
	


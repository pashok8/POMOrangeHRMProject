package com.orangehrm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.orangehrm.qa.utilities.ElementUtil;

public class LoginPage {

	WebDriver driver;
	ElementUtil util1;
	
	@FindBy(id="txtUsername")
	WebElement username;

	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement login;
	
	@FindBy(id="divLogo") 
	WebElement logo;
	
	public void loginAction(String a, String b)
	{
		System.out.println("username"+a);
		System.out.println("password"+b);
		util1.sendKeys(username,a);
		util1.sendKeys(password,b);
		util1.clickMethod(login);
		
	}
	 
	public LoginPage(WebDriver driver) {
		Assert.assertNotNull(driver);
		this.driver=driver; //assign value to login page webdriver
		PageFactory.initElements(driver, this);//this is usedto  get all webelements
		 util1=new ElementUtil();
		
		}

	
}

package com.orangehrm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.utilities.ElementUtil;
import com.orangehrm.qa.utilities.WaitUtil;

public class AddUserPage {
	
//class aggregation	
	WebDriver driver;
	ElementUtil util;
	WaitUtil wait;
	
//locators	
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement adminTab;
	@FindBy(id="systemUser_userType")
	WebElement roleDD;
	@FindBy(id="systemUser_employeeName_empName")
	WebElement empName;
	@FindBy(id="btnAdd")
	WebElement addUserBtn;
	@FindBy(id="systemUser_userName")
	WebElement userName;
	@FindBy(id="systemUser_status")
	WebElement userStatusDd;
	@FindBy(id="systemUser_password")
	WebElement userPassword;
	
	@FindBy(id="systemUser_confirmPassword")
	WebElement confirmPassword;
	
	@FindBy(id="btnSave")
	WebElement saveBtn;
	@FindBy(id="btnCancel")
	WebElement cancelBtn;




//
public AddUserPage(WebDriver driver) {
	
	
	this.driver=driver; //assign value to admin page webdriver
	PageFactory.initElements(driver, this);//this is used to  get all webelements
	 util=new ElementUtil(driver);//object of elementutil class
	wait=new WaitUtil(driver);
}



public void adduserdetails(String employeename,String user,String password,String confirmpswd)
{
	util.click(adminTab);
	util.click(addUserBtn);
	util.clickMethod(roleDD);
	util.selectDropDown(roleDD,"index","1");
	util.sendKeys(empName, employeename);
	util.sendKeys(userName, user);
	util.sendKeys(userPassword, password);
	util.sendKeys(confirmPassword, confirmpswd);
	util.click(saveBtn);
	
}

//end of class
}
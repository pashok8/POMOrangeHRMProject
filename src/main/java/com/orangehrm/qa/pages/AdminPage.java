package com.orangehrm.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.orangehrm.qa.utilities.ElementUtil;
import com.orangehrm.qa.utilities.WaitUtil;

public class AdminPage {

	WebDriver driver;
	ElementUtil util;
	WaitUtil wait;
	
	
	
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement adminTab;
	@FindBy(id="welcome")
	WebElement welcomeTag;
	@FindBy(id="btnAdd")
	WebElement addUserBtn;
	@FindBy(id="btnDelete")
	WebElement deletebtn;
	
//search
	
	@FindBy(id ="systemUser-information")
	WebElement systemUsers;
	@FindBy(id="searchSystemUser_userName")
	WebElement searchSystemUser;
	@FindBy(id="searchSystemUser_userType")
	WebElement searchUserRoleDD;
	
	@FindBy(id="searchSystemUser_employeeName_empName")
	WebElement searchSystemEmpName;
	@FindBy(id="searchSystemUser_status")
	WebElement searchSystemuserStatusDd;
	@FindBy(id="searchBtn")
	WebElement searchBtn;
	@FindBy(id="resetBtn")
	WebElement resetBtn;
	@FindBy(xpath="//*[@id=\"resultTable\"]/tbody/tr/td")
	WebElement record;
	@FindBy(id="ohrmList_chkSelectAll")
	WebElement chkSelectAll;
	@FindBy(id="resultTable")
	WebElement resultTable;
	@FindBy(xpath="//*[@id=\"resultTable\"]/thead/tr/th")
	 List<WebElement>tableCols;
	@FindBy(xpath="//*[@id=\"resultTable\"]/tbody/tr")
	List<WebElement>tableRows;
	
	public AdminPage(WebDriver driver) {
		
		Assert.assertNotNull(driver);
		this.driver=driver; //assign value to admin page webdriver
		PageFactory.initElements(driver, this);//this is used to  get all webelements
		util=new ElementUtil(driver);//object of elementutil class
		wait=new WaitUtil(driver);
		
	}
	
	
	public void selectAdminTab() {
		util.click(adminTab);
		
	}
	
	public void adminTabElements() {
		util.click(adminTab);
		util.enableCheck(systemUsers);
		util.displayCheck(addUserBtn);
		util.displayCheck(resetBtn);
		util.displayCheck(searchBtn);
	
		
	
			
	}
	
	public void adduser()
	{
		util.click(addUserBtn);
	
		
	}
	
	public void searchUser(String name)
	{
		util.click(adminTab);
		util.displayCheck(systemUsers);
		util.selectDropDown(searchUserRoleDD,"index","0");
		util.sendKeys(searchSystemEmpName, name);
		util.click(searchBtn);
		util.mousehover(resultTable);
		
		
	}
	public void resetSearch()
	{
		util.clickMethod(resetBtn);
		
	}
	
public void SearchrecordDisplayedcheck(String name)
{
	
	util.webTableEx(tableCols,tableRows,name);	
		
}
	
	public void selectAll()
	{
		wait.waitForElementClick(chkSelectAll);
		util.clickMethod(chkSelectAll);
		//util.clickMethod(deletebtn);///don't do this step
		
		
	}
	
	


	



	
	
	
	
	
}

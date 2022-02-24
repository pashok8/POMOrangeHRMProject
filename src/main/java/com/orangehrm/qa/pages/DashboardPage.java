package com.orangehrm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.orangehrm.qa.utilities.ElementUtil;
import com.orangehrm.qa.utilities.WaitUtil;

public class DashboardPage {
	
	WebDriver driver;
	ElementUtil util;
	WaitUtil wait;

	public DashboardPage(WebDriver driver) {
		Assert.assertNotNull(driver);
		this.driver=driver; //assign value to admin page webdriver
		PageFactory.initElements(driver, this);//this is used to  get all webelements
		util=new ElementUtil(driver);//object of elementutil class
		wait=new WaitUtil(driver);
	}
	
	
	//Locators
	

	@FindBy(id="menu_dashboard_index")
	WebElement dashboardTab;

	@FindBy(id="dashboard-quick-launch-panel-menu_holder")
	WebElement Quicklaunch;
	@FindBy(xpath ="/*[@id=\"dashboard-quick-launch-panel-menu_holder\"]/table/tbody/tr/td[1]/div/a/span")
	WebElement assign_Leave;

	@FindBy(id="")
	WebElement leaveList;

	@FindBy(id="")
	WebElement timesheets;

	@FindBy(id="")
	WebElement applyLeave;

	@FindBy(id="")
	WebElement myLeave;
	
	@FindBy(id="")
	WebElement myTimesheet;
	
	@FindBy(id="")
	WebElement employeeDistributionBox;

	@FindBy(id="")
	WebElement legendbox;

	@FindBy(id="")
	WebElement pendingLeaveBox;




public void dashboardElementCheck()
{
	util.click(dashboardTab);
	util.displayCheck(Quicklaunch);
	util.mousehover(assign_Leave);
	util.mousehover(leaveList);
	util.mousehover(timesheets);
	util.mousehover(applyLeave);
	util.mousehover(myLeave);
	util.mousehover(myTimesheet);
	util.mousehover(employeeDistributionBox);
	util.mousehover(legendbox);
	util.mousehover(pendingLeaveBox);
}


}//end of class

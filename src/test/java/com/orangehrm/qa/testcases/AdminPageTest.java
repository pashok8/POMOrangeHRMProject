package com.orangehrm.qa.testcases;


import org.testng.annotations.Test;

import com.orangehrm.qa.constants.Constants;





import org.testng.Assert;


public class AdminPageTest extends BasePageTest{
	
	@Test
	public void verifyLogin()//verify
	{
		loginpage.loginAction(user,pass);
		 String title= driver.getTitle();
		 Assert.assertEquals(title, Constants.loginpagetitle);
		 
	}

	@Test(priority=2)
	public void verifyAdminPage()
	{
		System.out.println("adminPageCheck");
		adminpage.selectAdminTab();
		adminpage.resetSearch();
		adminpage.searchUser("Orange Test");
		
}
	
	@Test(priority=3)
	public void verifyAdminPageSearchRecordDisplayed()
	{
		adminpage.searchUser("Orange Test");
		adminpage.SearchrecordDisplayedcheck("Orange Test");
	}
	
	@Test(priority=4)
	public void adminPageselectAllUser()
	{
	adminpage.selectAll();
	}
	
	
}//end class
